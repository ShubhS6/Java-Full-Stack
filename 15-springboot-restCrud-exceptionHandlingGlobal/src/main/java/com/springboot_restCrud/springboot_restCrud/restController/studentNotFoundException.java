package com.springboot_restCrud.springboot_restCrud.restController;

public class studentNotFoundException extends RuntimeException {
    public studentNotFoundException(String s) {
        super(s);
    }
}
