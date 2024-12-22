package com.spring_actuator.spring_actuator.actuatorController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @GetMapping("/")
    public String hello(){
        return "Hello Actuator";
    }
}
