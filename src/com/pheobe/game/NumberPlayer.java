package com.pheobe.game;

public class NumberPlayer extends Player {
    public NumberPlayer(String name) {
        super(name);
    }

    @Override
    public Card findMatch(Card card) {
        for (int i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            if(c.matchesNumber(card)) {
                return c;
            }
        }
        return super.findMatch(card);
    }
}
