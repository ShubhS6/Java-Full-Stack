package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configuration {
    @Bean("name")
    public coach football(){
        return new footballCoach();
    }
}
