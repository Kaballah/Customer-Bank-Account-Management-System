package com.example.bankaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Capturing the IDs belonging to the inputs and buttons on the .xml file
    EditText editTextTextPersonName, editTextTextPersonName2, editTextTextPersonName3, editTextTextPersonName4, editTextTextPersonName6, editTextTextPersonName7, editTextTextPersonName8, editTextDate;
    CheckBox checkBox;
    Button button, button2, button5;

    // Declaring variable that will be used to display the calender for a user to enter the DOB
    private int mYear, mMonth, mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning the IDs to different variables
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        editTextTextPersonName6 = findViewById(R.id.editTextTextPersonName6);
        editTextTextPersonName7 = findViewById(R.id.editTextTextPersonName7);
        editTextTextPersonName8 = findViewById(R.id.editTextTextPersonName8);
        editTextDate = findViewById(R.id.editTextDate);

        checkBox = findViewById(R.id.checkBox);

        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button5 = findViewById(R.id.button5);

        // Setting up an onClick event/listener for the Date field
        editTextDate.setOnClickListener(this);

        // Setting the submit button to be non-functional without agreeing to the bank's terms
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                // If a user check's the checkbox provide, it renders the submit button to be clickable/is enabled
                // Else, without the checkbox being checked, it's defaulted to be disabled.
                if(compoundButton.isChecked()) {
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }
        });

        // Setting up the functionality of the submit button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Changing the data captured to string and storing the strings in their respective variables
                String fname = editTextTextPersonName.getText().toString();
                String lname = editTextTextPersonName2.getText().toString();
                String pnumber = editTextTextPersonName3.getText().toString();
                String id = editTextTextPersonName6.getText().toString();
                String gender = editTextTextPersonName4.getText().toString();
                String dob = editTextDate.getText().toString();
                String age = editTextTextPersonName7.getText().toString();
                String accountnumber = editTextTextPersonName8.getText().toString();

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

                // Using String Buffer feature to create a pop-up message

                // Toasting an error when an input field is empty
                if(fname.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a first name!", Toast.LENGTH_SHORT).show();
                } else if(lname.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Please enter a last name!", Toast.LENGTH_SHORT).show();
                } else if(pnumber.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a phone number!", Toast.LENGTH_SHORT).show();
                } else if(id.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter an ID number!", Toast.LENGTH_SHORT).show();
                } else if(gender.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a gender!", Toast.LENGTH_SHORT).show();
                }  else if(dob.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your date of birth!", Toast.LENGTH_SHORT).show();
                } else if(age.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter your age!", Toast.LENGTH_SHORT).show();
                } else if(accountnumber.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter an account number!", Toast.LENGTH_SHORT).show();
                } else {

                    // Using the Intent feature so as to send the captured data into the MainActivity2's class
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);

                    // Creating an object for "linking" the MainActivity to the Customer class
                    Customer Person1 = new Customer();

                    /* Capturing the data of the variables declared earlier and assigning them
                    to the methods in Customer class */
                    Person1.customerDataNames(fname, lname, pnumber);
                    Person1.customerDataNames(id, gender, dob, age);
                    Person1.customerDataNames(accountnumber);

                    StringBuffer alert = new StringBuffer();
                    alert.append("Thank you for creating an account with us. \n\n");
                    alert.append("We as Equality Bank are dedicated to keeping your account safe at all times. If you feel like you have an issue" +
                            "with your account, kindly contact our support team at +254 769 692 554 and they will respond to your issue. \n\n");
                    alert.append("Welcome to the eco-system of banking. \n" +
                            "Bank with the Best \n" +
                            "And for the best \n\n");

                    /* Calling the alert dialog builder to create for us a new dialog box
                    which will be displayed in this activity */
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    // Setting the cancelability to false/We can't cancel the dialog box
                    builder.setCancelable(false);

                    // Rather, we create a continue button to go into the next activity
                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {

                        // Setting an onClick listener for when someone clocks on it
                        public void onClick(DialogInterface dialogInterface, int id) {

                            // "Pushing" the data captured to the next activity(MainActivity2)
                            intent.putExtra("firstname", Person1.person1[0]);
                            intent.putExtra("lastname", Person1.person1[1]);
                            intent.putExtra("phonenumber", Person1.person1[2]);
                            intent.putExtra("id", Person1.person1[3]);
                            intent.putExtra("gender", Person1.person1[4]);
                            intent.putExtra("dateofbirth", Person1.person1[5]);
                            intent.putExtra("age", Person1.person1[6]);
                            intent.putExtra("account", Person1.person1[7]);

                            // This is meant to commence the action of "pushing"
                            startActivity(intent);

                        /* This is a toast message that will be displayed
                        after someone has created an account */
                            Toast.makeText(getApplicationContext(), "Thank you for creating an account", Toast.LENGTH_SHORT).show();
                        }
                    });

                    // Setting the title of the alert box
                    builder.setTitle("Account Created");

                    // Assigning the message to be displayed
                    builder.setMessage(alert.toString());

                    // Calling it to display
                    builder.show();
                }
            }
        });

//        button5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String id = editTextTextPersonName6.getText().toString();
//                String gender = editTextTextPersonName4.getText().toString();
//                String dob = editTextDate.getText().toString();
//                String age = editTextTextPersonName7.getText().toString();
//                String accountnumber = editTextTextPersonName8.getText().toString();
//
//                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
//
//                Customer Person1 = new Customer();
//
//                Person1.customerDataNames(id, gender, dob, age);
//                Person1.customerDataNames(accountnumber);
//
//                intent.putExtra("id", Person1.person1[3]);
//                intent.putExtra("accountnumber", Person1.person1[7]);
//
//                startActivity(intent);
//
//            }
//        });

    }

    /* Meant to display and allow the user to select a date from the calendar
    to represent the date of birth */
    @Override
    public void onClick(View v) {
        if (v == editTextDate) {
            final Calendar c = Calendar.getInstance();

            // Assigning values to the variables we created earlier
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
