package com.pheobe.stringusage;

import java.util.Scanner;

public class Program12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char first = input.charAt(0);
        char middle = input.charAt(input.length() / 2);
        char last = input.charAt(input.length() - 1);
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char a = input.charAt(i);
            boolean isVowel =
                    a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'
                    || a == 'A' || a == 'E' || a == 'I'
                            || a == 'O' || a == 'U';
            if (!isVowel) {
                count++;
            }
        }
        System.out.println(input.length());
        System.out.println(first + " " + middle + " " + last);
        System.out.println(count);
        return;
    }

    private static boolean isVowel1(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'
                || a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
    }

    private static boolean isVowel2(char a) {
        return "aeiou".contains(a + "") || "AEIOU".contains(a + "");
    }

    private static boolean isVowel3(char a) {
        return "aeiou".contains(
                (a+"").toLowerCase()
        );
    }

    private static int value(char a) {
        return 0;
    }
}
