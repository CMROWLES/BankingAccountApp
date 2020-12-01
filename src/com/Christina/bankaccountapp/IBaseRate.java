package com.Christina.bankaccountapp;

public interface IBaseRate {
    //Interface is like a contract. Must follow through with everything listed in it( abstracted methods/fields).
    // Write a method that returns the base rate
    default double getBaseRate(){  // if you use default you can use the default modifier
        return 2.5;
    }

}
