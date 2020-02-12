package com.pheobe.objectusage;

import java.util.Scanner;

public class PersonTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        String line2 = scanner.nextLine();

        Person person1 = new Person(line1, line2);// construct person1
        Person person2 = new Person(line1, line2);// construct person2

        System.out.println(person1.toString());
        System.out.println(person2.toString());
    }
}
