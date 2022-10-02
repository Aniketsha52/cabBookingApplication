package com.example.demo.cabApplication.repositories;

import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {
    private IUserRepository userRepository;

    @BeforeEach
    void setUp(){
        final HashMap<String, User> userHashMap = new HashMap<>(){
            {
                put("1",new User("1","user1", Gender.M,22));
                put("2",new User("1","user2",Gender.F,18));
            }
        };
        userRepository = new UserRepository(userHashMap);
    }

    @Test
    @DisplayName("save the user and return new user")
    void saveUser() {
        User user3 = new User("user3",Gender.F,20);
        User expectedUser = new User("3","user3",Gender.F,20);
        User actualUser = userRepository.save(user3);
        Assertions.assertEquals(expectedUser,actualUser);
    }

    @Test
    @DisplayName("find all method give the list of user")
    void findAllUser() {
        int expectedSize = 2;
        List<User> userList = userRepository.findAll();
        Assertions.assertEquals(expectedSize,userList.size());
    }
}