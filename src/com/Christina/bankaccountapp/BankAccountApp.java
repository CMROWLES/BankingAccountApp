package com.Christina.bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<Account>();


//
//        Checking chkacc1 = new Checking("Tom Wilson", "123456789",1500);
//        Savings savacc1 = new Savings("Rich Lowe", "234567890", 2500);
//
//        Checking myChecking = new Checking("Brionna Rowles", "102938475", 2000);
//        Savings mySavings = new Savings("Myranda ","384857694", 0);

//        savacc1.showInfo();
//        System.out.println("----------------------------------");
//        chkacc1.showInfo();
//
//        savacc1.deposit(5000);
//        savacc1.withdraw(200);
//        savacc1.transfer("Brokerage", 3000);

//        System.out.println("-------------------------------------");
//
//        myChecking.deposit( 200);
//        myChecking.withdraw(70);
//        myChecking.transfer(mySavings, 40);
//
//        myChecking.compound();

        //Read a CSV file and create new accounts based on that data

        String file = "C:\\Users\\Student Admin\\Documents\\NewBankAccounts.csv";

        List<String[]>  newAccountHolders = com.Christina.bankaccountapp.utilities.CSV.read(file);
        for( String [] accountHolder : newAccountHolders){
            String name = accountHolder[0];
            String sSN =accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit =  Double.parseDouble(accountHolder[3]);
            if (accountType.equals("Savings")){
                accounts.add(new Savings(name, sSN, initDeposit));
            }
            else if (accountType.equals("Checking")){
                accounts.add(new Checking(name, sSN, initDeposit));
            }
            else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }

        }

        for (Account acc : accounts){
            System.out.println("********************************");
            acc.showInfo();
        }

    }
}
