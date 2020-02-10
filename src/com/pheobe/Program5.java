package com.pheobe;

import java.util.*;

/**
 * 第三题： TAKE TWO
 */
public class Program5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String semesterCountStr = scanner.nextLine();//读取学期数量
        int semesterCount = Integer.parseInt(semesterCountStr.split(" ")[0]);
        String classesCountStr = scanner.nextLine();// 读取课程数量
        int classesCount = Integer.parseInt(classesCountStr.split(" ")[0]);
        List<Map<String, Float>> allGrades = new ArrayList<>();
        List<String> gpaList = new ArrayList<>();
        List<String> semesterNameList = new ArrayList<>();
        for (int i = 0; i < semesterCount; i++) {
            String semesterName = scanner.nextLine();
            int classesCountInCurrentSemester = Integer.parseInt(scanner.nextLine());
            // 当前学期的总分
            float gradeInCurrentSemester = 0;
            // 当前学期的有效课程数量
            int validClassCountInCurrentSemester = classesCountInCurrentSemester;
            Map<String, Float> gradeMapInCurrentSemester = new HashMap<>();
            for (int j = 0; j < classesCountInCurrentSemester; j++) {
                String classGrade = scanner.nextLine();
                String[] info = classGrade.split(",");
                String level = info[1];
                String className = info[0];
                float g = getGradeWithLevel(level);
                if (g >= 0) {
                    gradeInCurrentSemester += g;
                    gradeMapInCurrentSemester.put(className, g);
                    // 变更以往的相关成绩
                    for (int k = 0; k < i; k++) {
                        Map<String, Float> previousGrade = allGrades.get(k);
                        for (Map.Entry<String, Float> entry : previousGrade.entrySet()) {
                            if (entry.getKey().equals(className)) {
                                entry.setValue(-1F);
                            }
                        }
                    }
                } else {
                    validClassCountInCurrentSemester--;
                }
            }
            semesterNameList.add("SEMESTER: " + semesterName);
            gpaList.add("GPA: " + Math.round(gradeInCurrentSemester / validClassCountInCurrentSemester * 100.0) / 100.0);
            allGrades.add(gradeMapInCurrentSemester);
        }

        for (int i = 0; i < allGrades.size(); i++) {
            int count = 0;
            float totalValue = 0F;
            for (int j = 0; j <= i; j++) {
                Map<String, Float> gradeMapInCurrentSemester = allGrades.get(j);
                count += gradeMapInCurrentSemester.size();
                for (Map.Entry<String, Float> elem : gradeMapInCurrentSemester.entrySet()) {
                    if (elem.getValue() < 0) {
                        count--;
                    } else {
                        totalValue += elem.getValue();
                    }
                }
            }
            System.out.println(semesterNameList.get(i));
            System.out.println(gpaList.get(i));
            System.out.println("CGPA: " + Math.round(totalValue / count * 100.0) / 100.0);
        }
    }

    public static float getGradeWithLevel(String level) {
        if ("A+".equals(level)) {
            return 4.30F;
        }
        if ("A".equals(level)) {
            return 4.00F;
        }
        if ("A-".equals(level)) {
            return 3.70F;
        }
        if ("B+".equals(level)) {
            return 3.30F;
        }
        if ("B".equals(level)) {
            return 3.00F;
        }
        if ("B-".equals(level)) {
            return 2.70F;
        }
        if ("C+".equals(level)) {
            return 2.30F;
        }
        if ("C".equals(level)) {
            return 2.00F;
        }
        if ("C-".equals(level)) {
            return 1.70F;
        }
        if ("D".equals(level)) {
            return 1.00F;
        }
        if ("F".equals(level)) {
            return 0.00F;
        }
        if ("W".equals(level) || "ILL".equals(level)) {
            //-1用来表示这门课不算进去
            return -1;
        }
        //实际上掉到这个else里面去，因为上面已经覆盖了所有的可能
        return 0.00F;
    }
}
