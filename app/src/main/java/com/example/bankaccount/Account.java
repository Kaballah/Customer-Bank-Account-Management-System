package com.example.bankaccount;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public abstract class Account extends Context {

    public void AccountBalanceChecker(String accountNumber) {
        Integer accNumber = Integer.parseInt(accountNumber);

        if(accNumber < 1000) {

        }

    }

    public void AccountBalanceAdder(String accountNumber) {
        Integer accNumber = Integer.parseInt(accountNumber);

        StringBuffer alert = new StringBuffer();
        alert.append("Thank you for creating an account with us. \n\n");
        alert.append("We as Equality Bank are dedicated to keeping your account safe at all times. If you feel like you have an issue" +
                "with your account, kindly contact our support team at +254 769 692 554 and they will respond to your issue. \n\n");
        alert.append("Welcome to the eco-system of banking. \n" +
                "Bank with the Best \n" +
                "And for the best \n\n");

                    /* Calling the alert dialog builder to create for us a new dialog box
                    which will be displayed in this activity */
        AlertDialog.Builder builder = new AlertDialog.Builder(Account.this);

        // Setting the cancelability to false/We can't cancel the dialog box
        builder.setCancelable(false);

        // Setting the title of the alert box
        builder.setTitle("Account Created");

        // Assigning the message to be displayed
        builder.setMessage(alert.toString());

        // Calling it to display
        builder.show();

    }
}

