package com.testback.exception;

public class CandidateByTechnologyNotFoundException extends RuntimeException{
    public CandidateByTechnologyNotFoundException(String msg){
        super(msg);
    }
}
