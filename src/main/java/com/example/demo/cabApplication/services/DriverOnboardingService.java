package com.example.demo.cabApplication.services;

import com.example.demo.cabApplication.entites.Driver;
import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.Location;
import com.example.demo.cabApplication.entites.Vehicle;
import com.example.demo.cabApplication.repositories.IDriverRepository;

public class DriverOnboardingService implements IDriverOnboardingService{
    private final IDriverRepository driverRepository;

    public DriverOnboardingService(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver createDriver(String driverName, Gender gender, Integer driverAge, Vehicle vehicle, Location location, boolean available) {
       Driver driver = new Driver(driverName,gender,driverAge,vehicle,location,available);
       return driverRepository.save(driver);
    }


}
