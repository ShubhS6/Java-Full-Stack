package com.springAOP.springAOP.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class helloFriend {
    @Before("execution(* com.springAOP.springAOP.dao.*.*(..))")
    public void hellofriend(){
        System.out.println("Hello friend Before");
    }
}
