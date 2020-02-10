package com.pheobe;

import java.util.Scanner;

public class SwitchExample1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        switch (number % 3) {
            case 0:
                System.out.println("可以整除");
                break;
            default:
                System.out.println("不可以整除");
                break;
        }
    }
}
