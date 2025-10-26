package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    //is this a property? is that what the diagram is saying?
    private String filePath;
    private Dealership dealership;
    private Scanner scanner;

    public UserInterface(String filePath) {
        this.filePath = filePath;
        this.dealership = DealershipFileManager.getDealership(filePath);
        this.scanner = new Scanner(System.in);
    }

    //UserInterface(); what is this method for? it was in the UML diagram but idk why

    //display method
    public void display(){
        init();
        boolean running = true;
        while(running){
            displayMenu();
            String menuSelection = scanner.nextLine();
            switch (menuSelection){
                case "1":
                    processGetByPriceRequest();
                    break;
                case "2":
                    processGetByMakeModelRequest();
                    break;
                case "3":
                    processGetByYearRequest();
                    break;
                case "4":
                    processGetByColorRequest();
                    break;
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehiclesRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    break;
                case "10":
                    System.out.println("Thank you for using the car dealership app, goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Please enter a number from 1-9");
                    break;
        }
        }


    }
    //display menu helper
    public void displayMenu(){
        System.out.println("Hello! Welcome to the car dealership app!");
        //sout("You have loaded ___ dealership)
        System.out.println("Please pick a number from the following options: ");
        System.out.println("1. Get vehicles by price");
        System.out.println("2. Get vehicles by make or model");
        System.out.println("3. Get vehicles by year");
        System.out.println("4. Get vehicles by color");
        System.out.println("5. Get vehicles by mileage");
        System.out.println("6. Get vehicle by type");
        System.out.println("7. Get ALL vehicles");
        System.out.println("8. Add a vehicle to the dealership");
        System.out.println("9. Remove a vehicle from the dealership");
        System.out.println("10. Exit the application");
    }


    //init method
    private void init(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = DealershipFileManager.getDealership("src/main/resources/inventory.csv");
    }

    //display vehicles helper method
    private void displayVehicles(List<Vehicle> vehicles){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle);
        }
    }

    public void processGetByPriceRequest(){
        System.out.println("Please input a minimum price: ");
        String userMinimum = scanner.nextLine();
        System.out.println("Please input a maximum price: ");
        String userMaximum = scanner.nextLine();

        //do we need a try catch here?
        System.out.println("Here is a list of vehicles by price: ");
        displayVehicles(dealership.getVehicleByPrice(Double.parseDouble(userMinimum), Double.parseDouble(userMaximum)));
    }

    public void processGetByMakeModelRequest(){
        System.out.println("Please input vehicle make (or leave blank): ");
        String userMake = scanner.nextLine();
        System.out.println("Please input vehicle model (or leave blank): ");
        String userModel = scanner.nextLine();

        //do we need a try catch here?
        System.out.println("Here is a list of vehicles of that make or model: ");
        displayVehicles(dealership.getVehiclesByMakeModel(userMake, userModel));
    }

    public void processGetByYearRequest(){
        System.out.println("Please input the minimum year for the vehicle: ");
        String userMin = scanner.nextLine();
        System.out.println("Please input the maximum year for the vehicle: ");
        String userMax = scanner.nextLine();

        //do we need a try catch here?
        System.out.println("Here is a list of vehicles in that range of years: ");
        displayVehicles(dealership.getVehiclesByYear(Integer.parseInt(userMin), Integer.parseInt(userMax)));
    }

    public void processGetByColorRequest(){
        System.out.println("Please input a color for the vehicle: ");
        String userColor = scanner.nextLine();

        //do we need a try catch here?
        System.out.println("Here is a list of vehicles of that color: ");
        displayVehicles(dealership.getVehiclesByColor(userColor));
    }

    public void processGetByMileageRequest(){
        System.out.println("Please input the minimum odometer reading for the vehicle: ");
        String userMin = scanner.nextLine();
        System.out.println("Please input the maximum odometer reading for the vehicle: ");
        String userMax = scanner.nextLine();

        //do we need a try catch here?
        System.out.println("Here is a list of vehicles in that odometer range: ");
        displayVehicles(dealership.getVehiclesByMileage(Integer.parseInt(userMin), Integer.parseInt(userMax)));
    }
    public void processGetByVehicleTypeRequest(){
        System.out.println("Please input a vehicle type (SUV, sedan, car, truck): ");
        String userType = scanner.nextLine();

        //do we need a try catch here?
        System.out.println("Here is a list of vehicles of that type: ");
        displayVehicles(dealership.getVehiclesByType(userType));
    }

    public void processGetAllVehiclesRequest(){
        System.out.println("Here is a list of all vehicles: ");
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest(){
        System.out.println("Please enter the following information to add a vehicle: ");
        System.out.println("Vehicle VIN: ");
        int vin = Integer.parseInt(scanner.nextLine());

        System.out.println("Vehicle year: ");
        int year = Integer.parseInt(scanner.nextLine());

        System.out.println("Vehicle make: ");
        String make = scanner.nextLine();

        System.out.println("Vehicle model: ");
        String model = scanner.nextLine();

        System.out.println("Vehicle type (sedan, SUV, car, truck): ");
        String vehicleType = scanner.nextLine();

        System.out.println("Vehicle color: ");
        String color = scanner.nextLine();

        System.out.println("Vehicle odometer reading: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.println("Vehicle price: ");
        double price = Double.parseDouble(scanner.nextLine());

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
    }

    //processRemoveVehicleRequest();

    }
