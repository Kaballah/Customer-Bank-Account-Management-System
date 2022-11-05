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

    public void showAlertDialogButtonClicked(View view) {
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
                sendDialogDataToActivity(editText.getText().toString(), editText2.getText().toString());

//                sendDialogDataToActivity(editText2.getText().toString());
            }
        });

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void sendDialogDataToActivity(String data, String data2) {
        Toast.makeText(this, "You have sent Ksh. " + data2 + " to account number " + data , Toast.LENGTH_SHORT).show();
    }
}