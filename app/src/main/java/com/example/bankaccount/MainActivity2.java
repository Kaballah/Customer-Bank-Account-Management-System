package com.example.bankaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView19 = findViewById(R.id.textView19);
        textView20 = findViewById(R.id.textView20);
        textView21 = findViewById(R.id.textView21);
        textView22 = findViewById(R.id.textView22);
        textView23 = findViewById(R.id.textView23);
        textView24 = findViewById(R.id.textView24);
        textView25 = findViewById(R.id.textView25);
        textView26 = findViewById(R.id.textView26);

        button3 = findViewById(R.id.button3);

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
        textView23.setText(gender);
        textView24.setText(dob);
        textView25.setText(age);
        textView26.setText(account);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = textView22.getText().toString();
                String accountnumber = textView26.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);

                intent.putExtra("id", id);
                intent.putExtra("accountnumber", accountnumber);

                startActivity(intent);
            }

        });

    }
}