package com.springAOP.springAOP.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class helloGuys {
    @Before("execution(* com.springAOP.springAOP.dao.*.*(..))")
    public void helloGuys(){
        System.out.println("Hello guys Before");
    }

}
