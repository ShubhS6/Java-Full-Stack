package com.spring_constructor_injection.spring_constructor_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoController {
    private coach crickCoachOne;
    private coach crickCoachTwo;

    @Autowired
    public demoController(@Qualifier("cricketCoach") coach crickCoachO,@Qualifier("cricketCoach") coach crickCoachT){
        crickCoachOne=crickCoachO;
        crickCoachTwo=crickCoachT;
    }

    @GetMapping("/get")
    public String getDaily(){
        return "Compare is "+(crickCoachOne==crickCoachTwo);
    }
}
