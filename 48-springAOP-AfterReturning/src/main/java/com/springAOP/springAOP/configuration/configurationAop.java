package com.springAOP.springAOP.configuration;

import com.springAOP.springAOP.model.account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class configurationAop {

    //so here we use order to resolve that which before method should call

    @AfterReturning(pointcut="execution(* com.springAOP.springAOP.dao.accountDao.findAccount(..))",
    returning = "result")
    public void afterReturn(JoinPoint joinPoint, List<account> result){
        String method=joinPoint.getSignature().toString();
        System.out.println("Execution of after returning "+method);
        System.out.println("result of after returning is "+result);
        convertToUpperCase(result);
        System.out.println("after manipulation");
        System.out.println(result);
    }

    public void convertToUpperCase(List<account> acc) {
        for (account a : acc) {
            String upper = a.getFirstName().toUpperCase();
            a.setFirstName(upper);
        }
    }


    @Before("execution(* com.springAOP.springAOP.dao.accountDao.findAccount(..))")
    public void helloGuys(){
        System.out.println("Hello guys Before");
    }
    /*

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
