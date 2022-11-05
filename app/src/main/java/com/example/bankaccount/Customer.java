package com.example.bankaccount;

public class Customer {

    /* Declaring and initializing a variable person1
    person1 is an array with a length of 8
    person1 mainly stores String as the datatype */
    String [] person1 = new String[8];

    /* Creating a method called customerDataNames which will be collecting the customer's firstname,
    lastname and phone number. This data is then sent to the respective indexes of the array person1 */
    public void customerDataNames (String firstName, String lastName, String phoneNumber) {
        person1[0] = firstName;
        person1[1] = lastName;
        person1[2] = phoneNumber;
    }

    // Doing the same here but the difference being we're actually using a method overload
    public void customerDataNames (String id, String gender, String dOB, String age) {
        person1[3] = id;
        person1[4] = gender;
        person1[5] = dOB;
        person1[6] = age;
    }

    // Same as here, we're using a method overload with one parameter
    public void customerDataNames (String accountNumber) {
        person1[7] = accountNumber;
    }
}
