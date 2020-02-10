package com.pheobe.arrayusage;

import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int[][] array = new int[r][c];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
        printArray(array);
        System.out.println(cornerSame(array));
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean cornerSame(int[][] arr) {
        int w = arr[0].length;
        int h = arr.length;
        int leftTop = arr[0][0];
        int rightTop = arr[0][arr[0].length-1];
        int leftBottom = arr[arr.length -1][0];
        int rightBottom = arr[arr.length-1][arr[arr.length-1].length -1];
        return rightTop == leftTop && leftBottom == leftTop && rightTop == rightBottom;
    }
}
