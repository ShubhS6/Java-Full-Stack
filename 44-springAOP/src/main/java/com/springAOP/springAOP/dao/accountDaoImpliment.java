package com.springAOP.springAOP.dao;

import com.springAOP.springAOP.model.account;
import org.springframework.stereotype.Repository;

@Repository
public class accountDaoImpliment implements accountDao{
    //@Override
    //public void addAccount() {
    //    System.out.println("Hello Account Added");
    //}

    @Override
    public void addSimpleMethod() {
        System.out.println("I am simple Method start with add");
    }

    @Override
    public void addAccount(account account) {
        System.out.println(getClass());
    }
}
