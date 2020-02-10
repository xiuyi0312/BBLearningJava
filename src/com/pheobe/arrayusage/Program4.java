package com.pheobe.arrayusage;

import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthA = scanner.nextInt();
        double[] arrayA = new double[lengthA];
        for (int i = 0; i < lengthA; i++) {
            arrayA[i] = scanner.nextDouble();
        }
        int lengthB = scanner.nextInt();
        double[] arrayB = new double[lengthB];
        for (int i = 0; i < lengthB; i++) {
            arrayB[i] = scanner.nextDouble();
        }
        printArray(arrayA);
        printArray(arrayB);
        printArray(sumArrays(arrayA, arrayB));
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static double[] sumArrays(double[] arrayA, double[] arrayB) {
        int lengthC = Math.max(arrayA.length, arrayB.length);
        double[] arrayC = new double[lengthC];
        for (int i = 0; i < lengthC; i++) {
            double sum = 0;
            if (i < arrayA.length) {//未越界则添加
                sum += arrayA[i];
            }
            if (i < arrayB.length) {//未越界则添加
                sum += arrayB[i];
            }
            arrayC[i] = sum;
        }
        return arrayC;
    }
}
