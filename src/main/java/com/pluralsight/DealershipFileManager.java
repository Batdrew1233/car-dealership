package com.pluralsight;

import java.io.*;

public class DealershipFileManager {
    public Dealership getDealership() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("dealership.csv"));

            String dealershipLine = bufferedReader.readLine();
            String[] dealershipParts = dealershipLine.split("\\|");

            Dealership dealership =  new Dealership(dealershipParts[0],dealershipParts[1], dealershipParts[2]);

            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] parts = line.split("\\|");

                int vin = Integer.parseInt(parts[0].trim());
                int year = Integer.parseInt(parts[1].trim());
                String make = parts[2].trim();
                String model = parts[3].trim();
                String vehicleType = parts[4].trim();
                String color = parts[5].trim();
                int odometer = Integer.parseInt(parts[6].trim());
                double price = Double.parseDouble(parts[7].trim());

                dealership.addVehicle(new Vehicle(vin, year, make, model, vehicleType, color, odometer,price));


            }
            bufferedReader.close();
            return dealership;

        }catch (Exception ex){
            System.out.println("Something went wrong");
        }
        return null;
    }

    public void saveDealership(Dealership dealership){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dealership.csv"));
            writer.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());

            writer.newLine();

            // vehicle information
            for (Vehicle vehicle : dealership.getInventory()) {

                writer.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice());

                writer.newLine();
            }

            writer.close();

        } catch (Exception ex) {

            System.out.println("Something went wrong");
        }
    }



}
