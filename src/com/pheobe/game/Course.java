package com.pheobe.game;


/*
 * CSCI 1110
 * @author ASiegel and YOU
 *
 */
public class Course {

    //attributes
    private int courseReferenceNumber;
    private int creditHours;
    private String courseName;
    private String instructor;

    // PLEASE START YOUR CODE HERE
    // ===========================

    public Course(int courseReferenceNumber, int creditHours, String courseName, String instructor) {
        this.courseReferenceNumber = courseReferenceNumber;
        this.creditHours = creditHours;
        this.courseName = courseName;
        this.instructor = instructor;
    }

    public int getCourseReferenceNumber() {
        return courseReferenceNumber;
    }

    public void setCourseReferenceNumber(int courseReferenceNumber) {
        this.courseReferenceNumber = courseReferenceNumber;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    // ===========================
    // PLEASE END YOUR CODE HERE

    @Override
    public String toString() {
        return "Course{" +
                "courseReferenceNumber=" + courseReferenceNumber +
                ", creditHours=" + creditHours +
                ", courseName='" + courseName + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}
