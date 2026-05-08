package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public Vehicle getVehiclesByPrice(double min, double max){
        return null;
    }

    public Vehicle getVehiclesByPrice(String make, String model){
        return null;
    }

    public Vehicle getVehiclesByYear(double min, double max){
        return null;
    }

    public Vehicle getVehiclesByColor(String color){
        return null;
    }

    public Vehicle getVehiclesByMileage(double min, double max){
        return null;
    }

    public Vehicle getVehicleByType(String vehicleType){
        return null;
    }

    public Vehicle getAllVehicles(){
        return null;
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle){

    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }
}
