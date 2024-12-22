package com.spring_crud_jpa.spring_crud_jpa.exceptionClass;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }
}
