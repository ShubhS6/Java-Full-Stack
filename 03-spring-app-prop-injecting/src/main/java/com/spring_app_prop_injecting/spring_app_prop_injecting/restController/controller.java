package com.spring_app_prop_injecting.spring_app_prop_injecting.restController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Value("${coach.value}")
    private String coachName;

    @GetMapping("/")
    public String name(){
        return "Hello name"+" "+coachName;
    }
}
