package com.example.demo.cabApplication.commands;

import com.example.demo.cabApplication.entites.Driver;
import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.Location;
import com.example.demo.cabApplication.entites.Vehicle;
import com.example.demo.cabApplication.services.IDriverOnboardingService;

import java.util.List;
import java.util.Objects;

public class AddDriverCommand implements ICommand{
    private final IDriverOnboardingService driverOnboardingService;

    public AddDriverCommand(IDriverOnboardingService driverOnboardingService) {
        this.driverOnboardingService = driverOnboardingService;
    }

    @Override
    public void execute(List<String> tokens) {
        String name = tokens.get(1);
        String g = tokens.get(2);
        Gender gender; if(Objects.equals(g, "M")) gender = Gender.M; else gender = Gender.F;
        Integer age = Integer.valueOf(tokens.get(3));
        String vName = tokens.get(4);
        String vNo = tokens.get(5);
        Vehicle vehicle = new Vehicle(vName,vNo);
        Integer x = Integer.valueOf(tokens.get(6));
        Integer y = Integer.valueOf(tokens.get(7));
        Location location = new Location(x,y);
        try {
            Driver d = driverOnboardingService.createDriver(name,gender,age,vehicle,location,true);
        } catch (NullPointerException e){
            System.out.println("put all required information");
        }

    }
}
