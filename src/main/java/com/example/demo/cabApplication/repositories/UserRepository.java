package com.example.demo.cabApplication.repositories;

import com.example.demo.cabApplication.entites.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository implements IUserRepository{
    private final Map<String,User> userMap;
    private Integer autoIncrement = 0;

    public UserRepository(){
         userMap = new HashMap<String,User>();
    }
    public UserRepository(Map<String,User> userMap){
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }
    @Override
    public User save(User entity) {
        if(entity.getId() == null){
            autoIncrement++;
            User u = new User(Integer.toString(autoIncrement), entity.getName(),entity.getGender(),entity.getAge());
            userMap.put(u.getId(),u);
            return u;
        }
        userMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}
