package com.example.demo.cabApplication.exceptions;

public class NoSuchCommandException extends RuntimeException{
    public NoSuchCommandException()
    {
        super();
    }
    public NoSuchCommandException(String msg)
    {
        super(msg);
    }
}