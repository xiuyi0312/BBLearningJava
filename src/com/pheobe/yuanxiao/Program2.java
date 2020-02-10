package com.pheobe.yuanxiao;

import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String info = scanner.nextLine();
        String[] result = stringToStringArray(info);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }

    public static String[] stringToStringArray(String str) {
        String[] strArray = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strArray[i] = str.substring(i, i + 1);
        }
        return strArray;
    }

    public static String[] stringToStringArray2(String str) {
        String[] strArray = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            strArray[i] = str.charAt(i) + "";
        }
        return strArray;
    }
}
