package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
    private coach mycoach;

    @Autowired
    public void setmethod(coach thecoach){
        mycoach=thecoach;
    }

    @GetMapping("/get")
    public String getDaily(){
        return mycoach.getDailyWorkout();
    }
}