package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.stereotype.Component;

@Component
public class footballCoach implements coach{

    @Override
    public String getDailyWorkout() {
        return "Fast running";
    }
}
