package com.pheobe.level1;

public class Test {
    public static void main(String[] args) {
        System.out.println(recurrAverage(recurrAverage(16)));
    }

    public static int recurrAverage(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        return sum/num;
    }
}
