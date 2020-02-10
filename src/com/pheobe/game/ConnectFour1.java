package com.pheobe.game;

import java.util.Scanner;

public class ConnectFour1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        int count = scanner.nextInt();
        int[] moves = new int[count];
        for (int i = 0; i < moves.length; i++) {
            moves[i] = scanner.nextInt();
        }
        connectBoard(width, height, moves);
    }

    public static void connectBoard(int width, int height, int[] moves) {
        String[][] board = new String[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = " ";
            }
        }
        for (int i = 0; i < moves.length; i++) {
            int column = moves[i];
            // 从下往上找第一个没填入棋子的，找到后填入，并break
            for (int j = height - 1; j >= 0; j--) {
                if (board[j][column - 1].equals(" ")) {
                    board[j][column - 1] = "*";
                    break;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
