package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a file path to load a dealership: ");
        String filePath = scanner.nextLine();

        UserInterface ui = new UserInterface(filePath);
        ui.display();

        scanner.close();
    }
}