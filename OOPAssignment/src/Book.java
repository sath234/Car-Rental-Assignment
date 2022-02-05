import VehicleAndClientObjects.Lorry;
import VehicleAndClientObjects.PickupTruck;
import VehicleAndClientObjects.Van;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Book {
    public void bookVehicle(String type) throws IOException {
        Scanner stdin = new Scanner(System.in);
        String message = "You have successfully booked the Vehicle for your selected time period.";
        System.out.println("Please enter your customerID");
        int customerId = Integer.parseInt(stdin.nextLine());
        if("Lorry".equals(type)){
            System.out.println("Which lorry would you like to book:\n" +
                    "1 - small crane lorry\n" +
                    "2 - tailgate lorry\n" +
                    "3 - forklift lorry\n" +
                    "4 - small lorry");
            int reply = Integer.parseInt(stdin.nextLine());
            if (reply == 1){

                Lorry bookedL = new Lorry();
                if (bookedL.leaseOut()){
                    VehicleDatabase smallCraneLorry = new VehicleDatabase("src/Files/Lorries/CraneLorryHire.csv");
                    DateChecker dates = new DateChecker();
                    String[] dateInfo = dates.dateChecker("src/Files/Lorries/CraneLorryHire.csv","lorry");
                    smallCraneLorry.loadLorries();
                    smallCraneLorry.addLorry("MI31JPE",400, LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,false,true,false,false);
                    smallCraneLorry.saveLorry();
                    System.out.println(message);

                    bookedL = new Lorry("MI31JPE",400, LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,false,true,false,false);
                    System.out.println("The vehicle was booked successfully");
                    System.out.println("That will cost you £"+bookedL.calcRent()+" and you have to return the vehicle by the "+dateInfo[1]);
                }
            } else if (reply == 2){
                Lorry bookedL = new Lorry();
                if (bookedL.leaseOut()){
                    VehicleDatabase tailGateLorry = new VehicleDatabase("src/Files/Lorries/TailgateLorryHire.csv");
                    DateChecker dates = new DateChecker();
                    String[] dateInfo = dates.dateChecker("src/Files/Lorries/TailgateLorryHire.csv","lorry");
                    tailGateLorry.loadLorries();
                    tailGateLorry.addLorry("RF76ZDQ",350,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,false,false,true,false);
                    tailGateLorry.saveLorry();
                    System.out.println(message);

                    bookedL = new Lorry("RF76ZDQ",350,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,false,false,true,false);
                    System.out.println("The vehicle was booked successfully");
                    System.out.println("That will cost you £"+bookedL.calcRent()+" and you have to return the vehicle by the "+dateInfo[1]);
                }

            }else if (reply == 3){
                Lorry bookedL = new Lorry();
                if (bookedL.leaseOut()){
                    VehicleDatabase forkliftLorry = new VehicleDatabase("src/Files/Lorries/ForkliftLorryHire.csv");
                    DateChecker dates = new DateChecker();
                    String[] dateInfo = dates.dateChecker("src/Files/Lorries/ForkliftLorryHire.csv","lorry");
                    forkliftLorry.loadLorries();
                    forkliftLorry.addLorry("DO87WXN",375,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,false,false,false,true);
                    forkliftLorry.saveLorry();
                    System.out.println(message);

                    bookedL = new Lorry("DO87WXN",375,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,false,false,false,true);
                    System.out.println("The vehicle was booked successfully");
                    System.out.println("That will cost you £"+bookedL.calcRent()+" and you have to return the vehicle by the "+dateInfo[1]);
                }

            }else if (reply == 4){
                Lorry bookedL = new Lorry();
                if (bookedL.leaseOut()){
                    VehicleDatabase smallLorry = new VehicleDatabase("src/Files/Lorries/SmallLorryHire.csv");
                    DateChecker dates = new DateChecker();
                    String[] dateInfo = dates.dateChecker("src/Files/Lorries/SmallLorryHire.csv","lorry");
                    smallLorry.loadLorries();
                    smallLorry.addLorry("PY08KWU",300,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,true,false,false,false);
                    smallLorry.saveLorry();
                    System.out.println(message);

                    bookedL = new Lorry("PY08KWU",300,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,true,false,false,false);
                    System.out.println("The vehicle was booked successfully");
                    System.out.println("That will cost you £"+bookedL.calcRent()+" and you have to return the vehicle by the "+dateInfo[1]);
                }
            }else{
                System.out.println("You've inputted the wrong number try again");
            }
        }else if("Van".equals(type)){
            System.out.println("Which Van would you like to rent:\n" +
                    "1 - small van\n" +
                    "2 - large van");
            int reply = Integer.parseInt(stdin.nextLine());
            if (reply == 1){
                Van bookedV = new Van();
                if (bookedV.leaseOut()){
                    VehicleDatabase smallVan = new VehicleDatabase("src/Files/Vans/SmallVanHire.csv");
                    DateChecker dates = new DateChecker();
                    String[] dateInfo = dates.dateChecker("src/Files/Vans/SmallVanHire.csv","van");
                    smallVan.loadVans();
                    smallVan.addVan("EE44MCI",150,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,true,false);
                    smallVan.saveVans();
                    System.out.println(message);

                    bookedV = new Van("EE44MCI",150,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,true,false);
                    System.out.println("The vehicle was booked successfully");
                    System.out.println("That will cost you £"+bookedV.calcRent()+" and you have to return the vehicle by the "+dateInfo[1]);
                }

            } else if (reply == 2){
                Van bookedV = new Van();
                if (bookedV.leaseOut()){
                    VehicleDatabase largeVan = new VehicleDatabase("src/Files/Vans/LargeVanHire.csv");
                    DateChecker dates = new DateChecker();
                    String[] dateInfo = dates.dateChecker("src/Files/Vans/LargeVanHire.csv","van");
                    largeVan.loadVans();
                    largeVan.addVan("CS73ROA",200,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,false,true);
                    largeVan.saveVans();
                    System.out.println(message);

                    bookedV = new Van("CS73ROA",200,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId,false,true);
                    System.out.println("The vehicle was booked successfully");
                    System.out.println("That will cost you £"+bookedV.calcRent()+" and you have to return the vehicle by the "+dateInfo[1]);
                }
            }
        }else if("Pickup Truck".equals(type)){
            PickupTruck bookedP = new PickupTruck();
            if (bookedP.leaseOut()){
                VehicleDatabase pickupTruck = new VehicleDatabase("src/Files/PickupTruckHire.csv");
                DateChecker dates = new DateChecker();
                String[] dateInfo = dates.dateChecker("src/Files/PickupTruckHire.csv","pickup truck");
                pickupTruck.loadPickupTrucks();
                pickupTruck.addPickupTruck("IH39XTL",100,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId);
                pickupTruck.savePickupTrucks();
                System.out.println(message);

                bookedP = new PickupTruck("IH39XTL",100,LocalDate.parse(dateInfo[0]),LocalDate.parse(dateInfo[1]),Integer.parseInt(dateInfo[2]),customerId);
                System.out.println("The vehicle was booked successfully");
                System.out.println("That will cost you £"+bookedP.calcRent()+" and you have to return the vehicle by the "+dateInfo[1]);
            }
        }
    }

}
