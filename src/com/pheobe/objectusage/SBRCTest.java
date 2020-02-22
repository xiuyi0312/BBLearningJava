package com.pheobe.objectusage;

/**
 * the test class for the Student, Building Room, Course classes
 */
public class SBRCTest {
    public static void main(String[] args) {
        Student phoebe = new Student(1001, "Phoebe", "Wang");
        Student yanfei = new Student(1002, "Yanfei", "Wang");

        System.out.println(phoebe);
        System.out.println(yanfei);

        Building building = new Building("A", 5, "Dal");
        System.out.println(building);

        Room roomForCS = new Room(building, 101, 52);
        System.out.println(roomForCS);

        Course cs = new Course(1010, "CS1010", "Computer Science", roomForCS);
        System.out.println(cs);
        cs.registerStudent(phoebe);
        System.out.println(cs);
        cs.registerStudent(yanfei);
        System.out.println(cs);
    }
}
