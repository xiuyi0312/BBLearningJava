package com.pheobe.game;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayCard1 {
    private static int indexForDrawingCard = 0;//表示当前玩家要加的牌
    private static String[] remainingCards;
    private static String currentDiscardedCard;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ArrayList<String>> playerCards = new ArrayList<>();
        // 玩家1的初始牌
        ArrayList<String> cardsForPlayer1 = new ArrayList<>();
        String[] inputForPlayer1 = scanner.nextLine().split(" ");
        cardsForPlayer1.addAll(Arrays.asList(inputForPlayer1));
        // 玩家2的初始牌
        ArrayList<String> cardsForPlayer2 = new ArrayList<>();
        String[] inputForPlayer2 = scanner.nextLine().split(" ");
        cardsForPlayer2.addAll(Arrays.asList(inputForPlayer2));
        // 玩家3的初始牌
        ArrayList<String> cardsForPlayer3 = new ArrayList<>();
        String[] inputForPlayer3 = scanner.nextLine().split(" ");
        cardsForPlayer3.addAll(Arrays.asList(inputForPlayer3));

        playerCards.add(cardsForPlayer1);
        playerCards.add(cardsForPlayer2);
        playerCards.add(cardsForPlayer3);

        currentDiscardedCard = scanner.nextLine();
        remainingCards = scanner.nextLine().split(" ");
        System.out.println("0: " + currentDiscardedCard);
        boolean finished = false;
        while (!finished) {
            // 每一轮对每个玩家计算其应该出的牌
            for (int i = 0; i < playerCards.size() && !finished; i++) {
                List<String> cards = playerCards.get(i);
                String colorForCurrentCard = currentDiscardedCard.substring(0, 1);
                String numberForCurrentCard = currentDiscardedCard.substring(1, 2);
                List<String> matchedCardForSameNumber = findCardsWithSameNumber(numberForCurrentCard, cards);
                List<String> matchedCardForSameColor = findCardsWithSameColor(colorForCurrentCard, cards);
                // 根据定义的三条规则判断当前玩家应该出的牌
                if (matchedCardForSameColor.size() == 0 && matchedCardForSameNumber.size() == 0) {//无牌可出，得抓牌
                    System.out.println((i + 1) + ": DRAW");
                    handleCardWhenNoCardToPlay(cards);
                } else if (matchedCardForSameNumber.size() > matchedCardForSameColor.size()) {// 数字相同的牌>颜色相同的牌
                    handleCardForSameNumber(numberForCurrentCard, cards, i, matchedCardForSameNumber);
                    if (cards.size() == 0) {
                        System.out.println(" (WINNER)");
                        finished = true;
                    } else {
                        System.out.println();
                    }
                } else {
                    handleCardForSameColor(colorForCurrentCard, cards, i, matchedCardForSameColor);
                    if (cards.size() == 0) {
                        System.out.println(" (WINNER)");
                        finished = true;
                    } else {
                        System.out.println();
                    }
                }
            }
        }
    }

    private static List<String> findCardsWithSameNumber(String numberForCurrentCard, List<String> cards) {
        List<String> matchedCardForSameNumber = new ArrayList<>();
        for (String card : cards) {
            // 这里注意要用if if不能用if elseif
            if (card.endsWith(numberForCurrentCard)) {
                matchedCardForSameNumber.add(card);
            }
        }
        return matchedCardForSameNumber;
    }

    private static List<String> findCardsWithSameColor(String colorForCurrentCard, List<String> cards) {
        List<String> matchedCardForSameColor = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            String card = cards.get(i);
            // 这里注意要用if if不能用if elseif
            if (card.startsWith(colorForCurrentCard)) {
                matchedCardForSameColor.add(card);
            }
        }
        return matchedCardForSameColor;
    }

    /**
     * 当前玩家无牌可出时，从剩余的牌中取一张
     *
     * @param cards 当前玩家手里的牌
     */
    private static void handleCardWhenNoCardToPlay(List<String> cards) {
        if (indexForDrawingCard >= remainingCards.length) {
            return;
        }
        cards.add(remainingCards[indexForDrawingCard++]);
    }

    /**
     * 对于相同数字的牌，按照要求的顺序计算需要打出的牌
     *
     * @param numberForCurrentCard 当前牌的数字
     * @param cards 当前玩家的所有牌
     * @param indexForCurrentPlayer 当前玩家的下标
     * @param matchedCardForSameNumber 当前玩家手中号码与numberForCurrentCard相同的所有牌
     */
    private static void handleCardForSameNumber(String numberForCurrentCard, List<String> cards, int indexForCurrentPlayer,
                                         List<String> matchedCardForSameNumber) {
        // 从数字相同的牌里按照规定的颜色优先顺序寻找最合适的牌
        String[] targetCards = new String[]{
                "R" + numberForCurrentCard,
                "Y" + numberForCurrentCard,
                "G" + numberForCurrentCard,
                "B" + numberForCurrentCard
        };
        for (int i = 0; i < targetCards.length; i++) {
            if(matchedCardForSameNumber.contains(targetCards[i])) {
                System.out.print((indexForCurrentPlayer + 1) + ": " + targetCards[i]);
                cards.remove(targetCards[i]);
                currentDiscardedCard = targetCards[i];
                return;
            }
        }
    }

    /**
     * 对于相同颜色的牌，按照要求的顺序计算需要打出的牌
     *
     * @param colorForCurrentCard 当前牌的颜色
     * @param cards 当前玩家的所有牌
     * @param indexForCurrentPlayer 当前玩家的下标
     * @param matchedCardForSameColor 当前玩家手中颜色与colorForCurrentCard相同的所有牌
     */
    private static void handleCardForSameColor(String colorForCurrentCard, List<String> cards, int indexForCurrentPlayer,
                                                List<String> matchedCardForSameColor) {
        for (int i = 0; i < 8; i++) {
            String targetCard = colorForCurrentCard + (i+1);
            if(matchedCardForSameColor.contains(targetCard)) {
                System.out.print((indexForCurrentPlayer + 1) + ": " + targetCard);
                cards.remove(targetCard);
                currentDiscardedCard = targetCard;
                break;
            }
        }
    }
}
