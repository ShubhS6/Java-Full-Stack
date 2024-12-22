package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy

//Or we can write in app.prop "spring.main.lazy-initialization=true".
public class footballCoach implements coach{

    public footballCoach(){
        System.out.println("football constructor");
    }

    @Override
    public String getDailyWorkout() {
        return "Football Playing";
    }
}
