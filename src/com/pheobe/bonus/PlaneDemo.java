package com.pheobe.bonus;

import java.util.Scanner;

public class PlaneDemo {
    public static void main(String[] args) {
        // codes below are to print two planes
//        Scanner scanner = new Scanner(System.in);
//        Plane plane1 = new Plane();
//        plane1.setAirline(scanner.nextLine());
//        plane1.setType(scanner.nextLine());
//        plane1.setSeats(Integer.parseInt(scanner.nextLine()));
//
//        Plane plane2 = new Plane();
//        plane2.setAirline(scanner.nextLine());
//        plane2.setType(scanner.nextLine());
//        plane2.setSeats(Integer.parseInt(scanner.nextLine()));
//
//        System.out.println(plane1.toString());
//        System.out.println(plane2.toString());
//        System.out.println();
//        System.out.println("plane1 has more seats than plane2 is " + plane1.moreSeats(plane2));
//        System.out.println("plane1 is the same airline as plane2 is " + plane1.sameAirline(plane2));


        // codes below is to print a plane with 4 passengers
        Scanner scanner = new Scanner(System.in);
        Plane plane = new Plane(scanner.nextLine(), scanner.nextLine(), Integer.parseInt(scanner.nextLine()));
        for (int i = 0; i < 4; i++) {
            String name = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine());
            plane.addPassenger(new Passenger(name, price));
        }
        System.out.print(plane.toString());
    }
}
