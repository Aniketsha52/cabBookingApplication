package com.example.demo.cabApplication.entites;

import java.util.Objects;

public class Driver extends BaseEntity{
    private final String driverName;
    private final Gender gender;
    private  Integer driverAge;
    private final Vehicle vehicle;
    private  Location location;
    private  boolean available;

    public Driver(String driverName, Gender gender, Integer driverAge, Vehicle vehicle, Location location, boolean available) {
        this.driverName = driverName;
        this.gender = gender;
        this.driverAge = driverAge;
        this.vehicle = vehicle;
        this.location = location;
        this.available = available;
    }

    public Driver(String id,String driverName, Gender gender, Integer driverAge, Vehicle vehicle, Location location, boolean available) {
        this.id = id;
        this.driverName = driverName;
        this.gender = gender;
        this.driverAge = driverAge;
        this.vehicle = vehicle;
        this.location = location;
        this.available = available;
    }

    public boolean getisAvailable() {
        return available;
    }

    public void setisAvailable(boolean available){
        this.available = available;
    }

    public Integer getDriverAge() {
        return driverAge;
    }

    public String getDriverName() {
        return driverName;
    }

    public Gender getGender() {
        return gender;
    }

    public Location getLocation() {
        return location;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        Driver driver = (Driver) o;
        return available == driver.available && getDriverName().equals(driver.getDriverName()) && getGender() == driver.getGender() && getDriverAge().equals(driver.getDriverAge()) && getVehicle().equals(driver.getVehicle()) && getLocation().equals(driver.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDriverName(), getGender(), getDriverAge(), getVehicle(), getLocation(), available);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverName='" + driverName + '\'' +
                ", gender=" + gender +
                ", driverAge=" + driverAge +
                ", vehicle=" + vehicle +
                ", location=" + location +
                ", available=" + available +
                '}';
    }
}
