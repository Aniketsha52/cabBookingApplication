package com.example.demo.cabApplication.entites;

import java.util.Objects;

public class User extends BaseEntity{
    private final String name;
    private final Gender gender;
    private  Integer age;

    public User(String name, Gender gender, Integer age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public User(String id,String name, Gender gender, Integer age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getName().equals(user.getName()) && getGender() == user.getGender() && getAge().equals(user.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getGender(), getAge());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }


}
