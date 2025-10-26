package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    //making this a static property so other classes can access it
    private static ArrayList<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //custom methods
    public List<Vehicle> getVehicleByPrice(double min, double max){
        //let's loop through our inventory
        List <Vehicle> vehiclesByPrice = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() > min && vehicle.getPrice() < max){
                vehiclesByPrice.add(vehicle);
            }
            else{
                System.out.println("There are no vehicles in that price range");
            }
        }
        //can we use collections.sort to sort the list before we return it?
        return vehiclesByPrice;
    }

    public static List<Vehicle> GetVehiclesByMakeModel(String make, String model){
        List <Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model)){
                vehiclesByMakeModel.add(vehicle);
            }
            else{
                System.out.println("There are no vehicles of that make or model");
            }
        }
        return vehiclesByMakeModel;
    }

    public static List<Vehicle> getVehiclesByYear(int min, int max){
        List <Vehicle> vehiclesByYear = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() > min && vehicle.getYear() < max){
                vehiclesByYear.add(vehicle);
            }
            else{
                System.out.println("There are no vehicles from those years");
            }
        }
        return vehiclesByYear;
    }

    public static List<Vehicle> getVehiclesByColor(String color){
        List <Vehicle> vehiclesByColor = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                vehiclesByColor.add(vehicle);
            }
            else{
                System.out.println("There are no vehicles in that color");
            }
        }
        return vehiclesByColor;
    }

    public static List<Vehicle> getVehiclesByMileage(int min, int max){
        List <Vehicle> vehiclesByMileage = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() > min && vehicle.getOdometer() < max){
                vehiclesByMileage.add(vehicle);
            }
            else{
                System.out.println("There are no vehicles with that mileage");
            }
        }
        return vehiclesByMileage;
    }
    public static List<Vehicle> getVehiclesByType(String vehicleType){
        List <Vehicle> vehiclesByType = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehiclesByType.add(vehicle);
            }
            else{
                System.out.println("There are no vehicles of that type");
            }
        }
        return vehiclesByType;
    }

    //getAllVehicles() : List<Vehicle>
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    //addVehicle(vehicle)
    //making this static so other classes can access it
    public static void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    //removeVehicle(vehicle)

    }
