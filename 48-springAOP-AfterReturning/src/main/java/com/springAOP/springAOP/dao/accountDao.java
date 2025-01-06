package com.springAOP.springAOP.dao;

import com.springAOP.springAOP.model.account;

import java.util.List;

public interface accountDao {
   // void addAccount();
    void addSimpleMethod();
    void addAccount(account account);
    String getFirstName();
    String getLastName();
    void setFirstName(String fname);
    void setLastName(String lname);
    List<account> findAccount();
}
