package com.bhargav.texashamco.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String data, String model){
        super(String.format(model + " with data " + data + " NOT FOUND"));
    }
}
