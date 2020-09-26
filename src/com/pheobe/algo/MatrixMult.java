package com.pheobe.algo;

import java.util.Arrays;

public class MatrixMult {
    public static void main(String[] args) {
        int[][] matrixSizes = new int[][]{
                {3, 3},
                {20, 3},
                {100, 3},
                {200, 3},
                {300, 3},
                {400, 3},
                {500, 3},
                {600, 3},
                {700, 3},
                {800, 3},
                {900, 3},
                {1000, 3}
        };
        for (int[] s : matrixSizes) {
            long startTime = System.currentTimeMillis();
            calculate(s[0], s[1]);
            long endTime = System.currentTimeMillis();
            System.out.println("Size:" + s[0] + " " + "Time: " + (endTime - startTime) + " ms");
        }
    }

    public static void calculate(int size, int value) {
        int[][] a = new int[size][size];
        int[][] b = new int[size][size];
        int[][] c = new int[size][size];
        fill(a, value);
        fill(b, value);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // so calculate the value of Cij
                c[i][j] = 0;
                for (int k = 0; k < size; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }

    public static void fill(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            Arrays.fill(matrix[i], value);
        }
    }
}
