package com.pheobe.objectusage;

import java.util.Scanner;

public class FastFoodDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FastFood fastFood = new FastFood(
                Integer.parseInt(scanner.nextLine()), // first line input for the original seats
                scanner.nextLine(), // second line input for the name
                scanner.nextLine() // third line input for the slogan
        );
        // fourth line input for the increment of seats;
        fastFood.increaseSeats(Integer.parseInt(scanner.nextLine()));
        System.out.println(fastFood.toString());
    }
}
