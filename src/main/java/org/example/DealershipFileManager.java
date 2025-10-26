package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    //getDealership() reads the dealership file and returns a populated Dealership object
    //static so that the other classes can use it
    public static Dealership getDealership(String filePath){

        //declaring a dealership outside the try catch block so we can use it throughout the whole method!
        Dealership dealership = null;

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fr);

            //skip the first line/set the dealership properties with it
            //Line 1: Dealership Name|Address|Phone
            String firstLine = bufferedReader.readLine();
            if(firstLine != null){
                String[] dealershipData = firstLine.split("\\|");
                String name = dealershipData[0];
                String address = dealershipData[1];
                String phone = dealershipData[3];

                dealership = new Dealership(name, address, phone);
            }

            //instead of making an empty list, we are going to add vehicle objects we read from the file
            // into the empty list already contained within the dealership object
            // using the static method addVehicle!
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //Lines 2+: VIN|Year|Make|Model|VehicleType|Color|Odometer|Price
                String[] vehicleData = line.split("\\|");
                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);

                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                Dealership.addVehicle(vehicle);
            }
            bufferedReader.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println("We could not find your file");
        }

        catch(IOException ex) {
            System.out.println("There is a problem reading from your file");
        }

        return dealership;

    }
    //saveDealership(dealership) This method will overwrite the inventory.csv file with the
    // current dealership information and inventory list.
    public static void saveDealership(Dealership dealership, String filePath){
        try{
            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            //this WILL overwrite the file because there is no append : true
            //write the first line
            bufferedWriter.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());

            //write the other lines
            //Lines 2+: VIN|Year|Make|Model|VehicleType|Color|Odometer|Price
            List<Vehicle> allVehicles = dealership.getAllVehicles();
            for (Vehicle vehicle : allVehicles){
                bufferedWriter.write(vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        vehicle.getPrice());
                //put the next vehicle on a new line
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException ex){
            System.out.println("There is a problem writing to your file");
        }
    }

}
