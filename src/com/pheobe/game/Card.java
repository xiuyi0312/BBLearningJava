package com.pheobe.game;

public class Card {
    private String card;

    public Card(String card) {
        this.card = card;
    }

    public char getColor() {
        return card.charAt(0);
    }

    public char getNumber() {
        return card.charAt(1);
    }

    public boolean matches(Card other) {
        return other.getColor() == this.getColor() ||
                other.getNumber() == this.getNumber();
    }

    public boolean matchesColor(Card other) {
        return other.getColor() == this.getColor();
    }

    public boolean matchesNumber(Card other) {
        return other.getNumber() == getNumber();
    }

    @Override
    public String toString() {
        return card;
    }
}
