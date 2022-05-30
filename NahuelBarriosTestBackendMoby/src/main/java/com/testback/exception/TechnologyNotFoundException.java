package com.testback.exception;

public class TechnologyNotFoundException extends RuntimeException{
    public TechnologyNotFoundException(String msg){
        super(msg);
    }
}
