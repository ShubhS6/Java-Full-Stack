package com.springboot_security.springBootSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class cards {
    @GetMapping("/cards")
    public String getCards() {
        return "cards";
    }
}
