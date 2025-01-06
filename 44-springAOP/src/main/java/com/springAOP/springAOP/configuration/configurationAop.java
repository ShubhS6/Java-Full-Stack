package com.springAOP.springAOP.configuration;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class configurationAop {
    //It is for only Example 1st and 2nd
    /*
    @Before("execution(public void addAccount())")
    public void beforeMethod(){
        System.out.println("Hello I am AOP Method");
    }
     */

    //It is for Example 3rd
    /*
    @Before("execution(public void com.springAOP.springAOP.dao.accountDao.addAccount())")
    public void beforeMethod(){
        System.out.println("Hello I am an AOP method");
    }
     */

    //It is for 4th example
    /*
    @Before("execution(public void add*())")
    public void beforeMethod(){
        System.out.println("Hello I am an AOP method");
    }
     */

    //5thth example
    /*
    @Before("execution(public * add*())")
    public void beforeMethod(){
        System.out.println("hello I am an AOP Method");
    }
     */

    //6th example
    @Before("execution(public * add*(com.springAOP.springAOP.model.account))")
    public void beforeMethod(){
        System.out.println("hello I am an AOP Method");
    }

    //And if we want to add more parameter then just simple do @Before("execution(public * add*(com.springAOP.springAOP.model.account,..))")
    //for single parameter of any type we can simple do @Before("execution(public * add*(*))")
    //for two or more parameter simple do @Before("execution(public * add*(..))")
}
