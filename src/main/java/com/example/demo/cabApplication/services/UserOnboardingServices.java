package com.example.demo.cabApplication.services;

import com.example.demo.cabApplication.entites.Driver;
import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.Location;
import com.example.demo.cabApplication.entites.User;
import com.example.demo.cabApplication.exceptions.DriverNotFoundException;
import com.example.demo.cabApplication.repositories.IDriverRepository;
import com.example.demo.cabApplication.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserOnboardingServices implements IUserOnboardingServices{

    private final double MAX_DISTANCEUNIT = 5;
    private final IUserRepository userRepository;
    private final IDriverRepository driverRepository;

    public UserOnboardingServices(IUserRepository userRepository, IDriverRepository driverRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public User createUser(String name, Gender gender, Integer age) {
        User user = new User(name,gender,age);
        return userRepository.save(user);
    }

    @Override
    public List<Driver> findRide(String userName, Location source, Location destination) throws DriverNotFoundException {
        List<Driver> allDrivers = driverRepository.findAll();
        if(allDrivers.size() == 0){
            throw new DriverNotFoundException("Sorry! No Rider Available");
        }
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver d : allDrivers){
            double x1 = source.getX(), y1 = source.getY();
            double x2 = d.getLocation().getX(), y2 = d.getLocation().getY();
            double distance = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1)*(y2 - y1));
            if(distance <= MAX_DISTANCEUNIT && d.getisAvailable()){
                d.setisAvailable(false);
                availableDrivers.add(d);
            }
        }
        if(availableDrivers.size() == 0) throw new DriverNotFoundException("No ride found");
        return availableDrivers;
    }



}
