import VehicleAndClientObjects.Lorry;
import VehicleAndClientObjects.PickupTruck;
import VehicleAndClientObjects.Van;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VehicleDatabase {
    private String file;
    private DefaultListModel<Lorry> lorries;
    private DefaultListModel<Van> vans;
    private DefaultListModel<PickupTruck> pickupTrucks;

    public VehicleDatabase(String file){
        lorries = new DefaultListModel<>();
        vans = new DefaultListModel<>();
        pickupTrucks = new DefaultListModel<>();
        this.file = file;
    }

    public void addLorry(String numberPlate, int price, LocalDate startDate, LocalDate returnDate, int weeksOfRent, int customerID, boolean small, boolean crane, boolean tailgate, boolean forkLift){
        Lorry l = new Lorry(numberPlate, price, startDate,returnDate ,weeksOfRent,customerID,  small,  crane,  tailgate, forkLift);
        lorries.addElement(l);
    }

    public void addVan(String numberPlate, int price, LocalDate startDate, LocalDate returnDate, int weeksOfRent, int customerID, boolean small, boolean large){
        Van v = new Van(numberPlate,price,startDate,returnDate,weeksOfRent,customerID,small,large);
        vans.addElement(v);
    }

    public void addPickupTruck(String numberPlate, int price, LocalDate startDate, LocalDate returnDate, int weeksOfRent, int customerID){
        PickupTruck p = new PickupTruck(numberPlate,price,startDate,returnDate,weeksOfRent,customerID);
        pickupTrucks.addElement(p);
    }

    public ArrayList<PickupTruck> getAllPickupTrucks(){
        return Collections.list(pickupTrucks.elements());
    }

    public ArrayList<Van> getAllVans(){
        return Collections.list(vans.elements());
    }

    public ArrayList<Lorry> getAllLorries(){
        return Collections.list(lorries.elements());
    }

    public void saveLorry() throws IOException {
        ArrayList<Lorry> alLorry = getAllLorries();
        Collections.sort(alLorry, (o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,false))){
            for (Lorry l : alLorry){
                String[] values ={l.getNumberPlate(), String.valueOf(l.getPrice()), String.valueOf(l.getStartDate()),
                        String.valueOf(l.getReturnDate()), String.valueOf(l.getWeeksOfRent()), String.valueOf(l.getCustomerID()),
                        String.valueOf(l.isSmall()), String.valueOf(l.isCrane()), String.valueOf(l.isTailgate()), String.valueOf(l.isForkLift())};
                String line = String.join(",",values);
                bw.append(line);
                bw.append("\n");
            }
            bw.flush();
        }
    }

    public void saveVans() throws IOException {
        ArrayList<Van> alVan = getAllVans();
        Collections.sort(alVan, (o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,false))){
            for (Van v : alVan){
                String[] values ={v.getNumberPlate(), String.valueOf(v.getPrice()), String.valueOf(v.getStartDate()),
                        String.valueOf(v.getReturnDate()), String.valueOf(v.getWeeksOfRent()), String.valueOf(v.getCustomerID()),
                        String.valueOf(v.isSmall()),String.valueOf(v.isLarge())};
                String line = String.join(",",values);
                bw.append(line);
                bw.append("\n");
            }
            bw.flush();
        }
    }

    public void savePickupTrucks() throws IOException {
        ArrayList<PickupTruck> alPickupTruck = getAllPickupTrucks();
        Collections.sort(alPickupTruck, (o1, o2) -> o1.getStartDate().compareTo(o2.getStartDate()));

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,false))){
            for (PickupTruck p : alPickupTruck){
                String[] values ={p.getNumberPlate(), String.valueOf(p.getPrice()),String.valueOf(p.getStartDate()),
                        String.valueOf(p.getReturnDate()),String.valueOf(p.getWeeksOfRent()),String.valueOf(p.getCustomerID())};
                String line = String.join(",",values);
                bw.append(line);
                bw.append("\n");
            }
            bw.flush();
        }
    }

    public void loadLorries() throws IOException{
        lorries.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String s;
            while ((s = br.readLine()) != null){
                String[] values = s.split(",");
                String numberPlate = values[0];
                String price = values[1];
                String dayRented = values[2];
                String returnDate = values[3];
                String weeksOfRent = values[4];
                String customerid = values[5];
                String small = values[6];
                String crane = values[7];
                String tailgate = values[8];
                String forkLift = values[9];

                addLorry(numberPlate, Integer.parseInt(price), LocalDate.parse(dayRented), LocalDate.parse(returnDate),
                        Integer.parseInt(weeksOfRent),Integer.parseInt(customerid),Boolean.parseBoolean(small),
                        Boolean.parseBoolean(crane), Boolean.parseBoolean(tailgate), Boolean.parseBoolean(forkLift));
            }
        }
    }

    public void loadVans() throws IOException{
        vans.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String s;
            while ((s = br.readLine()) != null){
                String[] values = s.split(",");
                String numberPlate = values[0];
                String price = values[1];
                String dayRented = values[2];
                String returnDate = values[3];
                String weeksOfRent = values[4];
                String customerid = values[5];
                String small = values[6];
                String large = values[7];

                addVan(numberPlate, Integer.parseInt(price), LocalDate.parse(dayRented),
                        LocalDate.parse(returnDate),Integer.parseInt(weeksOfRent), Integer.parseInt(customerid),
                        Boolean.parseBoolean(small), Boolean.parseBoolean(large));
            }
        }
    }

    public void loadPickupTrucks() throws IOException{
        pickupTrucks.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String s;
            while ((s = br.readLine()) != null){
                String[] values = s.split(",");
                String numberPlate = values[0];
                String price = values[1];
                String dayRented = values[2];
                String returnDate = values[3];
                String weeksOfRent = values[4];
                String customerid = values[5];

                addPickupTruck(numberPlate, Integer.parseInt(price), LocalDate.parse(dayRented),
                        LocalDate.parse(returnDate),Integer.parseInt(weeksOfRent), Integer.parseInt(customerid));
            }
        }
    }
}
