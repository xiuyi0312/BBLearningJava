package com.pheobe.objectusage;

import java.util.Arrays;

public class Course {
    private int courseID;
    private String courseCode;
    private String courseName;
    private int courseCapacity;
    private int numberStudents;
    private Room room;
    private Student[] students;
    private int waitListCount;

    public Course(int courseID, String courseCode, String courseName, Room room) {
        this.courseID = courseID;
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.room = room;
        this.numberStudents = 0;
        this.waitListCount = 0;
        this.courseCapacity = room.getRoomCapacity();
        this.students = new Student[room.getRoomCapacity()];
    }

    public String getBuildingName() {
        return room.getBuilding().getBuildingName();
    }

    public String getCampus() {
        return room.getBuilding().getCampus();
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public int getNumberStudents() {
        return numberStudents;
    }

    public Student[] getStudents() {
        return Arrays.copyOfRange(students, 0, numberStudents);
    }

    public boolean isInCourseAlready(Student student) {
        for (int i = 0; i < numberStudents; i++) {
            if(student.getStudentID() == students[i].getStudentID()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSpaceLeftInCourse() {
        return numberStudents < courseCapacity;
    }

    public int registerStudent(Student student) {
        if(isInCourseAlready(student)) {
            return -1;
        }
        if(!isSpaceLeftInCourse()) {
            waitListCount ++;
            return -1;
        }
        students[numberStudents] = student;
        numberStudents ++;
        return 0;
    }

    @Override
    public String toString() {
        return "COURSE " + courseID + ": \n"
                + courseCode + "-" + courseName + "\n"
                + room.toString() + "\n"
                + "Current: " + numberStudents + "/" + courseCapacity + "\n"
                + "Wait list count: " + waitListCount;
    }
}
