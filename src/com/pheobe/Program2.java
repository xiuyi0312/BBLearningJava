package com.pheobe;

import java.util.Arrays;
import java.util.Random;

public class Program2 {
    public static void main(String[] args) {

        Random random = new Random();
        // 生成随机数组
        int[] list1 = new int[10];
        for(int i = 0; i< 10;i++) {
            list1[i] = random.nextInt() % 100;
        }
        System.out.println(Arrays.toString(list1));
        // 寻找最大值
        int maxValue = list1[0];
        for(int i = 1; i< 10;i++) {
            if(list1[i] > maxValue) {
                maxValue = list1[i];
            }
        }
        System.out.println("max = " + maxValue);
        // 计算平均值
        int totalValue = 0;
        for(int i = 0; i< 10;i++) {
            totalValue += list1[i];
        }
        int avgValue = totalValue/10;
        System.out.println("avg = " + avgValue);
        // 满足条件的值变为最大值
        for(int i = 0; i< 10;i++) {
            if(list1[i] < 0 && list1[i] < avgValue) {
                list1[i] = maxValue;
            }
        }
        System.out.println(Arrays.toString(list1));




//        int[] listR = new int[10];
//
//
//        System.out.println(Arrays.toString(list1));
//
//        for(int i = 0; i< 10;i++) {
//            listR[9 - i] = list1[i];
//        }
//        System.out.println(Arrays.toString(listR));



    }
}
