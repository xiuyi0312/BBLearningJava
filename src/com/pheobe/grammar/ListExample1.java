package com.pheobe.grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(Arrays.toString(list.toArray()));
        list.add(4);
        list.add(5);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(4);
        System.out.println(Arrays.toString(list.toArray()));
        list.add(6);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
