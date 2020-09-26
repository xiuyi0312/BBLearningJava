package com.pheobe.oousage;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Circle {
    private double xpos;
    private double ypos;
    private double radius;

    public Circle(double xpos, double ypos, double radius) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.radius = radius;
    }

    public double getX() {
        return xpos;
    }

    public double getY() {
        return ypos;
    }

    public double getRadius() {
        return radius;
    }

    public void setCenter(double xpos, double ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }

    public double getCircumference() {
        return 2 * 3.14 * radius;
    }

    private double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x2) + (y2 - y1) * (y2 - y1));
    }

    public boolean contains(double x, double y) {
        double distance = getDistance(xpos, ypos, x, y);
        return distance < radius;
    }

    public boolean touches(double x, double y) {
        double distance = Math.sqrt((x - xpos) * (x - xpos) + (y - ypos) * (y - ypos));
        return distance == radius;
    }

    public boolean contains(Circle c) {
        if (xpos == c.getX() && ypos == c.getY() && radius == c.getRadius()) {
            return false;
        }
        double centerDistance = getDistance(xpos, ypos, c.getX(), c.getY());
        return centerDistance < radius - c.getRadius();
    }

    public boolean touches(Circle c) {
        // 1. touches outside
        // 2. touches inside
        double centerDistance = getDistance(xpos, ypos, c.getX(), c.getY());
        return radius - c.getRadius() == centerDistance ||
                radius + c.getRadius() == centerDistance;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNumber = scanner.nextInt();
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        for (int i = 0; i < testNumber; i++) {
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double radius1 = scanner.nextDouble();
            Circle c1 = new Circle(x1, y1, radius1);
            System.out.println("The first Circle's centre is: " + c1.getX() + ", " + c1.getY());
            System.out.println("It's radius is: " + c1.getRadius());
            System.out.println("It's area is: " + decimalFormat.format(c1.getArea()));
            System.out.println("It's circumference is: " + decimalFormat.format(c1.getCircumference()));
            System.out.println();


            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double radius2 = scanner.nextDouble();
            Circle c2 = new Circle(x2, y2, radius2);
            System.out.println("The second Circle's centre is: " + c2.getX() + ", " + c2.getY());
            System.out.println("It's radius is: " + c2.getRadius());
            System.out.println("It's area is: " + decimalFormat.format(c2.getArea()));
            System.out.println("It's circumference is: " + decimalFormat.format(c2.getCircumference()));
            System.out.println();

            System.out.println("The 'contains' method returns: " + c1.contains(c2));
            System.out.println("The 'touches' method returns: " + c1.touches(c2));
            System.out.println();
            System.out.println();
        }
    }
}
