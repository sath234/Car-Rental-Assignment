package VehicleAndClientObjects;

import java.time.LocalDate;
import java.util.Scanner;

public class Lorry extends Vehicle{

    private boolean small;
    private boolean crane;
    private boolean tailgate;
    private boolean forkLift;

    public Lorry() {
    }

    public Lorry(String numberPlate, int price, LocalDate startDate, LocalDate returnDate, int weeksOfRent, int customerID, boolean small, boolean crane, boolean tailgate, boolean forkLift) {
        super(numberPlate, price, startDate, returnDate, weeksOfRent, customerID);
        this.small = small;
        this.crane = crane;
        this.tailgate = tailgate;
        this.forkLift = forkLift;
    }

    public boolean isSmall() {
        return small;
    }

    public void setSmall(boolean small) {
        this.small = small;
    }

    public boolean isCrane() {
        return crane;
    }

    public void setCrane(boolean crane) {
        this.crane = crane;
    }

    public boolean isTailgate() {
        return tailgate;
    }

    public void setTailgate(boolean tailgate) {
        this.tailgate = tailgate;
    }

    public boolean isForkLift() {
        return forkLift;
    }

    public void setForkLift(boolean forkLift) {
        this.forkLift = forkLift;
    }



    @Override
    public boolean leaseOut() {
        Scanner stdin = new Scanner(System.in);
        boolean allowed = true;
        System.out.println("do you have more than 4 points on your license (y/n)");
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
