package com.pheobe.classusage;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        // read from scanner
        String name;
        while (!(name = scanner.nextLine()).equals("-1")) {
            double gpa = Double.parseDouble(scanner.nextLine());
            Student newStudent = new Student(name, gpa);
            add(studentList, newStudent);
        }
        scanner.nextLine();// for the last -1
        System.out.println(studentList);
        ArrayList<Student> sortedList = sortByGrade(studentList);
        System.out.println(sortedList);
    }

    public static void add(ArrayList<Student> list, Student student) {
        String name1 = student.getName();
        // Carl James Hans
        int i = 0;
        for (; i < list.size(); i++) {
            String name2 = list.get(i).getName();
            if (name1.compareTo(name2) < 0) {
                break;
            }
        }
        list.add(i, student);
    }

    public static ArrayList<Student> sortByGrade(ArrayList<Student> list) {
        ArrayList<Student> sortedByGradeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            double gpa1 = list.get(i).getGradePointAverage();
            String name1 = list.get(i).getName();
            int j = 0;
            for (; j < sortedByGradeList.size(); j++) {
                double gpa2 = sortedByGradeList.get(j).getGradePointAverage();
                String name2 = sortedByGradeList.get(j).getName();
                if(gpa1 < gpa2) {
                    break;
                } else if(gpa1 == gpa2) {
                    if (name1.compareTo(name2) < 0) {
                        break;
                    }
                }
            }
            sortedByGradeList.add(j, list.get(i));
        }
        return sortedByGradeList;
    }
}

/*
Bruce
4.0
Alex
3.8
Carl
3.8
Tom
3.5
**/

//Brace
//        3.5
//        Drake
//        3.7
//        Acer
//        3.6
//        Grant
//        4.0
//        Kent
//        3.8
//        Mate
//        3.9
//        -1
//        -1

//Kent
//        3.5
//        Drake
//        3.4
//        Grant
//        3.5
//        Mate
//        3.9
//        -1
//        -1