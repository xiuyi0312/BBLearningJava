package com.pheobe.oousage;

public class Rectangle1 {
    private int xpos, ypos, width, height;

    public Rectangle1() {

    }

    public Rectangle1(int xpos, int ypos, int width, int height) {
        this.xpos = xpos;
        this.ypos = ypos;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return xpos;
    }

    public void setX(int xpos) {
        this.xpos = xpos;
    }

    public int getY() {
        return ypos;
    }

    public void setY(int ypos) {
        this.ypos = ypos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
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

    @Override
    public String toString() {
        return "[xpos= " + xpos + "," + "ypos= " + ypos + "] width: " + width + ",height: " + height;
    }

    public boolean contains(int px, int py) {
        return px >= xpos && px <= xpos + width &&
                py >= ypos && py <= ypos + height;
    }

    public boolean contains(Rectangle1 r) {
        return contains(r.getX(), r.getY()) &&
                contains(r.getX() + r.getWidth(), r.getY() + r.getHeight());
    }

    public static void main(String[] args) {
        Rectangle1 rect1 = new Rectangle1(10, 20, 300, 400);
        Rectangle1 rect2 = new Rectangle1(15, 25, 100, 100);
        System.out.println("Point(30, 40) is contained in " + rect1 + "?\t" + rect1.contains(30, 40));
        System.out.println("Point(10, 20) is contained in " + rect1 + "?\t" + rect1.contains(10, 20));
        System.out.println("Point(4, 3) is contained in " + rect1 + "?\t" + rect1.contains(4, 3));
        System.out.println("Rectangle" + rect2 + " is contained in " + rect1 + "?\t" + rect1.contains(rect2));
        System.out.println("Rectangle" + rect1 + " is contained in " + rect2 + "?\t" + rect2.contains(rect1));
    }
}
