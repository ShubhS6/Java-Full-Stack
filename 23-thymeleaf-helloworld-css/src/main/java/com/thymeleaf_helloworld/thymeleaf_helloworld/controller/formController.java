package com.thymeleaf_helloworld.thymeleaf_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class formController {
    @GetMapping("/hello")
    public String form(){
        return "form";
    }

    @PostMapping("/submitForm")
    public String hello(){
        return "hello-world";
    }
}
