package com.pheobe.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayCard2 {
    private static int indexForDrawingCard = 0;//表示当前玩家要加的牌
    private static String[] remainingCards;
    private static String currentDiscardedCard;
    private static int stepWhenPlayersPlayCard = -1;//当前出来了的的步骤
    private static int step = -1;// 总的步骤

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ArrayList<String>> playerCards = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<String> cardsForPlayer = new ArrayList<>();
            String[] inputForPlayer = scanner.nextLine().split(" ");
            cardsForPlayer.addAll(Arrays.asList(inputForPlayer));
            playerCards.add(cardsForPlayer);
        }

        currentDiscardedCard = scanner.nextLine();
        remainingCards = scanner.nextLine().split(" ");
        System.out.println("0: " + currentDiscardedCard);
        boolean finished = false;
        while (!finished) {
            // 每一轮对每个玩家计算其应该出的牌
            for (int i = 0; i < playerCards.size() && !finished; i++) {
                step++;
                List<String> cards = playerCards.get(i);
                String colorForCurrentCard = currentDiscardedCard.substring(0, 1);
                String numberForCurrentCard = currentDiscardedCard.substring(1, 2);
                List<String> matchedCardForSameNumber = findCardsWithSameNumber(numberForCurrentCard, cards);
                List<String> matchedCardForSameColor = findCardsWithSameColor(colorForCurrentCard, cards);
                if (numberForCurrentCard.equals("2") && stepWhenPlayersPlayCard != -1 &&
                        (stepWhenPlayersPlayCard + 1) == step) {
                    //如果当前的牌是2并且之前的牌是上一个玩家出的，那么当前玩家必须按照2的规则出牌
                    if (matchedCardForSameNumber.size() == 0) {// 当前玩家没有2，那么需要抽两张牌
                        System.out.println((i + 1) + ": TAKE TWO");
                        handleCardWhenNoCardToPlay(cards);
                        handleCardWhenNoCardToPlay(cards);
                    } else {
                        handleCardForSameNumber(numberForCurrentCard, cards, i, matchedCardForSameNumber);
                        if (cards.size() == 0) {
                            System.out.println(" (WINNER)");
                            finished = true;
                        } else {
                            System.out.println();
                        }
                    }
                    continue;
                }
                // 根据定义的三条规则判断当前玩家应该出的牌
                if (matchedCardForSameColor.size() == 0 && matchedCardForSameNumber.size() == 0) {//无牌可出，得抓拍
                    System.out.println((i + 1) + ": DRAW");
                    handleCardWhenNoCardToPlay(cards);
                } else if (matchedCardForSameNumber.size() > matchedCardForSameColor.size()) {// 数字相同的牌>颜色相同的牌
                    // 从数字相同的牌里按照规定的颜色优先顺序寻找最合适的牌
                    handleCardForSameNumber(numberForCurrentCard, cards, i, matchedCardForSameNumber);
                    if (cards.size() == 0) {
                        System.out.println(" (WINNER)");
                        finished = true;
                    } else {
                        System.out.println();
                    }
                } else {
                    handleCardForSameColor(colorForCurrentCard, cards, i, matchedCardForSameColor);
                    if (cards.size() == 0) {//当前玩家牌出完了，则他为WINNER
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
            if (card.endsWith(numberForCurrentCard)) {
                matchedCardForSameNumber.add(card);
            }
        }
        return matchedCardForSameNumber;
    }

    private static List<String> findCardsWithSameColor(String colorForCurrentCard, List<String> cards) {
        List<String> matchedCardForSameColor = new ArrayList<>();
        for (String card : cards) {
            if (card.startsWith(colorForCurrentCard)) {
                matchedCardForSameColor.add(card);
            }
        }
        return matchedCardForSameColor;
    }

    /**
     * 当前玩家无牌可出时，从剩余的牌中取一张
     *
     * @param cards
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
     * @param numberForCurrentCard     当前牌的数字
     * @param cards                    当前玩家的所有牌
     * @param indexForCurrentPlayer    当前玩家的下标
     * @param matchedCardForSameNumber 当前玩家手中号码与numberForCurrentCard相同的所有牌
     */
    private static void handleCardForSameNumber(String numberForCurrentCard, List<String> cards, int indexForCurrentPlayer,
                                                List<String> matchedCardForSameNumber) {
        // 从数字相同的牌里按照规定的颜色优先顺序寻找最合适的牌
        // 从数字相同的牌里按照规定的颜色优先顺序寻找最合适的牌
        String[] targetCards = new String[]{
                "R" + numberForCurrentCard,
                "Y" + numberForCurrentCard,
                "G" + numberForCurrentCard,
                "B" + numberForCurrentCard
        };
        for (int i = 0; i < targetCards.length; i++) {
            if (matchedCardForSameNumber.contains(targetCards[i])) {
                System.out.print((indexForCurrentPlayer + 1) + ": " + targetCards[i]);
                stepWhenPlayersPlayCard = step;
                cards.remove(targetCards[i]);
                currentDiscardedCard = targetCards[i];
                return;
            }
        }
    }

    /**
     * 对于相同颜色的牌，按照要求的顺序计算需要打出的牌
     *
     * @param colorForCurrentCard     当前牌的颜色
     * @param cards                   当前玩家的所有牌
     * @param indexForCurrentPlayer   当前玩家的下标
     * @param matchedCardForSameColor 当前玩家手中颜色与colorForCurrentCard相同的所有牌
     */
    private static void handleCardForSameColor(String colorForCurrentCard, List<String> cards, int indexForCurrentPlayer,
                                               List<String> matchedCardForSameColor) {

        for (int i = 0; i < 8; i++) {
            String targetCard = colorForCurrentCard + (i + 1);
            if (matchedCardForSameColor.contains(targetCard)) {
                System.out.print((indexForCurrentPlayer + 1) + ": " + targetCard);
                stepWhenPlayersPlayCard = step;
                cards.remove(targetCard);
                currentDiscardedCard = targetCard;
                break;
            }
        }
    }
}
