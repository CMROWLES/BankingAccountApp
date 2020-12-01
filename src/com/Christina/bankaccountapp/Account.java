package com.Christina.bankaccountapp;

import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

public abstract class Account implements IBaseRate {
    // A standardization that all accounts must have
    // Abstract classes can not be instantiated ( Cannot have an instance of )
    // Abstract has general/ generic outline but leaves the implementation to the subclasses

    // List common properties for savings and checking accounts

   private String name;
   private String sSN;
   private double balance;
   protected String accountNumber;
   protected double rate;
    String accountType;

    static int index = 10000;

    //Constructor to set base properties and initialize the account

    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        balance = initDeposit;


        // Set account number
        index ++;
        this.accountNumber = this.setAccountNumber();

        setRate();

    }

    public abstract void setRate(); // because savings and checking extend/inherit from account( this class)
                                    // this being an abstract method in the account class essentially states the savings
                                    // and checking has to implement this method... they would be overriding the method

    public void compound(){
        double accruedInterest = balance * (rate/100);
        // double accruedInterest = (this.balance) * (rate/100);
        balance = balance + accruedInterest;
        //this.balance += accruedInterest;
        System.out.println("Accrued interest: $" + accruedInterest);
        //System.out.printf("Your current balance in " %2f\n", accruedInterest);
        printBalance();
    }

    // List common methods
    public void deposit(double amount){
        balance = balance + amount;
        // balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }
    public void withdraw(double amount){
        balance = balance - amount;
        // balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();

    }


    public void transfer(Account account, double amount){
        balance = balance - amount;
        account.balance = account.balance + amount;
        System.out.println("Transferring $" + amount + " and the balance is " + account.balance);
        printBalance();

    }

    public void printBalance(){
        System.out.println("Your balance is now: $" + balance);
    }
    public void showInfo(){
        System.out.println(
                "NAME: " + name +
                        "\nACCOUNT NUMBER: " + accountNumber +
                        "\nBALANCE: " + balance +
                        "\nRATE: " + rate + "%"
                        );
    }





    private String setAccountNumber(){
        String lastTwoOfSSN = sSN.substring(sSN.length()-2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10,3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

}
