package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.stereotype.Component;

@Component
public class cricketCoach implements coach{

    public cricketCoach(){
        System.out.println("cricket Constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Cricket Playing";
    }
}
