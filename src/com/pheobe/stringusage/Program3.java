package com.pheobe.stringusage;

import java.util.Scanner;

public class Program3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String[] words = new String[length];
        for (int i = 0; i < length; i++) {
            words[i] = scanner.next();
        }
        String result = longestWord(words);
        System.out.println(result);
    }

    public static String longestWord(String[] words) {
        int index = -1;
        int max = -1;
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > max) {
                max = words[i].length();
                index = i;
            }
        }
        return words[index];
    }
}
