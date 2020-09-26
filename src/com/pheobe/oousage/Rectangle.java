package com.pheobe.oousage;

import java.util.Scanner;

public class Rectangle {
    private double xpos, ypos, width, height;

    public Rectangle() {

    }

    public Rectangle(double xpos, double ypos, double width, double height) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    public double getX() {
        return xpos;
    }

    public void setX(int xpos) {
        this.xpos = xpos;
    }

    public double getY() {
        return ypos;
    }

    public void setY(int ypos) {
        this.ypos = ypos;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void moveTo(int xpos, int ypos) {
        this.xpos = xpos;
        this.ypos = ypos;
    }

    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean contains(double px, double py) {
        return xpos <= px && px <= xpos + width &&
                ypos <= py && py <= ypos + height;
    }

    public boolean touches(double px, double py) {
        return ((px == xpos || px == xpos + width) && ypos <= py && py <= ypos + height) ||// left or right side
                ((ypos == py || py == ypos + height) && (xpos <= px && px <= xpos + width));// top or bottom side
    }

    public boolean contains(Rectangle r) {
        if (xpos == r.getX() && ypos == r.getY() && width == r.getWidth() && height == r.getHeight()) {
            return false;
        }
        return this.contains(r.getX(), r.getY()) &&
                this.contains(r.getX() + r.getWidth(), r.getY() + r.getHeight());
    }

    /**
     * 1. touches outside
     * 2. touches inside
     * @param r
     * @return
     */
    public boolean touches(Rectangle r) {
        if(xpos == r.getX() && ypos == r.getY() && width == r.getWidth() && height == r.getHeight()) {
            return false;
        }
        // 1. touches outside on the top or bottom side
        boolean touchOutsideTopOrBottom = (r.getY() + r.getHeight() == ypos
                || ypos + height == r.getY()) &&
                (betweenX(r.getX()) || betweenX(r.getX() + r.getWidth()));
        // 2. touches outside on the left or right side
        boolean touchOutsideLeftOrRight = (xpos + width == r.getX() || r.getX() + r.getWidth() == xpos) &&
                (betweenY(r.getY()) || betweenY(r.getY() + r.getHeight()));
        // 3. touches inside on the left or right side
        boolean touchInsideTopOrBottom = (ypos == r.getY() || ypos + height == r.getY() + r.getHeight()) &&
                (xpos <= r.getX() && r.getX() + r.getWidth() <= xpos + width);
        // 4. touches inside on the top or bottom side
        boolean touchInsideLeftOrRight = (xpos == r.getX() || xpos + width == r.getX() + r.getWidth()) &&
                (ypos <= r.getY() && r.getY()+ r.getHeight() <= ypos + height);

        return touchInsideLeftOrRight || touchInsideTopOrBottom ||
                touchOutsideLeftOrRight || touchOutsideTopOrBottom;
    }

    private boolean betweenX(double x2) {
        return xpos <= x2 && x2 <= xpos + width;
    }

    private boolean betweenY(double y2) {
        return ypos <= y2 && y2 <= ypos + height;
    }

    @Override
    public String toString() {
        return "[xpos= " + xpos + "," + "ypos= " + ypos + "] width: " + width + ",height: " + height;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testNumber = scanner.nextInt();
        for (int i = 0; i < testNumber; i++) {
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double width1 = scanner.nextDouble();
            double height1 = scanner.nextDouble();
            System.out.println("The first Rectangle's top corner is: " + x1 + ", " + y1);
            System.out.println("It's width is: " + width1);
            System.out.println("It's height is: " + height1);
            System.out.println();
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double width2 = scanner.nextDouble();
            double height2 = scanner.nextDouble();

            System.out.println("The second Rectangle's top corner is: " + x2 + ", " + y2);
            System.out.println("It's width is: " + width2);
            System.out.println("It's height is: " + height2);
            System.out.println();

            Rectangle rect1 = new Rectangle(x1, y1, width1, height1);
            Rectangle rect2 = new Rectangle(x2, y2, width2, height2);

            System.out.println("The contains method returns: " + rect1.contains(rect2));
            System.out.println("The touches method returns: " + rect1.touches(rect2));
            System.out.println();
            System.out.println();
        }
    }
}
