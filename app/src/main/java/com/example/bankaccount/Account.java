package com.example.bankaccount;

import android.app.Activity;
import android.app.AlertDialog;

public class Account extends Activity {

    public void depositPrompt() {
//        Toast.makeText(this, "Balance is below Ksh 1000. Kindly recharge your account", Toast.LENGTH_LONG).show();

        AlertDialog.Builder builder = new AlertDialog.Builder(new Account());
        builder.setTitle("Account balance is low ");
        StringBuffer alert = new StringBuffer();
        alert.append("\n\nYour account balance has hit below Ksh 1000. Kindly make a deposit soon to continue enjoying our services. ");
        builder.setMessage(alert.toString());
        builder.setCancelable(true);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void AccountBalanceChecker(String accountBalance) {

        Integer account_balance = Integer.parseInt(accountBalance);

//        Account balanceChecker = new Account();
//        balanceChecker.depositPrompt();

        if (account_balance < 1000) {
            Account balanceChecker = new Account();
            balanceChecker.depositPrompt();
        };
    }
}

