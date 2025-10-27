package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //what happens if you input the wrong file path? right now the program just continues like nothing is wrong
        //my solution is to create a while loop
        //creating some placeholder variables for my while loop
        String filePath = "";
        Dealership dealership = null;

        while(dealership == null){
            System.out.println("Please input a file path to load a dealership: ");
            filePath = scanner.nextLine();

            dealership = DealershipFileManager.getDealership(filePath);

            if(dealership == null){
                System.out.println("Could not load dealership, please try again.");
            }
        }

        System.out.printf("Dealership %s loaded successfully!", dealership.getName());
        UserInterface ui = new UserInterface(filePath);
        ui.display();

        scanner.close();
    }
}