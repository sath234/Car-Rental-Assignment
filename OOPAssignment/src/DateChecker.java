import VehicleAndClientObjects.Lorry;
import VehicleAndClientObjects.PickupTruck;
import VehicleAndClientObjects.Van;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DateChecker {
    public String[] dateChecker(String filePath, String vehicle) throws IOException {
        Scanner stdin = new Scanner(System.in);
        VehicleDatabase database = new VehicleDatabase(filePath);
        List<LocalDate> startDates = new ArrayList<>();
        List<LocalDate> endDates = new ArrayList<>();
        if (vehicle.equals("lorry")){
            database.loadLorries();
            ArrayList<Lorry> Lorries = database.getAllLorries();
            for (Lorry lorry: Lorries){
                startDates.add(lorry.getStartDate());
                endDates.add(lorry.getReturnDate());
            }
        } else if (vehicle.equals("van")){
            database.loadVans();
            ArrayList<Van> Vans = database.getAllVans();
            for (Van van: Vans){
                startDates.add(van.getStartDate());
                endDates.add(van.getReturnDate());
            }
        }else if (vehicle.equals("pickup truck")) {
            database.loadPickupTrucks();
            ArrayList<PickupTruck> PickupTrucks = database.getAllPickupTrucks();
            for (PickupTruck pickupTruck : PickupTrucks) {
                startDates.add(pickupTruck.getStartDate());
                endDates.add(pickupTruck.getReturnDate());
            }
        }

        String[] info = new String[3];
        boolean exit = false;

        while(!exit){
            System.out.println("Please enter the date you want to book");
            LocalDate enteredDate = LocalDate.parse(FormatCheckers.returnCorrectDateFormat());
            System.out.println("How many weeks would you like to rent");
            int weeks = Integer.parseInt(stdin.nextLine());
            LocalDate EnteredReturnDate = enteredDate.plusWeeks(weeks);
            String message = "";
            for (int i=0; i<startDates.size(); i++){
                if (enteredDate.isAfter(startDates.get(i)) && enteredDate.isBefore(endDates.get(i))){
                    message = "The vehicle isn't available between the selected dates";
                    exit = false;
                    break;
                } else if (EnteredReturnDate.isAfter(startDates.get(i)) && EnteredReturnDate.isBefore(endDates.get(i))){
                    message = "The vehicle isn't available between the selected dates";
                    exit = false;
                    break;
                }else if (enteredDate.isEqual(startDates.get(i)) || enteredDate.isEqual(endDates.get(i)) || EnteredReturnDate.isEqual(startDates.get(i)) || EnteredReturnDate.isEqual(endDates.get(i))){
                    message = "The vehicle isn't available between the selected dates";
                    exit = false;
                    break;
                }else if (startDates.get(i).isAfter(enteredDate) && startDates.get(i).isBefore(EnteredReturnDate)){
                    message = "The vehicle isn't available between the selected dates";
                    exit = false;
                    break;
                }else if (endDates.get(i).isAfter(enteredDate) && endDates.get(i).isBefore(EnteredReturnDate)){
                    message = "The vehicle isn't available between the selected dates";
                    exit = false;
                    break;
                }else if(enteredDate.isBefore(LocalDate.now())){
                    message = "you cannot book a car in the past";
                    exit = false;
                    break;
                }else{
                    exit = true;
                    info[0] = enteredDate.toString();
                    info[1] = EnteredReturnDate.toString();
                    info[2] = String.valueOf(weeks);
                }
            }
            if (startDates.size() == 0 && endDates.size() == 0){
                message = "You have successfully booked the Vehicle for your selected time period.";
                exit = true;
                info[0] = enteredDate.toString();
                info[1] = EnteredReturnDate.toString();
                info[2] = String.valueOf(weeks);
            }

            System.out.println(message);
        }
        return info;
    }
}
