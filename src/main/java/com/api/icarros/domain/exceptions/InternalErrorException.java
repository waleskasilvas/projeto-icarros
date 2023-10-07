package com.api.icarros.domain.exceptions;

public class InternalErrorException extends RuntimeException{
    public InternalErrorException(String message){
        super(message);
    }
}
