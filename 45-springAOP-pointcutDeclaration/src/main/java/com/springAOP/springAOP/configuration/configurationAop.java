package com.springAOP.springAOP.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class configurationAop {
    @Pointcut("execution(* com.springAOP.springAOP.dao.*.*(..))")
    public void runCommand(){}

    @Before("runCommand() && !(getter() || setter())")
    public void hello(){
        System.out.println("hello I am the before method without setter getter before");
    }
    /*
    @Before("runCommand()")
    public void helloGuys(){
        System.out.println("Hello guys I am the second reuse");
    }
     */

    @Pointcut("execution(* com.springAOP.springAOP.dao.*.get*(..))")
    public void getter(){}


    @Pointcut("execution(* com.springAOP.springAOP.dao.*.set*(..))")
    public void setter(){}




}
