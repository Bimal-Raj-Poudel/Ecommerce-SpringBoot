package com.SpringBoot.Ecommerce.Exception;

public class ResourceNotFoundException extends RuntimeException{

    String field;
    String Value;

    public ResourceNotFoundException(String field, String value, Integer id) {
        super(String.format("%s of %s : %d not found.", field, value, id));
        this.field = field;
        Value = value;
    }
}
