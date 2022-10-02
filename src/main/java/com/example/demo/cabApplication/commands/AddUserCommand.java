package com.example.demo.cabApplication.commands;

import com.example.demo.cabApplication.entites.Gender;
import com.example.demo.cabApplication.entites.User;
import com.example.demo.cabApplication.services.IUserOnboardingServices;

import java.util.List;
import java.util.Objects;

public class AddUserCommand implements ICommand{
    private final IUserOnboardingServices userOnboardingServices;

    public AddUserCommand(IUserOnboardingServices userOnboardingServices) {
        this.userOnboardingServices = userOnboardingServices;
    }

    @Override
    public void execute(List<String> tokens) {
        String name = tokens.get(1);
        String g = tokens.get(2);
        Integer age = Integer.parseInt(tokens.get(3));
        Gender gender; if(Objects.equals(g, "M")) gender = Gender.M; else  gender = Gender.F;
        try {
            User u =  userOnboardingServices.createUser(name,gender,age);
        } catch (NullPointerException e){
            System.out.println("please enter all information");
        }

    }
}
