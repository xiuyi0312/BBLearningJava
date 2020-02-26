package com.pheobe.grammar;

public class IncrementTest {
    public static void main(String[] args) {
        int i = 100;
        int j = i++;
        System.out.println("after j = i++; i = " + i + " j = " + j);

        i = 100;
        j = ++i;
        System.out.println("after j = ++i; i = " + i + " j = " + j);
    }
}
