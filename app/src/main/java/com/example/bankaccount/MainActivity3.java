package com.example.bankaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity3 extends AppCompatActivity {

    EditText editTextTextPersonName5, editTextTextPersonName9;
    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editTextTextPersonName5 = findViewById(R.id.editTextTextPersonName5);
        editTextTextPersonName9 = findViewById(R.id.editTextTextPersonName9);
        button4 = findViewById(R.id.button4);

//        editTextTextPersonName5.setText(id);
//        editTextTextPersonName9.setText(account);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id_number = editTextTextPersonName5.getText().toString();
                Integer idNumber = Integer.parseInt(id_number);

                Intent intent = getIntent();

                String id = intent.getStringExtra("id");
                String account =intent.getStringExtra("accountnumber");

                Integer id2 = Integer.parseInt(id);

//                if(idNumber != id2) {
//                    editTextTextPersonName9.setText(account);
//                } else {
//                    editTextTextPersonName9.setText("Wrong Id Number");
//                }



            }
        });
    }
}