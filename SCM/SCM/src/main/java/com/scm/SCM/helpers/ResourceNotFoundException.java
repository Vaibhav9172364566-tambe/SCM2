package com.scm.SCM.helpers;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);

    }

    public ResourceNotFoundException(){
        super("Resourece not found");

    }

}
