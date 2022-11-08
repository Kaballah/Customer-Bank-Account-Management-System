package com.example.bankaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView textView2, textView19, textView20, textView21, textView22, textView26;
    Button button3, button6, button7, button8, button9, button10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = findViewById(R.id.textView2);
        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        textView26 = findViewById(R.id.textView26);

        button3 = findViewById(R.id.button3);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);

        Intent intent = getIntent();

        String fname =intent.getStringExtra("firstname");
        String lname =intent.getStringExtra("lastname");
        String pnumber =intent.getStringExtra("phonenumber");
        String id =intent.getStringExtra("id");
        String gender =intent.getStringExtra("gender");
        String dob =intent.getStringExtra("dateofbirth");
        String age =intent.getStringExtra("age");
        String account =intent.getStringExtra("account");

        textView19.setText(fname);
        textView20.setText(lname);
        textView21.setText(pnumber);
        textView22.setText(id);
        textView26.setText(account);



        // Logs you out of the existing account for you to create a new account
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = "";
                String accountnumber = "";

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("id", id);
                intent.putExtra("accountnumber", accountnumber);

                startActivity(intent);
            }
        });
    }

    public TextView getTextView() {
        TextView balance = (TextView)findViewById(R.id.textView2);
        return balance;
    }

    public void sendToAnotherBank(View view) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bank to Bank Transaction ");
        StringBuffer alert = new StringBuffer();
        alert.append("\n\nEnter the details below; ");
        builder.setMessage(alert.toString());

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_layout_pro, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the
                // AlertDialog to the Activity
                EditText editText = customLayout.findViewById(R.id.editText);
                EditText editText2 = customLayout.findViewById(R.id.editText2);

                String account_balance = textView2.getText().toString();
                String account_number = textView26.getText().toString();

                Integer accountBalance = Integer.parseInt(account_balance);
                Integer amountDeductable = Integer.parseInt(editText2.getText().toString());

                if(accountBalance >= amountDeductable) {

                    accountBalance = accountBalance - amountDeductable;

                    textView2.setText(accountBalance.toString());
                    sendDialogDataToActivity(editText.getText().toString(), editText2.getText().toString());

                    Account manageBalance = new Account();
                    manageBalance.AccountBalanceChecker(account_balance);

                } else {
                    Toast.makeText(MainActivity2.this, "You have insufficient Balance in your Account!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendDialogDataToActivity(String data, String data2) {
        Toast.makeText(this, "You have sent Ksh. " + data2 + " to account number " + data , Toast.LENGTH_SHORT).show();
    }

    public void sendToMobileMoney(View view) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Bank to Mobile Transaction ");
        StringBuffer alert = new StringBuffer();
        alert.append("\n\nEnter the details below; ");
        builder.setMessage(alert.toString());

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_layout_pro2, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the
                // AlertDialog to the Activity
                EditText editText3 = customLayout.findViewById(R.id.editText3);
                EditText editText4 = customLayout.findViewById(R.id.editText4);

                String account_balance = textView2.getText().toString();

                Integer accountBalance = Integer.parseInt(account_balance);
                Integer amountDeductable = Integer.parseInt(editText4.getText().toString());

                if(accountBalance >= amountDeductable) {

                    accountBalance = accountBalance - amountDeductable;

                    textView2.setText(accountBalance.toString());
                    sendDialogDataToActivity2(editText3.getText().toString(), editText4.getText().toString());

                    Account manageBalance = new Account();
                    manageBalance.AccountBalanceChecker(account_balance);
                } else {
                    Toast.makeText(MainActivity2.this, "You have insufficient Balance in your Account!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendDialogDataToActivity2(String data3, String data4) {
        Toast.makeText(this, "You have sent Ksh. " + data4 + " to phone number " + data3 , Toast.LENGTH_SHORT).show();
    }

    public void sendToPaybill(View view) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pay Your Bills ");
        StringBuffer alert = new StringBuffer();
        alert.append("\n\nEnter the details below; ");
        builder.setMessage(alert.toString());

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_layout_pro3, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the
                // AlertDialog to the Activity
                EditText editText1 = customLayout.findViewById(R.id.editText1);
                EditText editText2 = customLayout.findViewById(R.id.editText2);
                EditText editText3 = customLayout.findViewById(R.id.editText3);

                String account_balance = textView2.getText().toString();

                Integer accountBalance = Integer.parseInt(account_balance);
                Integer amountDeductable = Integer.parseInt(editText3.getText().toString());

                if(accountBalance >= amountDeductable) {

                    accountBalance = accountBalance - amountDeductable;

                    textView2.setText(accountBalance.toString());
                    sendDialogDataToActivity(editText1.getText().toString(), editText2.getText().toString(), editText3.getText().toString());

                    Account manageBalance = new Account();
                    manageBalance.AccountBalanceChecker(account_balance);
                } else {
                    Toast.makeText(MainActivity2.this, "You have insufficient Balance in your Account!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendDialogDataToActivity(String data, String data2, String data3) {
        Toast.makeText(this, "You have sent Ksh. " + data3 + " to business number " + data + " and account number " + data2, Toast.LENGTH_SHORT).show();
    }

    public void sendToTillNumber(View view) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Buy Goods ");
        StringBuffer alert = new StringBuffer();
        alert.append("\n\nEnter the details below; ");
        builder.setMessage(alert.toString());

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_layout_pro4, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the
                // AlertDialog to the Activity
                EditText editText = customLayout.findViewById(R.id.editText);
                EditText editText2 = customLayout.findViewById(R.id.editText2);

                String account_balance = textView2.getText().toString();

                Integer accountBalance = Integer.parseInt(account_balance);
                Integer amountDeductable = Integer.parseInt(editText2.getText().toString());

                if(accountBalance >= amountDeductable) {

                    accountBalance = accountBalance - amountDeductable;

                    textView2.setText(accountBalance.toString());
                    sendDialogDataToActivity3(editText.getText().toString(), editText2.getText().toString());

                    Account manageBalance = new Account();
                    manageBalance.AccountBalanceChecker(account_balance);
                } else {
                    Toast.makeText(MainActivity2.this, "You have insufficient Balance in your Account!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendDialogDataToActivity3(String data, String data2) {
        Toast.makeText(this, "You have sent Ksh. " + data2 + " to till number " + data, Toast.LENGTH_SHORT).show();
    }

    public void buyAirtime(View view) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Buy Airtime ");
        StringBuffer alert = new StringBuffer();
        alert.append("\n\nEnter the details below; ");
        builder.setMessage(alert.toString());

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_layout_pro5, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the
                // AlertDialog to the Activity
                EditText editText = customLayout.findViewById(R.id.editText);
                EditText editText2 = customLayout.findViewById(R.id.editText2);

                String account_balance = textView2.getText().toString();

                Integer accountBalance = Integer.parseInt(account_balance);
                Integer amountDeductable = Integer.parseInt(editText2.getText().toString());

                if(accountBalance >= amountDeductable) {

                    accountBalance = accountBalance - amountDeductable;

                    textView2.setText(accountBalance.toString());
                    sendDialogDataToActivity4(editText.getText().toString(), editText2.getText().toString());

                    Account manageBalance = new Account();
                    manageBalance.AccountBalanceChecker(account_balance);
                } else {
                    Toast.makeText(MainActivity2.this, "You have insufficient Balance in your Account!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendDialogDataToActivity4(String data, String data2) {
        Toast.makeText(this, "You bought airtime of Ksh. " + data2 + " for phone number " + data, Toast.LENGTH_SHORT).show();
    }

    public void withdrawFromAgent(View view) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Withdraw From an Agent ");
        StringBuffer alert = new StringBuffer();
        alert.append("\n\nEnter the details below; ");
        builder.setMessage(alert.toString());

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_layout_pro6, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the
                // AlertDialog to the Activity
                EditText editText = customLayout.findViewById(R.id.editText);
                EditText editText2 = customLayout.findViewById(R.id.editText2);

                String account_balance = textView2.getText().toString();

                Integer accountBalance = Integer.parseInt(account_balance);
                Integer amountDeductable = Integer.parseInt(editText2.getText().toString());

                if(accountBalance >= amountDeductable) {

                    accountBalance = accountBalance - amountDeductable;

                    Account manageBalance = new Account();
                    manageBalance.AccountBalanceChecker(account_balance);

                    textView2.setText(accountBalance.toString());
                    sendDialogDataToActivity5(editText.getText().toString(), editText2.getText().toString());

                } else {
                    Toast.makeText(MainActivity2.this, "You have insufficient Balance in your Account!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendDialogDataToActivity5(String data, String data2) {
        Toast.makeText(this, "Your withdrawal of Ksh. " + data2 + " from agent number " + data + " has been successful", Toast.LENGTH_SHORT).show();
    }

    public void depositToAccount(View view) {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Deposit to Account ");
        StringBuffer alert = new StringBuffer();
        alert.append("\n\nEnter the ammount you want to deposit below; ");
        builder.setMessage(alert.toString());

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_layout_pro7, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // send data from the
                // AlertDialog to the Activity
                EditText editText = customLayout.findViewById(R.id.editText);

                String account_balance = textView2.getText().toString();
                String amount = editText.getText().toString();

                Integer account_total;

                Deposit manageBalance = new Deposit();
                manageBalance.depositAccount(account_balance, amount);

                account_total = manageBalance.total;

                textView2.setText(account_total.toString());

                sendDialogDataToActivity6(editText.getText().toString());
//                Toast.makeText(MainActivity2.this, "You have insufficient Balance in your Account!", Toast.LENGTH_SHORT).show();
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendDialogDataToActivity6(String data) {
        Toast.makeText(this, " You have made a deposit of Ksh " + data, Toast.LENGTH_SHORT).show();
    }
}