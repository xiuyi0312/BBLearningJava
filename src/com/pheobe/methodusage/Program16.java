package com.pheobe.methodusage;

import java.util.Scanner;

public class Program16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] number = new int[count];
        for (int i = 0; i < count; i++) {
            number[i] = scanner.nextInt();
        }
        double result = findAverage(number);
        System.out.println(result);
    }

    public static double findAverage(int[] arr) {
        double result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result / arr.length;
    }
}
