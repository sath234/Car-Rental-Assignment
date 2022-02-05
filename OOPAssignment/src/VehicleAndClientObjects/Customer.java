package VehicleAndClientObjects;

public class Customer {
    private String CustomerID;
    private String FirstName;
    private String LastName;
    private String Phonenumber;
    private String Email;
    private String Address;
    private String Postcode;
    private String CardNumber;

    public Customer() {
    }

    public Customer(String customerID) {
        CustomerID = customerID;
    }

    public Customer(String customerID, String firstName, String lastName, String phonenumber, String email, String address, String postcode, String cardNumber) {
        CustomerID = customerID;
        FirstName = firstName;
        LastName = lastName;
        Phonenumber = phonenumber;
        Email = email;
        Address = address;
        Postcode = postcode;
        CardNumber = cardNumber;
    }

    public void printDetails(){
        System.out.println("first name: " +getFirstName() + "\n"
        +"last name: " +getLastName() + "\n"
        +"Phone number: "+getPhonenumber() +"\n"
        +"Email: "+getEmail() +"\n"
        +"Address: "+getAddress()+"\n"
        +"Postcode: "+getPostcode()+"\n"
        +"Card number: "+getCardNumber()+"\n");
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String cardNumber) {
        CardNumber = cardNumber;
    }
}
