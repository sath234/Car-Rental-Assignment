package VehicleAndClientObjects;

import java.time.LocalDate;
import java.util.Scanner;

public class PickupTruck extends Vehicle{

    public PickupTruck() {
    }

    public PickupTruck(String numberPlate, int price, LocalDate startDate, LocalDate returnDate, int weeksOfRent, int customerID) {
        super(numberPlate, price, startDate, returnDate, weeksOfRent, customerID);
    }

    @Override
    public boolean leaseOut() {
        Scanner stdin = new Scanner(System.in);
        boolean allowed = true;
        System.out.println("do you have more than 8 points on your license (y/n)");
        String answer =  stdin.nextLine();
        if (answer.equals("y")){
            System.out.println("you cannot hire this vehicle");
            allowed = false;
        }else if (answer.equals("n")){
            allowed = true;
        }
        return allowed;
    }
}
