package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

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
//    public List<Vehicle> getVehicleByPrice(double min, double max){
//        List<Vehicle> vehicleList = new ArrayList<>();
//        Vehicle vehicle1 = vehicleList[i];
//        Vehicle vehicle2 = vehicleList[i + 1];
//        for(int i = 0; i < vehicleList.size())
//        if(vehicle.getPrice = 3)
//    }

    //GetVehiclesByMakeModel(make,model) : List<Vehicle>
    //getVehiclesByYear(min,max) : List<Vehicle>
    //getVehiclesByColor(color) : List<Vehicle>
    //getVehiclesByMileage(min,max) : List<Vehicle>
    //getVehiclesByType(vehicleType) : List<Vehicle>

    //getAllVehicles() : List<Vehicle>
    public List<Vehicle> getAllVehicles(){
        return inventory;
    }

    //addVehicle(vehicle)
    public void addVehicle(){

    }

    //removeVehicle(vehicle)
}
