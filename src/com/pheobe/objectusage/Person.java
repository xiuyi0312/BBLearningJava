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


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String toString() {
        return firstName + " " + lastName;
    }


}
