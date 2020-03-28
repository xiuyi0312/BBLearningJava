package com.pheobe.listusage;

import java.util.ArrayList;
import java.util.Scanner;

public class SharesDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> firstList = new ArrayList<>();
        ArrayList<String> secondList = new ArrayList<>();

        String word;
        while (!(word = scanner.next()).equals("-1")) {
            firstList.add(word);
        }
        while (!(word = scanner.next()).equals("-1")) {
            secondList.add(word);
        }
        ArrayList<String> thirdList = shares(firstList, secondList);
        System.out.println(thirdList.toString());
    }

    public static ArrayList<String> shares(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> list3 = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            String elem = list1.get(i);
            boolean exist = false;

            for (int j = 0; j < list2.size(); j++) {
                String elem2 = list2.get(j);
                if (elem.equals(elem2)) {
                    // the 'elem' word is also in list2
                    exist = true;
                    break;
                }
            }

            if (exist) {
                boolean hasAdded = false;
                for (int j = 0; j < list3.size(); j++) {
                    String elem3 = list3.get(j);
                    if (elem.equals(elem3)) {
                        // the 'elem' has been added in list3
                        hasAdded = true;
                        break;
                    }
                }
                if (!hasAdded) {
                    list3.add(elem);
                }
            }
        }
        return list3;
    }
}
