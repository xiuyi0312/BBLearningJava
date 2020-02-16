package com.pheobe.objectusage;

public class Sailboat {
    private static int counter;

    private String boatName;
    private int dockSpace;

    public Sailboat(String boatName) {
        this.boatName = boatName;
        this.dockSpace = (++counter);
    }

    @Override
    public String toString() {
        return boatName + " is at dock space " + dockSpace;
    }
}
