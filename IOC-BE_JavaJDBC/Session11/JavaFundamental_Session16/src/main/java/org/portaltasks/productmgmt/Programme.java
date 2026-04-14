package org.portaltasks.productmgmt;

import java.util.Scanner;

public class Programme {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String menuChoice;
        int choice;
        System.out.println("--- PRODUCT MANAGEMENT SYSTEM ---");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Display All Products");
        System.out.println("5. Filter Products (Price > £100)"); //£ is sign for UK Pounds
        System.out.println("6. Total Value of Products");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        while (true){
            menuChoice = sc.nextLine();
            try{
                if (menuChoice.isBlank()){
                    System.out.println("Please enter an option index.");
                    continue;
                }
                choice = Integer.parseInt(menuChoice);
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option index.");
            }
        }
        switch (choice){
            case 1:
                System.out.println("Add Product");
                break;
            case 2:
                System.out.println("Update Product");
                break;
            case 3:
                System.out.println("Delete Product");
                break;
            case 4:
                System.out.println("Display All Products");
                break;
            case 5:
                System.out.println("Products with price of more than £100");
                break;
            case 6:
                System.out.println("Total Value of Products");
                break;
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please enter a valid option index.");
                break;
        }
    }
}
