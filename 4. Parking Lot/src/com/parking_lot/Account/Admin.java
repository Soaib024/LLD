package com.parking_lot.Account;


public class Admin extends Account{
    
    @Override
    public boolean resetPassword() {
        return true;
      }
}
