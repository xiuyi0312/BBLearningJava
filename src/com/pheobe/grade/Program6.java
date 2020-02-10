package com.pheobe.grade;

import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String semesterCountStr = scanner.nextLine();//读取学期数量
        int semesterCount = Integer.parseInt(semesterCountStr.split(" ")[0]);
        String classesCountStr = scanner.nextLine();// 读取课程数量
        int classesCount = Integer.parseInt(classesCountStr.split(" ")[0]);
        // 累积的总分
        float grade = 0;
        // 有效课程的总数，因为是随着学期变多，当前的课程总数需要变多，所以不能用--的方式
        int validClassCount = 0;
        boolean hasDropped = false;
        boolean probationMode = false;
        boolean dismissed = false;
        for (int i = 0; i < semesterCount; i++) {
            String semesterName = scanner.nextLine();
            int classesCountInCurrentSemester = Integer.parseInt(scanner.nextLine());
            // 当前学期的总分
            float gradeInCurrentSemester = 0;
            // 当前学期的有效课程数量
            int validClassCountInCurrentSemester = classesCountInCurrentSemester;
            for (int j = 0; j < classesCountInCurrentSemester; j++) {
                String classGrade = scanner.nextLine();
                String[] info = classGrade.split(",");
                String level = info[1];
                float g = getGradeWithLevel(level);
                if (g >= 0) {
                    gradeInCurrentSemester += g;
                } else {
                    validClassCountInCurrentSemester--;
                }
            }
            validClassCount += validClassCountInCurrentSemester;
            grade += gradeInCurrentSemester;

            float currentGpa = (float) (Math.round(gradeInCurrentSemester / validClassCountInCurrentSemester * 100.0) / 100.0);
            float currentCgpa = (float) (Math.round(grade / validClassCount * 100.0) / 100.0);

            if (dismissed) {
                continue;
            }

            System.out.println("SEMESTER: " + semesterName);
            System.out.println("GPA: " + currentGpa);
            System.out.println("CGPA: " + currentCgpa);

            if (probationMode && currentGpa < 2.0) {
                System.out.println("STATUS: DISMISSED");
                dismissed = true;
            } else {
                if (currentCgpa >= 2.0) {
                    System.out.println("STATUS: GOOD STANDING");
                    probationMode = false;
                } else {
                    if (!hasDropped || currentGpa >= 2.0) {
                        System.out.println("STATUS: PROBATION");
                        probationMode = true;
                        hasDropped = true;
                    } else {
                        System.out.println("STATUS: PROBATION");
                        probationMode = true;
                    }
                }
            }
        }
    }

    public static float getGradeWithLevel(String level) {
        switch (level) {
            case "A+":
                return 4.30F;
            case "A":
                return 4.00F;
            case "A-":
                return 3.70F;
            case "B+":
                return 3.30F;
            case "B":
                return 3.00F;
            case "B-":
                return 2.70F;
            case "C+":
                return 2.30F;
            case "C":
                return 2.00F;
            case "C-":
                return 1.70F;
            case "D":
                return 1.00F;
            case "F":
                return 0.00F;
            case "W":
            case "ILL":
                //-1用来表示这门课不算进去
                return -1;
            default:
                //实际上掉到这个else里面去，因为上面已经覆盖了所有的可能
                return 0.00F;
        }
    }
}
