package com.pheobe.objectusage;

public class FastFood extends Restaurant {

    private String slogan;

    public FastFood(int seats, String name, String slogan) {
        super(seats, name);
        this.slogan = slogan;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public void increaseSeats(int seat) {
        setSeats(getSeats() + seat);
    }

    @Override
    public String toString() {
        return name + " - \"" + slogan + "\"\n" + getSeats() + " seats";
    }
}
