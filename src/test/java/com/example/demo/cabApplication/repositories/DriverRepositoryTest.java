package com.example.demo.cabApplication.repositories;

import com.example.demo.cabApplication.entites.Driver;
import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.Location;
import com.example.demo.cabApplication.entites.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DriverRepositoryTest {
    private DriverRepository driverRepository;

    @BeforeEach
    void setUp() {
        final HashMap<String, Driver> driverMap = new HashMap<>() {
            {
                put("1",new Driver("1","Driver1", Gender.M,22, new Vehicle("vehicle1","0a10"),new Location(0,0),true));
                put("2",new Driver("2","Driver2", Gender.M,24, new Vehicle("vehicle2","0b19"),new Location(0,0),true));
            }
        };
        driverRepository = new DriverRepository(driverMap);
    }

    @Test
    @DisplayName("save method should create and return new driver")
    void saveDriver() {
        final Driver driver3 = new Driver("Driver3", Gender.M,28, new Vehicle("vehicle3","0h100"),new Location(0,0),true);
        Driver expectedDriver = new Driver("3","Driver3", Gender.M,28, new Vehicle("vehicle3","0h100"),new Location(0,0),true);

        Driver actualDriver = driverRepository.save(driver3);
        Assertions.assertEquals(expectedDriver,actualDriver);

    }

    @Test
    @DisplayName("findAll method should return All Driver")
    void findAllDriver() {
        int expectedOutput = 2;
        List<Driver> driverList = driverRepository.findAll();
        Assertions.assertEquals(driverList.size(),expectedOutput);
    }
}