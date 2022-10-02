package com.example.demo.cabApplication.services;

import com.example.demo.cabApplication.entites.Driver;
import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.Location;
import com.example.demo.cabApplication.entites.Vehicle;

public interface IDriverOnboardingService {
    public Driver createDriver(String driverName, Gender gender, Integer driverAge, Vehicle vehicle, Location location, boolean available);
}
