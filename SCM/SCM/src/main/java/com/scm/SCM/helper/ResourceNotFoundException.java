package com.scm.SCM.helper;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message){
        super(message);

    }

    public ResourceNotFoundException(){
        super("Resourece not found");

    }

}
