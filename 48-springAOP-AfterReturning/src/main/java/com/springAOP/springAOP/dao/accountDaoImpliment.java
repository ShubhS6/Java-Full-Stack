package com.springAOP.springAOP.dao;

import com.springAOP.springAOP.model.account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class accountDaoImpliment implements accountDao{
    private String fname;
    private String lname;
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

    @Override
    public String getFirstName() {
        return fname;
    }

    @Override
    public String getLastName() {
        return lname;
    }

    @Override
    public void setFirstName(String fname) {
        this.fname=fname;
    }

    @Override
    public void setLastName(String lname) {
        this.lname=lname;
    }

    @Override
    public List<account> findAccount() {
        List<account> acc=new ArrayList<>();
        acc.add(new account("Shubh","Vish"));
        acc.add(new account("Sumi","Vish"));
        acc.add(new account("Ana","Vish"));
        return acc;
    }
}
