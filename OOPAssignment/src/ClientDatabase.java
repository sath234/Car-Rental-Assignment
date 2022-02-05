import VehicleAndClientObjects.Business;
import VehicleAndClientObjects.Customer;
import VehicleAndClientObjects.Lorry;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ClientDatabase {
    DefaultListModel<Customer> customers;
    DefaultListModel<Business> businesses;
    private String file;

    public ClientDatabase(String file){
        customers = new DefaultListModel<>();
        businesses = new DefaultListModel<>();
        this.file = file;
    }

    public void addCustomer(String CustomerID,String FirstName, String LastName, String Phonenumber, String Email, String Address, String Postcode, String CardNumber){
        Customer c = new Customer(CustomerID,FirstName,LastName,Phonenumber,Email,Address,Postcode,CardNumber);
        customers.addElement(c);
    }

    public ArrayList<Customer> getAllCustomers(){
        return Collections.list(customers.elements());
    }

    public LinkedList<Customer> linkedListCustomers() throws IOException {
        LinkedList<Customer> customers = new LinkedList<>();
        loadCustomer();
        customers.addAll(getAllCustomers());
        return customers;
    }


    public void addBusiness(String CustomerID,String BusinessName,String FirstName, String LastName, String Phonenumber, String Email, String Address, String Postcode, String Insurance, String CardNumber){
        Business b = new Business(CustomerID,BusinessName,FirstName,LastName,Phonenumber,Email,Address,Postcode,Insurance,CardNumber);
        businesses.addElement(b);
    }

    public ArrayList<Business> getAllBusniesses(){
        return Collections.list(businesses.elements());
    }

    public LinkedList<Business> linkedListBusinesses() throws IOException {
        LinkedList<Business> businesses = new LinkedList<>();
        loadCustomer();
        businesses.addAll(getAllBusniesses());
        return businesses;
    }


    public void saveCustomer() throws IOException{
        ArrayList<Customer> alCustomers = getAllCustomers();
        Collections.sort(alCustomers, (o1, o2) -> o2.getCustomerID().compareTo(o1.getCustomerID()));
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,false))){
            for (Customer c : alCustomers){
                String[] values ={c.getCustomerID(),c.getFirstName(),c.getLastName(),c.getPhonenumber(),c.getEmail(),c.getAddress(),c.getPostcode(),c.getCardNumber()};
                String line = String.join(",",values);
                bw.append(line);
                bw.append("\n");
            }
            bw.flush();
        }
    }

    public void saveBusiness() throws IOException{
        ArrayList<Business> alBusinesses = getAllBusniesses();
        Collections.sort(alBusinesses, (o1, o2) -> o2.getCustomerID().compareTo(o1.getCustomerID()));
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,false))){
            for (Business b : alBusinesses){
                String[] values ={b.getCustomerID(),b.getBusniessName(),b.getFirstName(),b.getLastName(),b.getPhonenumber(),b.getEmail(),b.getAddress(),b.getPostcode(),b.getInsurance(),b.getCardNumber()};
                String line = String.join(",",values);
                bw.append(line);
                bw.append("\n");
            }
            bw.flush();
        }
    }

    public void loadCustomer() throws IOException{
        customers.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String s;
            while ((s = br.readLine()) != null){
                String[] values = s.split(",");
                String CustomerID = values[0];
                String FirstName = values[1];
                String LastName = values[2];
                String Phonenumber = values[3];
                String Email = values[4];
                String Address = values[5];
                String Postcode = values[6];
                String CardNumber = values[7];
                addCustomer(CustomerID,FirstName,LastName,Phonenumber,Email,Address,Postcode,CardNumber);
            }
        }
    }

    public void loadBusiness() throws IOException{
        businesses.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String s;
            while ((s = br.readLine()) != null){
                String[] values = s.split(",");
                String CustomerID = values[0];
                String BusinessName = values[1];
                String FirstName = values[2];
                String LastName = values[3];
                String Phonenumber = values[4];
                String Email = values[5];
                String Address = values[6];
                String Postcode = values[7];
                String Insurance = values[8];
                String CardNumber = values[9];
                addBusiness(CustomerID,BusinessName,FirstName,LastName,Phonenumber,Email,Address,Postcode,Insurance,CardNumber);
            }
        }
    }
}
