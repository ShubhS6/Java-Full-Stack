package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class hockeyCoach implements coach{

    public hockeyCoach(){
        System.out.println("Hockey constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Hockey Playing";
    }
}
