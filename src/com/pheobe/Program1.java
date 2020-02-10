package com.pheobe;

import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = 0;
        /*
        while(true) {
            int number = scanner.nextInt();
            if(number < 0) {
                break;
            }
            if(number > max) {
                max = number;
            }
        }
        */
        int number = scanner.nextInt();
        while(number >= 0) {
            if(number > max) {
                max = number;
            }
            number = scanner.nextInt();
        }
        if (max > 0) {//针对输入的第一个数字就是负数，那么不会输出max
            System.out.println(max);
        }
    }
}
