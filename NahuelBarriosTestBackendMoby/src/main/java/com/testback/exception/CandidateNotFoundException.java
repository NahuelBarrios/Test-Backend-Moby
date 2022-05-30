package com.testback.exception;

public class CandidateNotFoundException extends RuntimeException{

    public CandidateNotFoundException(String msg){
        super(msg);
    }
}
