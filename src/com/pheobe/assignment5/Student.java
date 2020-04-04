package com.pheobe.assignment5;

import java.util.ArrayList;

public class Student {
    private String name;
    private int birthYear;
    private String email;
    private String program;
    private String studentID;
    private ArrayList<Student> contacts;

    public Student(String name, String email, String program, String studentID, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.email = email;
        this.program = program;
        this.studentID = studentID;
        contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getEmail() {
        return email;
    }

    public String getProgram() {
        return program;
    }

    public String getStudentID() {
        return studentID;
    }

    public ArrayList<Student> getContacts() {
        return contacts;
    }

    public int getNumberContacts() {
        return contacts.size();
    }

    public boolean equals(Student other) {
        return studentID.equals(other.getStudentID());
    }

    public boolean addContact(Student other) {
        boolean exist = false;
        for (int i = 0; i < contacts.size(); i++) {
            if(other.equals(contacts.get(i))) {
                exist = true;
                break;
            }
        }
        if(exist) {
            return false;
        } else {
            // other is this student's contact and likewise
            contacts.add(other);
            // this student is also other's contact
            other.addContact(this);
            return true;
        }
    }

    public boolean removeContact(Student other) {
        boolean exist = false;
        for (int i = 0; i < contacts.size(); i++) {
            if(other.equals(contacts.get(i))) {
                exist = true;
                break;
            }
        }
        if (exist) {
            // remove other from this student
            contacts.remove(other);
            // and remove this student from the other student as well
            other.removeContact(this);
            return true;
        } else {
            return false;
        }
    }

    public int oldestContact() {
        int index = 0;
        for (int i = 1; i < contacts.size(); i++) {
            if(contacts.get(i).getBirthYear() < contacts.get(index).getBirthYear()) {
                index = i;
            }
        }
        return contacts.get(index).getBirthYear();
    }

    public void printAllContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(contacts.get(i).toString());
        }
    }

    public String toString() {
        return studentID + " " + name;
    }
}
