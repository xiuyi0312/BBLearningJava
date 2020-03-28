package com.pheobe.listusage;

import java.util.ArrayList;
import java.util.Scanner;

public class NoDuplicatesDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> firstList = new ArrayList<>();

        String word;
        while (!(word = scanner.next()).equals("-1")) {
            firstList.add(word);
        }
        System.out.println(noDuplicates(firstList));
    }

    public static ArrayList<String> noDuplicates(ArrayList<String> list) {
        ArrayList<String> noDuplicatesList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String elem = list.get(i);
            boolean exist = false;

            for (int j = 0; j < noDuplicatesList.size(); j++) {
                String elem2 = noDuplicatesList.get(j);
                if (elem.equals(elem2)) {
                    // the 'elem' word has been added in noDuplicatesList
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                noDuplicatesList.add(elem);
            }
        }
        return noDuplicatesList;
    }
}
