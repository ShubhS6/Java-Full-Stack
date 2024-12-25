package com.spring_crud_jpa.spring_crud_jpa.security;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String message) {
        super(message);
    }
}
