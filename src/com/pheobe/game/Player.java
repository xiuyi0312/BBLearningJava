package com.pheobe.game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * 拿牌
     * @param card
     */
    public void addCardToHand(Card card) {
        cards.add(card);
    }

    public void removeCardFromHand(Card card) {
        cards.remove(card);
    }

    public Card findMatch(Card card) {
        for (int i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            if(card.matches(c)) {
                return c;
            }
        }
        return null;
    }

    public boolean hasWon() {
        return cards.isEmpty();
    }

    @Override
    public String toString() {
        String str = name + " ";
        for (int i = 0; i < cards.size(); i++) {
            str += cards.get(i).toString() + " ";
        }
        return str.trim();
    }
}
