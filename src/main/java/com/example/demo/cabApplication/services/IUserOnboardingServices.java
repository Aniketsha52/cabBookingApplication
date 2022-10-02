package com.example.demo.cabApplication.services;

import com.example.demo.cabApplication.entites.Driver;
import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.Location;
import com.example.demo.cabApplication.entites.User;
import com.example.demo.cabApplication.exceptions.DriverNotFoundException;

import java.util.List;

public interface IUserOnboardingServices {
    public User createUser(String name, Gender gender,Integer age);
    public List<Driver> findRide(String userName, Location source, Location destination)throws DriverNotFoundException;

    //public String chooseRide(String userName, String driverName);
}
