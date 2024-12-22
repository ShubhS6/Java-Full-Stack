package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//If we use Quantifier and Primary both then the winner will be Quantifier
public class cricketCoach implements coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling";
    }
}
