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
           dealership = manager.getDealership();
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
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()){
                System.out.println("Invalid option, please try again.");
                scanner.nextLine();
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum price: ");
        double min = scanner.nextDouble();

        System.out.print("Enter maximum price: ");
        double max = scanner.nextDouble();

        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByPrice(min,max);
        displayVehicles(vehicles);

    }

    public void processGetByMakeModelRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle make:  ");
        String make = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();

        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make,model);
        displayVehicles(vehicles);

    }

    public void processGetByYearRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum year: ");
        int min = scanner.nextInt();

        System.out.print("Enter maximum year: ");
        int max = scanner.nextInt();

        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByYear(min,max);
        displayVehicles(vehicles);

    }

    public void processGetByColorRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle color: ");
        String vehicleColor = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByColor(vehicleColor);
        displayVehicles(vehicles);

    }

    public void processGetByMileageRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter minimum mileage: ");
        int min = scanner.nextInt();

        System.out.print("Enter maximum mileage: ");
        int max = scanner.nextInt();

        scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByMileage(min,max);
        displayVehicles(vehicles);


    }

    public void processGetByVehicleTypeRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getVehiclesByType(vehicleType);
        displayVehicles(vehicles);

    }

    public void processGetAllVehiclesRequest(){
        List<Vehicle> vehicles = dealership.getAllVehicles();

        displayVehicles(vehicles);
    }

    public void processAddVehiclesRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();

        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println("Enter mileage: ");
        int odometer = scanner.nextInt();

        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();

        dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));

    }

    public void processRemoveVehiclesRequest(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();

        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        System.out.println("Enter model: ");
        String model = scanner.nextLine();

        System.out.println("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println("Enter mileage: ");
        int odometer = scanner.nextInt();

        System.out.println("Enter Price: ");
        double price = scanner.nextDouble();

        dealership.removeVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));

    }


}
