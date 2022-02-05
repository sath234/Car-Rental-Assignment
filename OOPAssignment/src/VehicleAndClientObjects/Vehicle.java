package VehicleAndClientObjects;

import java.time.LocalDate;

public abstract class Vehicle implements VehicleInterface{
    private String numberPlate;
    private int price;
    private LocalDate startDate;
    private LocalDate returnDate;
    private int weeksOfRent;
    private int CustomerID;

    public Vehicle() {
    }

    public Vehicle(String numberPlate, int price, LocalDate startDate, LocalDate returnDate, int weeksOfRent, int customerID) {
        this.numberPlate = numberPlate;
        this.price = price;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.weeksOfRent = weeksOfRent;
        CustomerID = customerID;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getWeeksOfRent() {
        return weeksOfRent;
    }

    public void setWeeksOfRent(int weeksOfRent) {
        this.weeksOfRent = weeksOfRent;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    @Override
    public double calcRent(){
        double result=0;
        result= this.price*this.weeksOfRent*7;
        return result;
    }

    @Override
    public abstract boolean leaseOut();
}
