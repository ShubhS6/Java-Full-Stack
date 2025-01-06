package com.springAOP.springAOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class membershipDaoImpliment implements membershipDao{

    @Override
    public void addAccount() {
        System.out.println("Hello Membership Added");
    }

    @Override
    public String addSomething() {
        return "Hello I am String return type";
    }
}
