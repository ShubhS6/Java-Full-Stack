package com.springboot_security.springBootSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class contact {
    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }
}