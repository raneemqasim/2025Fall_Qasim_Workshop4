package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    //okay so this was not supposed to be a static property because each dealership will have their own
    private ArrayList<Vehicle> inventory = new ArrayList<>();

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
    //apparently these are not supposed to be static either because we are gonna use 'instance methods'
    public List<Vehicle> getVehicleByPrice(double min, double max){
        //let's loop through our inventory
        List <Vehicle> vehiclesByPrice = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getPrice() > min && vehicle.getPrice() < max){
                vehiclesByPrice.add(vehicle);
            }
            if (vehiclesByPrice.isEmpty()){
                System.out.println("There are no vehicles in that price range");
            }
        }
        //can we use collections.sort to sort the list before we return it?
        return vehiclesByPrice;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        List <Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getMake().equalsIgnoreCase(make) || vehicle.getModel().equalsIgnoreCase(model)){
                vehiclesByMakeModel.add(vehicle);
            }
            if (vehiclesByMakeModel.isEmpty()){
                System.out.println("There are no vehicles of that make and model");
            }
        }
        return vehiclesByMakeModel;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max){
        List <Vehicle> vehiclesByYear = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getYear() > min && vehicle.getYear() < max){
                vehiclesByYear.add(vehicle);
            }
            if (vehiclesByYear.isEmpty()){
                System.out.println("There are no vehicles from those years");
            }
        }
        return vehiclesByYear;
    }

    public List<Vehicle> getVehiclesByColor(String color){
        List <Vehicle> vehiclesByColor = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getColor().equalsIgnoreCase(color)){
                vehiclesByColor.add(vehicle);
            }
            if (vehiclesByColor.isEmpty()){
                System.out.println("There are no vehicles in that color");
            }
        }
        return vehiclesByColor;
    }

    public List<Vehicle> getVehiclesByMileage(int min, int max){
        List <Vehicle> vehiclesByMileage = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getOdometer() > min && vehicle.getOdometer() < max){
                vehiclesByMileage.add(vehicle);
            }
            if (vehiclesByMileage.isEmpty()){
                System.out.println("There are no vehicles with that mileage range");
            }
        }
        return vehiclesByMileage;
    }

    public List<Vehicle> getVehiclesByType(String vehicleType){
        List <Vehicle> vehiclesByType = new ArrayList<>();
        for(Vehicle vehicle : inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(vehicleType)){
                vehiclesByType.add(vehicle);
            }
            if (vehiclesByType.isEmpty()){
                System.out.println("There are no vehicles of that type");
            }
        }
        return vehiclesByType;
    }

    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }
    //removeVehicle(vehicle)

    }
