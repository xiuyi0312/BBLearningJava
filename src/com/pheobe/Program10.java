package com.pheobe;

import java.util.Scanner;

public class Program10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();// 读取N
        String[] groceries = new String[count];
        for (int i = 0; i < count; i++) {
            String g = scanner.next();// 读取N个菜
            groceries[i] = g;
        }
        while (true) {
            String boughtGrocery = scanner.next();
            if (boughtGrocery.equals("DONE")) {
                break;
            }
            for (int i = 0; i < count; i++) {
                // 找到已经买到了的那种菜，那么将这个菜置为空
                if (boughtGrocery.equals(groceries[i])) {
                    groceries[i] = "";
                }
            }
        }

        for (int i = 0; i < count; i++) {
            // 没有置为空的菜都是还没买的菜，输出
            if (groceries[i] != null) {
                System.out.println(groceries[i]);
            }
        }
    }
}
