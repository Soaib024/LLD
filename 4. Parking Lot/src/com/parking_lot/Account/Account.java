package com.parking_lot.Account;

import com.parking_lot.model.AccountStatus;


public abstract class Account {
    private String userName;
    private String password;
    private Person person;
    private AccountStatus status;

    public abstract boolean resetPassword();
}
