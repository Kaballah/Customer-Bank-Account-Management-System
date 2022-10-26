package com.example.bankaccount;

public class Customer {

    String [] person1 = new String[3];

//    person1[0] = new String (Fname);

    String Fname;
    String Lname;
    String pnumber;
    int id;
    String gender;
    String dateOfBirth;
    int age;
    int accountNumber;

//    public String getFname() {
//        return Fname;
//    }
//
//    public void setFname (String fname) {
//        Fname = fname;
//    }

    public void customerDataNames (String firstName, String lastName, String phoneNumber) {
        this.Fname = firstName;
        this.Lname = lastName;
        this.pnumber = phoneNumber;
    }

//    public void customerDataLastName () {
//        this.Lname = lastName;
//    }


}
