package com.example.demo.cabApplication.commands;

import com.example.demo.cabApplication.entites.Driver;
import com.example.demo.cabApplication.entites.Location;
import com.example.demo.cabApplication.exceptions.DriverNotFoundException;
import com.example.demo.cabApplication.services.IUserOnboardingServices;

import java.util.List;

public class FindRideCommand implements ICommand{
    private final IUserOnboardingServices userOnboardingServices;

    public FindRideCommand(IUserOnboardingServices userOnboardingServices) {
        this.userOnboardingServices = userOnboardingServices;
    }

    @Override
    public void execute(List<String> tokens)throws DriverNotFoundException {
        String name = tokens.get(1);
        Integer sX = Integer.valueOf(tokens.get(2));
        Integer sY = Integer.valueOf(tokens.get(3));
        Location sourceLocation = new Location(sX,sY);
        Integer dX = Integer.valueOf(tokens.get(4));
        Integer dY = Integer.valueOf(tokens.get(5));
        Location destinationLocation = new Location(dX,dY);
        try {
            List<Driver> driverList = userOnboardingServices.findRide(name,sourceLocation,destinationLocation);
            System.out.println(driverList.get(0).getDriverName());
        }catch (Exception ex){
            System.out.println("No ride found");
        }


    }
}
