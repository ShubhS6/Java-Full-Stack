package com.spring_crud_jpa.spring_crud_jpa.security;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class controller {
    @ExceptionHandler
    public ResponseEntity<exceptionClass> handleException(InvalidIdException ex){
        exceptionClass ec=new exceptionClass();
        ec.setMessage(ex.getMessage());
        ec.setStatus(HttpStatus.NOT_FOUND.value());
        ec.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(ec,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<exceptionClass> handleNameNotFound(nameNotFound ex){
        exceptionClass ec=new exceptionClass();
        ec.setStatus(HttpStatus.NOT_FOUND.value());
        ec.setMessage(ex.getMessage());
        ec.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(ec,HttpStatus.NOT_FOUND);
    }
}
