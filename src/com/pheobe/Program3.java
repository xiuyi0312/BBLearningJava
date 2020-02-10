package com.pheobe;

import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String semesterName = scanner.nextLine();
        int courseCount = Integer.parseInt(scanner.nextLine());
        int validCourseCount = courseCount;
        float totalValue = 0;
        for (int i = 0; i < courseCount; i++) {
            String grade = scanner.nextLine();
            String[] info = grade.split(",");
            String level = info[1];
            float value = getGrade(level);
            if(value >= 0) {
                totalValue += value;
            } else {
                validCourseCount --;
            }
        }
        System.out.println("SEMESTER: " + semesterName);
        System.out.println("GPA: " + Math.round(totalValue/validCourseCount * 100.0) / 100.0);
    }

    private static float getGrade(String level) {
        if ("A+".equals(level)) {
            return 4.30F;
        } else if ("A".equals(level)) {
            return 4.00F;
        } else if ("A-".equals(level)) {
            return 3.70F;
        } else if ("B+".equals(level)) {
            return 3.30F;
        } else if ("B".equals(level)) {
            return 3.00F;
        } else if ("B-".equals(level)) {
            return 2.70F;
        } else if ("C+".equals(level)) {
            return 2.30F;
        } else if ("C".equals(level)) {
            return 2.00F;
        } else if ("C-".equals(level)) {
            return 1.70F;
        } else if ("D".equals(level)) {
            return 1.00F;
        } else if ("F".equals(level)) {
            return 0.00F;
        } else if ("W".equals(level) || "ILL".equals(level)) {
            return -1;
        }
        return 0.00F;
    }
}
