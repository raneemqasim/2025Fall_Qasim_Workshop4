package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a file path to load a dealership: ");
        String filePath = scanner.nextLine();

        //do we need a try catch for inputting the wrong file path? right now the program just continues like nothing is wrong
        UserInterface ui = new UserInterface(filePath);
        ui.display();

        scanner.close();
    }
}