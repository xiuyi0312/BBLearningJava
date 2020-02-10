package com.pheobe.stringusage;

import java.util.Scanner;

public class Program15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordA = scanner.next();
        String wordB = scanner.next();
        String res = commonLetters(wordA, wordB);
        System.out.println(res);
    }

    public static String commonLetters(String wordA, String wordB) {
        //tolowercase返回小写字母，比如HaliFax会变成halifax
        wordA = wordA.toLowerCase();
        wordB = wordB.toLowerCase();
        String result = "";
        for (int i = 0; i < wordA.length(); i++) {
            char c = wordA.charAt(i);
            if (wordB.indexOf(c) != -1) {
                if (result.indexOf(c) == -1) {
                    result = result + c;
                }
            }
        }
        return result;
    }
}
