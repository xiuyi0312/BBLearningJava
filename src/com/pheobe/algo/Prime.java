package com.pheobe.algo;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        int value = -1;
        Scanner scanner = new Scanner(System.in);
        while ((value = scanner.nextInt()) != 0) {
            long startTime = System.currentTimeMillis();
            long result = nthPrime(value);
            long endTime = System.currentTimeMillis();
            System.out.println(value + " " + result + " " + (endTime - startTime));
        }
    }

    public static long nthPrime(long p) {
        int count = 0;
        int startNumber = 1;
        while (count < p) {
            startNumber++;
            if (isPrime2(startNumber)) {
                count++;
            }
        }
        return startNumber;
    }

    /**
     * 11 31 0
     * 101 547 1
     * 1001 7927 30
     * 10001 104743 3656
     * <p>
     * 最粗暴也是效率最低的方法，从素数的定义实现代码
     *
     * @param number 被判断的数字
     * @return true:是素数；false不是素数
     */
    public static boolean isPrime(long number) {
        if (number < 2)
            return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                // find a num can divide this number, so it's not a prime
                return false;
            }
        }
        return true;
    }

    /**
     * 11 31 0
     * 101 547 0
     * 1001 7927 17
     * 10001 104743 1972
     * 100001 1299721 234835
     * <p>
     * 因为最小的因子是2，所以一个数N的另一个因子不可能超过N/2，所以可以把
     * 循环的终结条件缩小到<=N/2
     * 但是这种线性的方式非常低效
     *
     * @param number
     * @return
     */
    private static boolean isPrime1(long number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                // find a num can divide this number, so it's not a prime
                return false;
            }
        }
        return true;
    }

    /**
     * 11 31 0
     * 101 547 0
     * 1001 7927 2
     * 10001 104743 27
     * 100001 1299721 809
     * 1000001 15485867 25071
     * <p>
     * 因为如果N能被2~N-1之间任意整数整除，如果一个因子A>=sqrt(N)，那A必定对应另一个因子B<=sqrt(N)，
     * 所以只要找到sqrt(N)就终止
     *
     * @param number
     * @return
     */
    private static boolean isPrime2(long number) {
        if (number < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                // find a num can divide this number, so it's not a prime
                return false;
            }
        }
        return true;
    }
}
