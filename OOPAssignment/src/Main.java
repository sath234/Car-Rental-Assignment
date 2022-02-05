import VehicleAndClientObjects.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("####################################################################################################################################");
        System.out.println("################################################ WELCOME TO MOVEIT VEHICLE HIRE! ###################################################");
        System.out.println("####################################################################################################################################");
        System.out.println();
        ClientDatabase customerClientDatabase = new ClientDatabase("src/Files/CustomerRecords.csv");
        LinkedList<Customer> customers = customerClientDatabase.linkedListCustomers();
        ClientDatabase businessClientDatabase = new ClientDatabase("src/Files/BusinessRecords.csv");
        LinkedList<Business> businesses = businessClientDatabase.linkedListBusinesses();
        listOptions(customers,businesses);
    }

    public static void listOptions(LinkedList<Customer> customers, LinkedList<Business> businesses) throws IOException {
        stdin = new Scanner(System.in);
        System.out.println();
        System.out.println("Please chose what you would like to do from the selection below:\n" +
                "Register a individual: 1\n" +
                "Register a business: 2\n"+
                "See available vehicles: 3\n" +
                "Hire a vehicle: 4\n" +
                "See vehicle History: 5\n" +
                "Update Customer/Business details: 6\n"+
                "Exit Application: 7");
        int option = Integer.parseInt(stdin.next());
        switch (option){
            case 1:
                addCustomer("src/Files/CustomerRecords.csv", customers ,businesses);;
                break;
            case 2:
                addBusiness("src/Files/BusinessRecords.csv",  customers, businesses);
                break;
            case 3:
                seeAvaliableVehicles(customers,businesses);
                break;
            case 4:
                hireAVehicle(customers,businesses);
                break;
            case 5:
                viewWhenVehiclesHistory(customers,businesses);
                break;
            case 6:
                updateDetails(customers,businesses);
                break;
            case 7:
                System.out.println("Thanks for using MOVEIT Vehicle Hire please come again");
                break;
            default:
                System.out.println("Invalid input");
        }
    }

    public static void updateDetails(LinkedList<Customer> customers, LinkedList<Business> businesses) throws IOException {
        stdin = new Scanner(System.in);
        EditCustomerBusiness update = new EditCustomerBusiness();
        System.out.println("Select which you would like to update:\n" +
                "1 - Customer Details\n" +
                "2 - Business Details\n");
        int response = Integer.parseInt(stdin.nextLine());
        if (response == 1){
            LinkedList<Customer> updatedCustomers = update.updateCustomerDetails(customers);
            System.out.println("Your details have been update");
            listOptions(updatedCustomers,businesses);
        }else if(response == 2){
            LinkedList<Business> updatedBusinesses = update.updateBusinessDetails(businesses);
            System.out.println("Your details have been update");
            listOptions(customers,updatedBusinesses);
        }else{
            System.out.println("You haven't entered a valid option restart the programme");
        }
    }

    public static void seeAvaliableVehicles(LinkedList<Customer> customers, LinkedList<Business> businesses) throws IOException {
        stdin = new Scanner(System.in);
        System.out.println("Chose the vehicle you wish to see the Availability from the list below:\n" +
                "1 - Crane Lorry\n" +
                "2 - ForkLift Lorry\n" +
                "3 - Small Lorry\n" +
                "4 - Tailgate Lorry\n" +
                "5 - Large Van\n" +
                "6 - Small Van\n" +
                "7 - Pickup Truck\n");
        DateChecker checkAvaliable = new DateChecker();
        int reply = Integer.parseInt(stdin.nextLine());
        switch (reply){
            case 1:
                VehicleDatabase craneLorry = new VehicleDatabase("src/Files/Lorries/CraneLorryHire.csv");
                craneLorry.loadLorries();
                ArrayList<Lorry> craneLorries = craneLorry.getAllLorries();
                System.out.println("Dates already booked");
                System.out.println("Start Date\t\tEnd Date");
                for (Lorry lorry: craneLorries){
                    if (lorry.getReturnDate().isAfter(LocalDate.now()) || lorry.getReturnDate().isEqual(LocalDate.now())){
                        System.out.printf(lorry.getStartDate()+"\t\t"+lorry.getReturnDate()+"\n");
                    }
                }
                System.out.println();

                String[] dateInfo1 = checkAvaliable.dateChecker("src/Files/Lorries/CraneLorryHire.csv","lorry");
                System.out.println("The vehicle is available between "+dateInfo1[0]+" and the "+dateInfo1[1]);

                break;
            case 2:
                VehicleDatabase forkLiftLorry = new VehicleDatabase("src/Files/Lorries/ForkliftLorryHire.csv");
                forkLiftLorry.loadLorries();
                ArrayList<Lorry> forkLiftLorries = forkLiftLorry.getAllLorries();
                System.out.println("Dates already booked");
                System.out.println("Start Date\t\tEnd Date");
                for (Lorry lorry: forkLiftLorries){
                    System.out.printf(lorry.getStartDate()+"\t\t"+lorry.getReturnDate()+"\n");
                }
                System.out.println();

                String[] dateInfo2 = checkAvaliable.dateChecker("src/Files/Lorries/ForkliftLorryHire.csv","lorry");
                System.out.println("The vehicle is available between "+dateInfo2[0]+" and the "+dateInfo2[1]);

                break;
            case 3:
                VehicleDatabase smallLorry = new VehicleDatabase("src/Files/Lorries/SmallLorryHire.csv");
                smallLorry.loadLorries();
                ArrayList<Lorry> smallLorries = smallLorry.getAllLorries();
                System.out.println("Dates already booked");
                System.out.println("Start Date\t\tEnd Date");
                for (Lorry lorry: smallLorries){
                    if (lorry.getReturnDate().isAfter(LocalDate.now()) || lorry.getReturnDate().isEqual(LocalDate.now())){
                        System.out.printf(lorry.getStartDate()+"\t\t"+lorry.getReturnDate()+"\n");
                    }
                }
                System.out.println();

                String[] dateInfo3 = checkAvaliable.dateChecker("src/Files/Lorries/SmallLorryHire.csv","lorry");
                System.out.println("The vehicle is available between "+dateInfo3[0]+" and the "+dateInfo3[1]);

                break;
            case 4:
                VehicleDatabase tailgateLorry = new VehicleDatabase("src/Files/Lorries/TailgateLorryHire.csv");
                tailgateLorry.loadLorries();
                ArrayList<Lorry> tailgateLorries = tailgateLorry.getAllLorries();
                System.out.println("Dates already booked");
                System.out.println("Start Date\t\tEnd Date");
                for (Lorry lorry: tailgateLorries){
                    if (lorry.getReturnDate().isAfter(LocalDate.now()) || lorry.getReturnDate().isEqual(LocalDate.now())){
                        System.out.printf(lorry.getStartDate()+"\t\t"+lorry.getReturnDate()+"\n");
                    }
                }
                System.out.println();

                String[] dateInfo4 = checkAvaliable.dateChecker("src/Files/Lorries/TailgateLorryHire.csv","lorry");
                System.out.println("The vehicle is available between "+dateInfo4[0]+" and the "+dateInfo4[1]);

                break;
            case 5:
                VehicleDatabase largeVan = new VehicleDatabase("src/Files/Vans/LargeVanHire.csv");
                largeVan.loadVans();
                ArrayList<Van> largeVans = largeVan.getAllVans();
                System.out.println("Dates already booked");
                System.out.println("Start Date\t\tEnd Date");
                for (Van van: largeVans){
                    if (van.getReturnDate().isAfter(LocalDate.now()) || van.getReturnDate().isEqual(LocalDate.now())){
                        System.out.printf(van.getStartDate()+"\t\t"+van.getReturnDate()+"\n");
                    }
                }
                System.out.println();

                String[] dateInfo5 = checkAvaliable.dateChecker("src/Files/Vans/LargeVanHire.csv","van");
                System.out.println("The vehicle is available between "+dateInfo5[0]+" and the "+dateInfo5[1]);
                break;
            case 6:
                VehicleDatabase smallVan = new VehicleDatabase("src/Files/Vans/SmallVanHire.csv");
                smallVan.loadVans();
                ArrayList<Van> smallVans = smallVan.getAllVans();
                System.out.println("Dates already booked");
                System.out.println("Start Date\t\tEnd Date");
                for (Van van: smallVans){
                    if (van.getReturnDate().isAfter(LocalDate.now()) || van.getReturnDate().isEqual(LocalDate.now())){
                        System.out.printf(van.getStartDate()+"\t\t"+van.getReturnDate()+"\n");
                    }
                }
                System.out.println();

                String[] dateInfo6 = checkAvaliable.dateChecker("src/Files/Vans/SmallVanHire.csv","van");
                System.out.println("The vehicle is available between "+dateInfo6[0]+" and the "+dateInfo6[1]);

                break;
            case 7:
                VehicleDatabase PickupTruck = new VehicleDatabase("src/Files/PickupTruckHire.csv");
                PickupTruck.loadPickupTrucks();
                ArrayList<PickupTruck> pickupTrucks = PickupTruck.getAllPickupTrucks();
                System.out.println("Dates already booked");
                System.out.println("Start Date\t\tEnd Date");
                for (PickupTruck pickupTruck: pickupTrucks){
                    if (pickupTruck.getReturnDate().isAfter(LocalDate.now()) || pickupTruck.getReturnDate().isEqual(LocalDate.now())){
                        System.out.printf(pickupTruck.getStartDate()+"\t\t"+pickupTruck.getReturnDate()+"\n");
                    }
                }
                System.out.println();

                String[] dateInfo7 = checkAvaliable.dateChecker("src/Files/PickupTruckHire.csv","pickup truck");
                System.out.println("The vehicle is available between "+dateInfo7[0]+" and the "+dateInfo7[1]);

                break;
        }
        listOptions(customers,businesses);
    }

    public static void hireAVehicle(LinkedList<Customer> customers, LinkedList<Business> businesses) throws IOException {
        stdin = new Scanner(System.in);
        System.out.println("What type of vehicle do you want to book:\n" +
                "1 - Lorry\n" +
                "2 - Van\n" +
                "3 - PickupTruck");
        int choice = Integer.parseInt(stdin.nextLine());
        switch (choice){
            case 1:
                Book bookLorry = new Book();
                bookLorry.bookVehicle("Lorry");
                break;
            case 2:
                Book bookVan = new Book();
                bookVan.bookVehicle("Van");
                break;
            case 3:
                Book bookPickupTruck = new Book();
                bookPickupTruck.bookVehicle("Pickup Truck");
                break;
            default:
                System.out.println("You've put in the wrong option please start again");
        }
        listOptions(customers,businesses);
    }

    public static void viewWhenVehiclesHistory(LinkedList<Customer> customers, LinkedList<Business> businesses) throws IOException {
        stdin = new Scanner(System.in);
        System.out.println("Chose the vehicle you wish to see the history of from the list below:\n" +
                "1 - Crane Lorry\n" +
                "2 - ForkLift Lorry\n" +
                "3 - Small Lorry\n" +
                "4 - Tailgate Lorry\n" +
                "5 - Large Van\n" +
                "6 - Small Van\n" +
                "7 - Pickup Truck\n");
        int reply = Integer.parseInt(stdin.nextLine());
        switch (reply){
            case 1:
                VehicleDatabase craneLorry = new VehicleDatabase("src/Files/Lorries/CraneLorryHire.csv");
                craneLorry.loadLorries();
                ArrayList<Lorry> craneLorries = craneLorry.getAllLorries();
                System.out.println("CustomerId\t\tStart Date\t\tEnd Date");
                for (Lorry lorry: craneLorries){
                    System.out.printf(lorry.getCustomerID()+"\t\t"+lorry.getStartDate()+"\t\t"+lorry.getReturnDate()+"\n");
                }
                break;
            case 2:
                VehicleDatabase forkLiftLorry = new VehicleDatabase("src/Files/Lorries/ForkliftLorryHire.csv");
                forkLiftLorry.loadLorries();
                ArrayList<Lorry> forkLiftLorries = forkLiftLorry.getAllLorries();
                System.out.println("CustomerId\t\tStart Date\t\tEnd Date");
                for (Lorry lorry: forkLiftLorries){
                    System.out.printf(lorry.getCustomerID()+"\t\t"+lorry.getStartDate()+"\t\t"+lorry.getReturnDate()+"\n");
                }
                break;
            case 3:
                VehicleDatabase smallLorry = new VehicleDatabase("src/Files/Lorries/SmallLorryHire.csv");
                smallLorry.loadLorries();
                ArrayList<Lorry> smallLorries = smallLorry.getAllLorries();
                System.out.println("CustomerId\t\tStart Date\t\tEnd Date");
                for (Lorry lorry: smallLorries){
                    System.out.printf(lorry.getCustomerID()+"\t\t"+lorry.getStartDate()+"\t\t"+lorry.getReturnDate()+"\n");
                }
                break;
            case 4:
                VehicleDatabase tailgateLorry = new VehicleDatabase("src/Files/Lorries/TailgateLorryHire.csv");
                tailgateLorry.loadLorries();
                ArrayList<Lorry> tailgateLorries = tailgateLorry.getAllLorries();
                System.out.println("CustomerId\t\tStart Date\t\tEnd Date");
                for (Lorry lorry: tailgateLorries){
                    System.out.printf(lorry.getCustomerID()+"\t\t"+lorry.getStartDate()+"\t\t"+lorry.getReturnDate()+"\n");
                }
                break;
            case 5:
                VehicleDatabase largeVan = new VehicleDatabase("src/Files/Vans/LargeVanHire.csv");
                largeVan.loadVans();
                ArrayList<Van> largeVans = largeVan.getAllVans();
                System.out.println("CustomerId\t\tStart Date\t\tEnd Date");
                for (Van van: largeVans){
                    System.out.printf(van.getCustomerID()+"\t\t"+van.getStartDate()+"\t\t"+van.getReturnDate()+"\n");
                }
                break;
            case 6:
                VehicleDatabase smallVan = new VehicleDatabase("src/Files/Vans/SmallVanHire.csv");
                smallVan.loadVans();
                ArrayList<Van> smallVans = smallVan.getAllVans();
                System.out.println("CustomerId\t\tStart Date\t\tEnd Date");
                for (Van van: smallVans){
                    System.out.printf(van.getCustomerID()+"\t\t"+van.getStartDate()+"\t\t"+van.getReturnDate()+"\n");
                }
                break;
            case 7:
                VehicleDatabase PickupTruck = new VehicleDatabase("src/Files/PickupTruckHire.csv");
                PickupTruck.loadPickupTrucks();
                ArrayList<PickupTruck> pickupTrucks = PickupTruck.getAllPickupTrucks();
                System.out.println("CustomerId\t\tStart Date\t\tEnd Date");
                for (PickupTruck pickupTruck: pickupTrucks){
                    System.out.printf(pickupTruck.getCustomerID()+"\t\t"+pickupTruck.getStartDate()+"\t\t"+pickupTruck.getReturnDate()+"\n");
                }
                break;
        }
        listOptions(customers,businesses);
    }

    public static void addCustomer(String filePath, LinkedList<Customer> customers, LinkedList<Business> businesses) throws IOException {
        stdin = new Scanner(System.in);

        ClientDatabase customer = new ClientDatabase("src/Files/CustomerRecords.csv");
        ClientDatabase business = new ClientDatabase("src/Files/BusinessRecords.csv");
        customer.loadCustomer();
        ArrayList<Customer> customerids = customer.getAllCustomers();
        business.loadBusiness();
        ArrayList<Business> businessids = business.getAllBusniesses();

        int newCustomer = 0;
        if (Integer.parseInt(businessids.get(0).getCustomerID()) > Integer.parseInt(customerids.get(0).getCustomerID())){
            newCustomer = Integer.parseInt(businessids.get(0).getCustomerID()) + 1;
        }else {
            newCustomer = Integer.parseInt(customerids.get(0).getCustomerID()) + 1;
        }

        ClientDatabase clientDatabase = new ClientDatabase(filePath);
        System.out.println("Please fill in you customer details:");
        System.out.print("First name: ");
        String FirstName = FormatCheckers.returnStringWhenNoNumbers();
        System.out.print("Last name: ");
        String LastName = FormatCheckers.returnStringWhenNoNumbers();
        System.out.print("Phone number: ");
        String Phonenumber = FormatCheckers.returnCorrectPhoneNumberFormat();
        System.out.print("Email: ");
        String Email = FormatCheckers.checkCorrectEmail();
        System.out.print("Address: ");
        String address = stdin.nextLine();
        String addressNoSpaces = address.replace(' ','_');
        System.out.print("Postcode (no spaces): ");
        String Postcode = FormatCheckers.returnCorrectPostcodeFormat();
        System.out.print("Card Number: ");
        String CardNumber = FormatCheckers.returnCorrectCardNumberFormat();

        Customer addNewCustomer = new Customer(String.valueOf(newCustomer),FirstName,LastName,Phonenumber,Email,addressNoSpaces,Postcode,CardNumber);
        System.out.println();
        System.out.println("Are you happy with the details you have entered (y/n)");
        addNewCustomer.printDetails();
        String reply = stdin.nextLine();

        if (reply.equals("y")){
            try{
                clientDatabase.loadCustomer();
                clientDatabase.addCustomer(String.valueOf(newCustomer),FirstName,LastName,Phonenumber,Email,addressNoSpaces,Postcode,CardNumber);
                clientDatabase.saveCustomer();
                customers = clientDatabase.linkedListCustomers();
                System.out.println("Your customer details have been added successfully");
            }catch (Exception ex){
                System.out.println("Sorry an Error has occurred please restart the program");
            }
        }if (reply.equals("n")){
            System.out.println("Please go back to the main menu and try again");
        }
        listOptions(customers,businesses);
    }


    public static void addBusiness(String filePath, LinkedList<Customer> customers, LinkedList<Business> businesses) throws IOException{
        stdin = new Scanner(System.in);
        ClientDatabase clientDatabase = new ClientDatabase(filePath);

        ClientDatabase customer = new ClientDatabase("src/Files/CustomerRecords.csv");
        ClientDatabase business = new ClientDatabase("src/Files/BusinessRecords.csv");
        customer.loadCustomer();
        ArrayList<Customer> customerids = customer.getAllCustomers();
        business.loadBusiness();
        ArrayList<Business> businessids = business.getAllBusniesses();

        int newCustomer = 0;
        if (Integer.parseInt(businessids.get(0).getCustomerID()) > Integer.parseInt(customerids.get(0).getCustomerID())){
            newCustomer = Integer.parseInt(businessids.get(0).getCustomerID()) + 1;
        }else {
            newCustomer = Integer.parseInt(customerids.get(0).getCustomerID()) + 1;
        }


        System.out.println("Please fill in your business details\n");
        System.out.print("Business name: ");
        String businessName = stdin.nextLine();
        String businessNameNoSpaces = businessName.replace(' ','_');
        System.out.print("Employee first name: ");
        String employeeFirstName = FormatCheckers.returnStringWhenNoNumbers();
        System.out.print("Employee last name: ");
        String employeeLastName = FormatCheckers.returnStringWhenNoNumbers();
        System.out.print("Business Phone number: ");
        String businessPhoneNumber = FormatCheckers.returnCorrectPhoneNumberFormat();
        System.out.print("Business Email: ");
        String businessEmail = FormatCheckers.checkCorrectEmail();
        System.out.print("Business Address: ");
        String businessAddress = stdin.nextLine();
        String addressNoSpaces = businessAddress.replace(' ','_');
        System.out.print("Business Postcode (no spaces): ");
        String businessPostcode = FormatCheckers.returnCorrectPostcodeFormat();
        System.out.print("Business Card Number: ");
        String businessCardNumber = FormatCheckers.returnCorrectCardNumberFormat();
        System.out.print("Do you have insurance (true if you have or false if you need it): ");
        String insurance = stdin.nextLine();

        Business addNewBusiness = new Business(String.valueOf(newCustomer),businessNameNoSpaces,employeeFirstName,employeeLastName,businessPhoneNumber,businessEmail,addressNoSpaces,businessPostcode,insurance,businessCardNumber);
        System.out.println();
        System.out.println("Are you happy with the details you have entered (y/n)");
        addNewBusiness.printDetails();
        String reply = stdin.nextLine();
        if (reply.equals("y")){
            try{
                clientDatabase.loadBusiness();
                clientDatabase.addBusiness(String.valueOf(newCustomer),businessNameNoSpaces,employeeFirstName,employeeLastName,businessPhoneNumber
                        ,businessEmail,addressNoSpaces,businessPostcode,insurance,businessCardNumber);
                clientDatabase.saveBusiness();
                businesses = clientDatabase.linkedListBusinesses();
                System.out.println("Your business details have been added successfully");
            }catch (Exception ex){
                System.out.println("Sorry an Error has occurred please restart the program");
            }
        }if (reply.equals("n")){
            System.out.println("Please go back to the main menu and try again");
        }
        listOptions(customers,businesses);
    }
}

