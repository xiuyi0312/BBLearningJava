package com.pheobe.game;

import java.util.Scanner;

public class Program17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

    }

    public static boolean validateBoard(String[][] gameBoard) {
        int countOfX = 0;
        int countOfO = 0;
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                String str = gameBoard[i][j];
                if(str.equals("x")) {
                    countOfX ++;
                } else if(str.equals("o")) {
                    countOfO ++;
                }
            }

        }
        return countOfO == countOfX || countOfX - countOfO == 1;
    }
}
