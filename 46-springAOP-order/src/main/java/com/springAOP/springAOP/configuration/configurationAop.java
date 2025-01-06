package com.springAOP.springAOP.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class configurationAop {
    /*
    //so here we use order to resolve that which before method should call

    @Before("execution(* com.springAOP.springAOP.dao.*.*(..))")
    public void helloGuys(){
        System.out.println("Hello guys Before");
    }

    @Before("execution(* com.springAOP.springAOP.dao.*.*(..))")
    public void hellofriend(){
        System.out.println("Hello friend Before");
    }

    @Before("execution(* com.springAOP.springAOP.dao.*.*(..))")
    public void hellofamily(){
        System.out.println("Hello Family Before");
    }




     */
}
