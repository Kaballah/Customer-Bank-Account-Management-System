package com.example.bankaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editTextTextPersonName, editTextTextPersonName2, editTextTextPersonName3, editTextTextPersonName4, editTextTextPersonName6, editTextTextPersonName7, editTextTextPersonName8, editTextDate;
    CheckBox checkBox;
    Button button, button2;
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName6 = findViewById(R.id.editTextTextPersonName6);
        editTextTextPersonName7 = findViewById(R.id.editTextTextPersonName7);
        editTextTextPersonName8 = findViewById(R.id.editTextTextPersonName8);
        editTextDate = findViewById(R.id.editTextDate);

        editTextDate.setOnClickListener(this);

        checkBox = findViewById(R.id.checkBox);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String fname = editTextTextPersonName.getText().toString();
//                String lname = editTextTextPersonName2.getText().toString();
                String pnumber = editTextTextPersonName3.getText().toString();
                String id = editTextTextPersonName6.getText().toString();
                String gender = editTextTextPersonName4.getText().toString();
                String dob = editTextDate.getText().toString();
                String age = editTextTextPersonName7.getText().toString();
                String accountnumber = editTextTextPersonName8.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                Customer Person1 = new Customer();

//                Person1.fname = editTextTextPersonName.getText().toString();

                Person1.customerDataNames(editTextTextPersonName.getText().toString(), editTextTextPersonName2.getText().toString(), pnumber);
//                Person1.customerDataLastName();

//                String [][] customerData;
//                customerData = new String[8][8];
//
//                for(Integer i = 0; i < customerData.length; i++) {
//                    customerData[i][0] = new String(fname);
//                    customerData[i][1] = new String(lname);
//                    customerData[i][2] = new String(pnumber);
//                    customerData[i][3] = new String(id);
//                    customerData[i][4] = new String(gender);
//                    customerData[i][5] = new String(dob);
//                    customerData[i][6] = new String(age);
//                    customerData[i][7] = new String(accountnumber);
//
//                    intent.putExtra("firstname", customerData[i][0]);
//                    intent.putExtra("lastname", customerData[i][1]);
//                    intent.putExtra("phonenumber", customerData[i][2]);
//                    intent.putExtra("id", customerData[i][3]);
//                    intent.putExtra("gender", customerData[i][4]);
//                    intent.putExtra("dateofbirth", customerData[i][5]);
//                    intent.putExtra("age", customerData[i][6]);
//                    intent.putExtra("account", customerData[i][7]);
//                }

                intent.putExtra("firstname", Person1.Fname);
                intent.putExtra("lastname", Person1.Lname);
                intent.putExtra("phonenumber", pnumber);
                intent.putExtra("id", id);
                intent.putExtra("gender", gender);
                intent.putExtra("dateofbirth", dob);
                intent.putExtra("age", age);
                intent.putExtra("account", accountnumber);

                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View v) {
        if (v == editTextDate) {
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    editTextDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
    }
}