package com.pheobe.yuanxiao;

import java.util.Scanner;

public class Program7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        char target = scanner.next().charAt(0);
        char[][] array = new char[r][c];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.next().charAt(0);
            }
        }
        printArray(array);
        findLetter(array, target);
    }

    public static void printArray(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void findLetter(char[][] array, char t) {
        boolean found = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == t) {
                    found = true;
                    System.out.print(i + "," + j + " ");
                }
            }
        }
        if (found) {
            System.out.println();
        } else {
            System.out.println("-1,-1");
        }
    }
}
