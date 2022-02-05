package VehicleAndClientObjects;

import VehicleAndClientObjects.Customer;

public class Business extends Customer {
    private String BusniessName;
    private String Insurance;


    public Business(String customerID, String firstName, String lastName, String phonenumber, String email, String address, String postcode, String cardNumber, String insurance, String busniessName) {
        super(customerID, firstName, lastName, phonenumber, email, address, postcode, cardNumber);
        BusniessName = busniessName;
        Insurance = insurance;
    }

    public void printDetails(){
        System.out.println("Business name: " +getBusniessName() + "\n"
                +"Employee first name: " +getFirstName() + "\n"
                +"Employee last name: " +getLastName() + "\n"
                +"Business Phone number: "+getPhonenumber() +"\n"
                +"Business Email: "+getEmail() +"\n"
                +"Business Address: "+getAddress()+"\n"
                +"Business Postcode: "+getPostcode()+"\n"
                +"Card number: "+getCardNumber()+"\n"
                +"Has Insurance: "+getInsurance()+"\n"
        );
    }

    public String getBusniessName() {
        return BusniessName;
    }

    public void setBusniessName(String busniessName) {
        BusniessName = busniessName;
    }


    public String getInsurance() {
        return Insurance;
    }

    public void setInsurance(String insurance) {
        Insurance = insurance;
    }
}

