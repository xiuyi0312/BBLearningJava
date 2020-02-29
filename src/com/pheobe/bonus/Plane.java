package com.pheobe.bonus;

import java.util.Arrays;

public class Plane {
    private String airline;
    private String type;
    private int seats;
    private Passenger[] passengers;
    private int currPass;

    public Plane() {

    }

    public Plane(String airline, String type, int seats) {
        this.airline = airline;
        this.type = type;
        this.seats = seats;
        this.passengers = new Passenger[seats];
        this.currPass = 0;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean moreSeats(Plane plane) {
        return seats > plane.seats;
    }

    public boolean sameAirline(Plane plane) {
        return airline.equals(plane.airline);
    }

    public Passenger[] getAllPassengers() {
        return Arrays.copyOf(passengers, currPass);
    }

    public void addPassenger(Passenger newPassenger) {
        if (currPass < seats) {
            passengers[currPass++] = newPassenger;
        }
    }

    public double totalRevenue() {
        double revenue = 0;
        for (int i = 0; i < currPass; i++) {
            revenue += passengers[i].getPrice();
        }
        return revenue;
    }

    @Override
    public String toString() {
        String str = "Airline: " + airline + " Plane: " + type + " Number of Seats: " + seats + "\n";
        str += "Revenue: $" + totalRevenue() + "\n";
        str += "Passengers:\n";
        Passenger[] addedPassengers = getAllPassengers();
        for (int i = 0; i < addedPassengers.length; i++) {
            str += addedPassengers[i].toString() + "\n";
        }
        return str;
    }
}
