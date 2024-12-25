package com.spring_crud_jpa.spring_crud_jpa.exceptionClass;

public class nameNotFound extends RuntimeException {
    public nameNotFound(String message) {
        super(message);
    }
}
