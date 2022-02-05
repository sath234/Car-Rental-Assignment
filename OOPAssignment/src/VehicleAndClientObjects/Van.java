package VehicleAndClientObjects;

import java.time.LocalDate;
import java.util.Scanner;

public class Van extends Vehicle{
    private boolean small;
    private boolean large;

    public Van() {
    }

    public Van(boolean small, boolean large) {
        this.small = small;
        this.large = large;
    }

    public Van(String numberPlate, int price, LocalDate startDate, LocalDate returnDate, int weeksOfRent, int customerID, boolean small, boolean large) {
        super(numberPlate, price, startDate, returnDate, weeksOfRent, customerID);
        this.small = small;
        this.large = large;
    }

    public boolean isSmall() {
        return small;
    }

    public void setSmall(boolean small) {
        this.small = small;
    }

    public boolean isLarge() {
        return large;
    }

    public void setLarge(boolean large) {
        this.large = large;
    }

    @Override
    public boolean leaseOut() {
        Scanner stdin = new Scanner(System.in);
        boolean allowed = true;
        System.out.println("do you have more than 6 points on your license (y/n)");
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
