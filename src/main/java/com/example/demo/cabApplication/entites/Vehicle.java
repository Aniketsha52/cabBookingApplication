package com.example.demo.cabApplication.entites;

import java.util.Objects;

public class Vehicle {
    private  String vehicleName;

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    private  String vehicleNumber;

    public Vehicle(String vehicleName, String vehicleNumber) {
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }


    public String getVehicleNumber() {
        return vehicleNumber;
    }
    public void setVehicleName(String vehicleName){
        this.vehicleName = vehicleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return getVehicleName().equals(vehicle.getVehicleName()) && getVehicleNumber().equals(vehicle.getVehicleNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVehicleName(), getVehicleNumber());
    }
}
