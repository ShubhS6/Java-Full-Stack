package com.spring_boot_demo.spring_boot_demo.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @GetMapping("/")
    public String Hello(){
        return "Hello world";
    }
}
