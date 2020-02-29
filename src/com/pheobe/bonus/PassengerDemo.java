package com.pheobe.bonus;

import java.util.Scanner;

public class PassengerDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Passenger wangInFlight = new Passenger(scanner.nextLine(), Double.parseDouble(scanner.nextLine()));
        System.out.println(wangInFlight.toString());
    }
}
