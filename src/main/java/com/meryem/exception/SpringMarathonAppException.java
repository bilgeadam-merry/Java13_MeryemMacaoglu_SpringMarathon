package com.meryem.exception;

import lombok.Getter;

@Getter
public class SpringMarathonAppException extends RuntimeException{

    private final ErrorType errorType;
    public SpringMarathonAppException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public SpringMarathonAppException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}