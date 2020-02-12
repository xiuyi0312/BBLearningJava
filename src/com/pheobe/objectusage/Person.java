package com.pheobe.objectusage;

/**
 * CSCI 1110
 *
 * @author ASiegel and YOU
 */

public class Person {

    // PLEASE START YOUR CODE HERE
    // ===========================
    private String firstName;
    private String lastName;

    // ===========================
    // PLEASE END YOUR CODE HERE

    //constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String toString() {
        return firstName + " " + lastName;
    }


}
