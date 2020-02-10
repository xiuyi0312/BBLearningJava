package com.pheobe.arrayusage;

import java.util.Scanner;

public class Program8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // save the word number in variable 'count'
        int count = scanner.nextInt();
        // save the input words in the array 'words' in reverse order
        String[] words = new String[count];
        for (int i = 0; i < count; i++) {
            String word = scanner.next();
            words[i] = word;
        }
        // print words as saved, be careful of the space
        boolean ok = true;
        for (int i = 0; i < words.length/2; i++) {
            //比如words[0]跟words[4]，words[1]跟words[3]比较
            if(!words[i].equals(words[words.length - 1 - i])) {
                // when find them unequal, break directly
                ok = false;
                break;
            }
        }
        if (ok) {
            System.out.println("The words are the same forward as backward.");
        } else {
            System.out.println("The words are NOT the same forward as backward.");
        }
    }
}
