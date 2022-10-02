package com.example.demo.cabApplication.exceptions;

public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(){
        super();
    }
    public DriverNotFoundException(String msg){
        super(msg);
    }
}
