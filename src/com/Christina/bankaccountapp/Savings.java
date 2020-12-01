package com.Christina.bankaccountapp;

public class Savings extends Account {
    // List properties specific to the savings account
    int safetyDepositBoxID;
    int safetyDepositBoxKey;
    final String accountType = "Savings";

    // Constructor to initialize setting for the Savings properties

    // List any methods specific to savings account

    public Savings(String name, String sSN, double initDeposit){
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();

    }

    public void setRate(){
        rate = getBaseRate() - .25;
    }

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int) (Math.random()* Math.pow(10,4) );
    }

    @Override
    public void showInfo(){
       super.showInfo();
        System.out.println(
                "Your Savings Account Features" +
                        "\n Safety Deposit Box ID: " + safetyDepositBoxID +
                        "\n Safety Deposit Box Key: " + safetyDepositBoxKey
                );
    }



}
