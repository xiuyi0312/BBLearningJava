package com.pheobe.objectusage;

public class Restaurant {
    private int seats;
    protected String name;

    public Restaurant(int seats, String name) {
        this.seats = seats;
        this.name = name;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return name + '\n' + seats + " seats";
    }
}
