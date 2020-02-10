package com.pheobe.forusage;

public class Program9 {
    public static void main(String[] args) {
        int count = 15;
        for (int i = 1; i <= count; i += 2) {
            for (int j = 0; j < i; j++) {
                System.out.print("💗");
            }
            System.out.println();
        }
        for (int i = 1; i < count; i += 2) {
            for (int j = 1; j < count - i; j++) {
                System.out.print("💗");
            }
            System.out.println();
        }
        System.out.println();
    }
}
