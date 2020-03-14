package com.pheobe.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();
    private List<Card> cardsInDeck = new ArrayList<>();
    private Card discardCard;
    private int currentPlayerIndex = -1;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addCard(Card card) {
        cardsInDeck.add(card);
    }

    public void setDiscardCard(Card card) {
        discardCard = card;
    }

    public Card getDiscardCard() {
        return discardCard;
    }

    public Card drawCard() {
        return cardsInDeck.remove(0);
    }

    public Player getCurrentPlayer() {
        if(currentPlayerIndex == -1) {
            return null;
        }
        return players.get(currentPlayerIndex);
    }

    public Player nextPlayer() {
        // 0 -> 1, 1 -> 2, 2 -> 3, 3 -> 0, 0 -> 1....
        currentPlayerIndex = currentPlayerIndex + 1;
        currentPlayerIndex = currentPlayerIndex % players.size();
        return players.get(currentPlayerIndex);
    }

    public Card nextPlay() {
        Player player = nextPlayer();
        Card matchedCard = player.findMatch(discardCard);
        if(matchedCard == null) {
            Card newCard = drawCard();
            player.addCardToHand(newCard);
            return null;
        } else {
            player.removeCardFromHand(matchedCard);
            discardCard = matchedCard;
            return discardCard;
        }
    }

    public boolean outOfCards() {
        return cardsInDeck.isEmpty();
    }
}
