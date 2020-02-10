package com.pheobe.methodusage;

import java.util.Arrays;
import java.util.Scanner;

public class Program11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        calculateMinimumMark(scores, x);
    }

    public static void calculateMinimumMark(int[] scores, int x) {
        Arrays.sort(scores);
//        System.out.println(Arrays.toString(scores));
        int position = scores.length - scores.length * x / 100;
        if (position >= scores.length) {
            position--;
        }
        System.out.println(scores[position]);
    }
}
