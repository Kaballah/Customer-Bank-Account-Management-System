package com.example.bankaccount;

public class Customer {
    String fname;
    String mname;
    String lname;
    int id;
    String gender;
    String dateOfBirth;
    int age;
    int accountNumber;

    public Customer (String fname, String mname,String lname) {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
    }

    public void idNumber (int id_number) {
        id = id_number;
    }

    public void customerGender (String customer_gender) {
        gender = customer_gender;
    }

    public void customerDateOfBirth (String date_of_birth) {
        dateOfBirth =date_of_birth;
    }

    public void customerAge (int customer_age) {
        age = customer_age;
    }

    public void customerAccountNumber (int account_number) {
        accountNumber = account_number;
    }
}
