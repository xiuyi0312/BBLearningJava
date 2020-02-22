package com.pheobe.objectusage;

public class Student {
    private int studentID;
    private String firstName;
    private String preferredName;
    private String lastName;

    public Student(int ID, String firstName, String lastName) {
        this.studentID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.preferredName = firstName;//Preferred name is initially set to be the same as their first name.
    }

    public int getStudentID() {
        return studentID;
    }

    public void setPreferredName(String preferredName) {
        this.preferredName = preferredName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return preferredName + " " + lastName;
    }

    @Override
    public String toString() {
        return getName() + " (" + studentID + ")";
    }
}
