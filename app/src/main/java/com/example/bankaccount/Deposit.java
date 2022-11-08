package com.example.bankaccount;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Deposit {

    public int total;

    public void depositAccount(String account_balance, String amount) {

        Integer accountBalance = Integer.parseInt(account_balance);
        Integer amountInput = Integer.parseInt(amount);

        this.total = accountBalance + amountInput;

//        account_balance.replace(total.toString());
    }
}
