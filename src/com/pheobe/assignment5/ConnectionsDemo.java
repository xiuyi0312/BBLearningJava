package com.pheobe.assignment5;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectionsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // input 1: the number of students
        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        CovidConnect covidConnect = new CovidConnect();
        // input 2: the N students
        for (int i = 0; i < numberOfStudents; i++) {
            String line = scanner.nextLine();
            String[] info = line.split(",");
            Student newStudent = new Student(info[0], info[3], info[2], info[4], Integer.parseInt(info[1]));
            boolean addSuccess = covidConnect.addStudent(newStudent);
            if (addSuccess) {
                System.out.println("ADDED: " + newStudent.toString());
            } else {
                System.out.println("NOT ADDED: " + newStudent.getName() + "(" + newStudent.getStudentID() + ")");
            }
        }
        System.out.println();

        // input 3: the number of contact pairs
        int numberOfContactPairs = Integer.parseInt(scanner.nextLine());
        // input 4: the N student pairs
        for (int i = 0; i < numberOfContactPairs; i++) {
            String line = scanner.nextLine();
            String[] ids = line.split(" ");
            Student firstStudent = null;
            Student secondStudent = null;
            for (int j = 0; j < covidConnect.getDalStudents().size(); j++) {
                if (covidConnect.getDalStudents().get(j).getStudentID().equals(ids[0])) {
                    // find the student with the first input id
                    firstStudent = covidConnect.getDalStudents().get(j);
                }
                if (covidConnect.getDalStudents().get(j).getStudentID().equals(ids[1])) {
                    // find the student with the second input id
                    secondStudent = covidConnect.getDalStudents().get(j);
                }
            }

            if (firstStudent != null && secondStudent != null) {
                System.out.println("NEW CONTACT PAIR:");
                System.out.println(firstStudent);
                System.out.println(secondStudent);
                firstStudent.addContact(secondStudent);
                System.out.println("COMMON CONTACTS:");
                ArrayList<Student> commonStudents = covidConnect.commonContacts(firstStudent, secondStudent);
                for (int j = 0; j < commonStudents.size(); j++) {
                    System.out.println(commonStudents.get(j));
                }
                System.out.println();
            }
        }

        // input 5: the student id to be removed
        String idToRemove = scanner.nextLine();
        Student studentToRemove = null;
        for (int j = 0; j < covidConnect.getDalStudents().size(); j++) {
            if (covidConnect.getDalStudents().get(j).getStudentID().equals(idToRemove)) {
                // find the student with the first input id
                studentToRemove = covidConnect.getDalStudents().get(j);
            }
        }
        if (studentToRemove != null) {
            System.out.println("REMOVING:");
            covidConnect.removeStudent(studentToRemove);
            System.out.println(studentToRemove);
            System.out.println();
        }

        System.out.println("NUMBER DAL STUDENTS: " + covidConnect.getDalStudents().size());
        System.out.println();
        System.out.println("ALL DAL STUDENTS:");
        for (int i = 0; i < covidConnect.getDalStudents().size(); i++) {
            System.out.println(covidConnect.getDalStudents().get(i));
        }
        System.out.println();

        // input 6: the program to calculate the number of students
        String program = scanner.nextLine();
        int numberOfStudentFromProgram = covidConnect.numberStudentsFromProgram(program);
        System.out.println("NUMBER STUDENTS FROM " + program + ": " + numberOfStudentFromProgram);
        System.out.println();

        int mostContacts = covidConnect.mostContacts();
        System.out.println("MOST CONTACTS OF ANY STUDENT: " + mostContacts);
    }
}
