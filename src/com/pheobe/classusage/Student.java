package com.pheobe.classusage;

public class Student {
    private String name;
    private double gradePointAverage;

    public Student(String name, double gradePointAverage) {
        this.name = name;
        this.gradePointAverage = gradePointAverage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGradePointAverage() {
        return gradePointAverage;
    }

    public void setGradePointAverage(double gradePointAverage) {
        this.gradePointAverage = gradePointAverage;
    }

    @Override
    public String toString() {
        return name + " GPA: " + gradePointAverage;
    }
}
