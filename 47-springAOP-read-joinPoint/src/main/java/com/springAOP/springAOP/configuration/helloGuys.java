package com.springAOP.springAOP.configuration;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.classfile.MethodSignature;

@Aspect
@Component
@Order(3)
public class helloGuys {
    @Before("execution(* com.springAOP.springAOP.dao.*.*(..))")
    public void helloGuys(JoinPoint joinPoint){
        Signature methodSignature= joinPoint.getSignature();
        System.out.println(methodSignature);
        Object[] args=joinPoint.getArgs();
        for(Object a:args){
            System.out.println(a);
        }
    }

}
