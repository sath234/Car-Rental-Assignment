import VehicleAndClientObjects.Business;
import VehicleAndClientObjects.Customer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class EditCustomerBusiness {
    static Scanner stdin = new Scanner(System.in);

    public LinkedList<Customer> updateCustomerDetails(LinkedList<Customer> customers){
        UpdateClientRecords editInfo = new UpdateClientRecords();
        System.out.println("Enter your customer number");
        String customerNum = stdin.nextLine();

            ClientDatabase clientDatabase = new ClientDatabase("src/Files/CustomerRecords.csv");
            editInfo.deleteCustomerCsv(customerNum,"src/Files/CustomerRecords.csv");
            System.out.println("Please enter the updated details:");
            System.out.print("First name: ");
            String FirstName = stdin.nextLine();
            System.out.print("Last name: ");
            String LastName = stdin.nextLine();
            System.out.print("Phone number: ");
            String Phonenumber = stdin.nextLine();
            System.out.print("Email: ");
            String Email = (stdin.nextLine());
            System.out.print("Address: ");
            String address = stdin.nextLine();
            String addressNoSpaces = address.replace(' ','_');
            System.out.print("Postcode: ");
            String Postcode = stdin.nextLine();
            System.out.print("Card Number: ");
            String CardNumber = stdin.nextLine();
            try{
                clientDatabase.loadCustomer();
                clientDatabase.addCustomer(customerNum,FirstName,LastName,Phonenumber,Email,addressNoSpaces,Postcode,CardNumber);
                clientDatabase.saveCustomer();
                customers = clientDatabase.linkedListCustomers();
            }catch (Exception ex){
                System.out.println("Sorry an Error has occurred please restart the program");
            }
            return customers;
    }

    public LinkedList<Business> updateBusinessDetails(LinkedList<Business> businesses){
        UpdateClientRecords editInfo = new UpdateClientRecords();
        System.out.println("Enter your customer number");
        String customerNum = stdin.nextLine();

        ClientDatabase clientDatabase = new ClientDatabase("src/Files/BusinessRecords.csv");
        editInfo.deleteBusinessCsv(customerNum,"src/Files/BusinessRecords.csv");
        System.out.println("Please fill in your business details\n");
        System.out.print("Business name: ");
        String businessName = stdin.nextLine();
        String businessNameNoSpaces = businessName.replace(' ','_');
        System.out.print("Employee first name: ");
        String employeeFirstName = stdin.nextLine();
        System.out.print("Employee last name: ");
        String employeeLastName = stdin.nextLine();
        System.out.print("Business Phone number: ");
        String businessPhoneNumber = stdin.nextLine();
        System.out.print("Business Email: ");
        String businessEmail = stdin.nextLine();
        System.out.print("Business Address: ");
        String businessAddress = stdin.nextLine();
        String addressNoSpaces = businessAddress.replace(' ','_');
        System.out.print("Business Postcode (No spaces): ");
        String businessPostcode = stdin.nextLine();
        System.out.print("Business Card Number: ");
        String businessCardNumber = stdin.nextLine();
        System.out.print("Do you have insurance?: ");
        String insurance = stdin.nextLine();
        try{
            clientDatabase.loadBusiness();
            clientDatabase.addBusiness(customerNum,businessNameNoSpaces,employeeFirstName,employeeLastName,businessPhoneNumber
                    ,businessEmail,addressNoSpaces,businessPostcode,insurance,businessCardNumber);
            clientDatabase.saveBusiness();
            businesses = clientDatabase.linkedListBusinesses();
        }catch (Exception ex){
            System.out.println("Sorry an Error has occurred please restart the program");
        }
        return businesses;
    }
}
