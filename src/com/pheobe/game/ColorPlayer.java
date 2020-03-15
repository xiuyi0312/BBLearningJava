package com.pheobe.game;

public class ColorPlayer extends Player {
    public ColorPlayer(String name) {
        super(name);
    }

    @Override
    public Card findMatch(Card card) {
        for (int i = 0; i < cards.size() ; i++) {
            Card c = cards.get(i);
            if(c.matchesColor(card)) {
                return c;
            }
        }
        return super.findMatch(card);
    }
}
