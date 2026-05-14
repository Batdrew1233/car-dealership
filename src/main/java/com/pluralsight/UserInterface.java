package com.pluralsight;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    Dealership dealership;

    UserInterface() {

    }
    private void init(){
        DealershipFileManager manager = new DealershipFileManager();

        try {
            manager.getDealership();
        } catch (Exception ex) {
            System.out.println("Something went wrong");
        }
    }
    public void display(){
        init();
        Scanner scanner = new Scanner(System.in);
        int choice = 1;
        while (choice != 99){

            System.out.println("\n ------------- Menu ------------- ");
            System.out.println("1. Get vehicles by price");
            System.out.println("2. Get vehicles by make and model");
            System.out.println("3. Get vehicles by year");
            System.out.println("4. Get vehicles by color");
            System.out.println("5. Get vehicles by mileage");
            System.out.println("6. Get vehicles by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicles");
            System.out.println("9. Remove vehicles");
            System.out.println("99. Quit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();

            if (!scanner.hasNextInt()){
                System.out.println("Invalid option, please try again.");
                scanner.nextLine();
                continue;
            }

            switch (choice){
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehiclesRequest();
                case 9 -> processRemoveVehiclesRequest();
                case 99 -> System.out.println("Thanks for visiting!");
                default -> System.out.println("Invalid choice");


            }


        }


    }

    private  void displayVehicles(List<Vehicle> vehicle){
        for (Vehicle vehicles : vehicle){
            System.out.println(vehicles);
        }
    }

    public void processGetByPriceRequest(){

    }

    public void processGetByMakeModelRequest(){

    }

    public void processGetByYearRequest(){

    }

    public void processGetByColorRequest(){

    }

    public void processGetByMileageRequest(){

    }

    public void processGetByVehicleTypeRequest(){

    }

    public void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();

        displayVehicles(vehicles);
    }

    public void processAddVehiclesRequest(){

    }

    public void processRemoveVehiclesRequest(){

    }


}
