import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UpdateClientRecords {
    private static Scanner stdin;

    public String[] SearchCustomerCsv(String searchTerm, String filePath){
        boolean found = false;
        String CustomerID = "";
        String Name = "";
        String lastName = "";
        String Phonenumber = "";
        String email = "";
        String address = "";
        String postcode = "";
        String cardnumber = "";
        String[] searchCustomer = new String[8];

        BufferedReader reader =null;
        try{
            stdin = new Scanner(new File(filePath));
            stdin.useDelimiter("[,\n]");

            while(stdin.hasNext() && !found){
                CustomerID = stdin.next();
                Name = stdin.next();
                lastName = stdin.next();
                Phonenumber = stdin.next();
                email = stdin.next();
                address = stdin.next();
                postcode = stdin.next();
                cardnumber = stdin.next();
                if(CustomerID.equals(searchTerm)){
                    found = true;
                }if (found){
                    searchCustomer[0] = CustomerID;
                    searchCustomer[1] = Name;
                    searchCustomer[2] = lastName;
                    searchCustomer[3] = Phonenumber;
                    searchCustomer[4] = email;
                    searchCustomer[5] = address;
                    searchCustomer[6] = postcode;
                    searchCustomer[7] = cardnumber;
                }else{
                    System.out.println("Record not found");
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return searchCustomer;
    }

    public String[] SearchBusinessCsv(String filePath, String searchTerm){
        boolean found = false;
        String CustomerID = "";
        String BusinessName= "";
        String EmployeeName = "";
        String EmployeeLastName = "";
        String Phonenumber = "";
        String email = "";
        String address = "";
        String postcode = "";
        String cardnumber = "";
        String Insurance = "";
        String[] searchBusiness = new String[10];

        BufferedReader reader =null;
        try{
            stdin = new Scanner(new File(filePath));
            stdin.useDelimiter("[,\n]");

            while(stdin.hasNext() && !found){
                CustomerID = stdin.next();
                BusinessName = stdin.next();
                EmployeeName = stdin.next();
                EmployeeLastName = stdin.next();
                Phonenumber = stdin.next();
                email = stdin.next();
                address = stdin.next();
                postcode = stdin.next();
                cardnumber = stdin.next();
                Insurance = stdin.next();

                if(CustomerID.equals(searchTerm)){
                    found = true;
                }if (found){
                    searchBusiness[0] = CustomerID;
                    searchBusiness[1] = BusinessName;
                    searchBusiness[2] = EmployeeName;
                    searchBusiness[3] = EmployeeLastName;
                    searchBusiness[4] = Phonenumber;
                    searchBusiness[5] = email;
                    searchBusiness[6] = address;
                    searchBusiness[7] = postcode;
                    searchBusiness[8] = cardnumber;
                    searchBusiness[9] = Insurance;
                }else{
                    System.out.println("Record not found");
                }
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return searchBusiness;
    }

    public void deleteCustomerCsv(String removeTerm, String filePath){
        String tempFile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        String CustomerID = "";
        String Name = "";
        String lastName = "";
        String Phonenumber = "";
        String email = "";
        String address = "";
        String postcode = "";
        String cardnumber = "";

        try{
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            stdin = new Scanner(new File(filePath));
            stdin.useDelimiter("[,\n]");

            while (stdin.hasNext()){
                CustomerID = stdin.next();
                Name = stdin.next();
                lastName = stdin.next();
                Phonenumber = stdin.next();
                email = stdin.next();
                address = stdin.next();
                postcode = stdin.next();
                cardnumber = stdin.next();

                if(!CustomerID.equals(removeTerm)){
                    pw.println(CustomerID+","+Name+","+lastName+","+Phonenumber+","+email+","+address+","+postcode+","+cardnumber);
                }
            }
            stdin.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteBusinessCsv(String removeTerm, String filePath){
        String tempFile = "temp.txt";
        File oldFile = new File(filePath);
        File newFile = new File(tempFile);

        String CustomerID = "";
        String BusinessName= "";
        String EmployeeName = "";
        String EmployeeLastName = "";
        String Phonenumber = "";
        String email = "";
        String address = "";
        String postcode = "";
        String cardnumber = "";
        String Insurance = "";

        try{
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            stdin = new Scanner(new File(filePath));
            stdin.useDelimiter("[,\n]");

            while (stdin.hasNext()){
                CustomerID = stdin.next();
                BusinessName = stdin.next();
                EmployeeName = stdin.next();
                EmployeeLastName = stdin.next();
                Phonenumber = stdin.next();
                email = stdin.next();
                address = stdin.next();
                postcode = stdin.next();
                cardnumber = stdin.next();
                Insurance = stdin.next();

                if(!CustomerID.equals(removeTerm)){
                    pw.println(CustomerID+","+BusinessName+","+EmployeeName+","+EmployeeLastName+","+Phonenumber+","+email+","+address+","+postcode+","+Insurance+","+cardnumber);
                }
            }
            stdin.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filePath);
            newFile.renameTo(dump);

        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
