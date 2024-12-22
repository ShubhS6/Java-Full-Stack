package com.spring_component_scan.spring_component_scan.rest;

import hello.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {

    private Coach coach;
    @Autowired
    public demoController(Coach mycoach) {
        coach = mycoach;
    }
    @GetMapping("/get")
    public String get(){
        return coach.getdaily();
    }
}
