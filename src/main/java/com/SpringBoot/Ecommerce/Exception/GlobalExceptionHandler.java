package com.SpringBoot.Ecommerce.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> resourceNotFoundException(ResourceNotFoundException obj){
        String message = obj.getMessage();
        return new ResponseEntity<>(Map.of("message",message), HttpStatus.NOT_FOUND);
    }
}
