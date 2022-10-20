package com.example.bankaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTextTextPersonName, editTextTextPersonName2, editTextTextPersonName3, editTextTextPersonName4, editTextNumber, editTextNumber2, editTextNumber3, editTextDate;
    CheckBox checkBox;
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        //editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        editTextDate = findViewById(R.id.editTextDate);

        checkBox = findViewById(R.id.checkBox);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = editTextTextPersonName.getText().toString();
                String lname = editTextTextPersonName2.getText().toString();
                String mname = editTextTextPersonName3.getText().toString();
                String gender = editTextTextPersonName4.getText().toString();

                int id = Integer.parseInt(editTextNumber.toString());
                int age = Integer.parseInt(editTextNumber2.toString());
                int accountnumber = Integer.parseInt(editTextNumber3.toString());

                Intent intent =new Intent(getApplicationContext(), MainActivity2.class);

                intent.putExtra("firstName", fname);
                intent.putExtra("lastname", lname);
                intent.putExtra("middlename", mname);
                intent.putExtra("id", id);
                intent.putExtra("gender", gender);
                intent.putExtra("age", age);
                intent.putExtra("account", accountnumber);

                startActivity(intent);
            }
        });

    }
}