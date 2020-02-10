package com.pheobe.level1;

import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int i, max, min;
        int length = in.nextInt();//这一句话会把3存入length
        int[] a = new int[length];// 数组的大小是length
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (i = 0; i < length; i++) {
            int input = in.nextInt();
            a[i] = input;
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        int round = max - min;
        System.out.println("Range: " + round);
    }
}
