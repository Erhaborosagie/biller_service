package com.example.util.exceptions;

/**
 * Created by Osagie Erhabor on 14/01/2020.
 */
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable throwable){
        super(message, throwable);
    }
}
