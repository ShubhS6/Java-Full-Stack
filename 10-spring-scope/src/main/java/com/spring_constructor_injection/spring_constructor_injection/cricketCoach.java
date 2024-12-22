package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class cricketCoach implements coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling";
    }
}
