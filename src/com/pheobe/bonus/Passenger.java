package com.pheobe.bonus;

import java.text.DecimalFormat;

public class Passenger {
    private String name;
    private double price;

    public Passenger() {

    }

    public Passenger(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getPassenger() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Price: $" + new DecimalFormat("#.00").format(price);
    }
}
