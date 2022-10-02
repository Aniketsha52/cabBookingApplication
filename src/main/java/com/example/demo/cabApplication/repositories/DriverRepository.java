package com.example.demo.cabApplication.repositories;

import com.example.demo.cabApplication.entites.Driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriverRepository implements IDriverRepository{
    private final Map<String,Driver> driverMap;
    private Integer autoIncrement = 0;

    public DriverRepository() {
        driverMap = new HashMap<String,Driver>();
    }
    public DriverRepository(HashMap<String,Driver> driverMap){
        this.driverMap = driverMap;
        this.autoIncrement = driverMap.size();
    }

    @Override
    public Driver save(Driver entity) {
        if(entity.getId() == null){
            autoIncrement++;
            Driver d = new Driver(Integer.toString(autoIncrement), entity.getDriverName(),entity.getGender(),entity.getDriverAge(),entity.getVehicle(),entity.getLocation(),entity.getisAvailable());
            driverMap.put(d.getId(), d);
            return d;
        }
        driverMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public List<Driver> findAll() {
        return new ArrayList<>(driverMap.values());
    }
}
