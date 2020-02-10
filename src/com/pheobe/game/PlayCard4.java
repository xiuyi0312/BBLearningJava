package com.pheobe.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PlayCard4 {
    private static int indexForDrawingCard = 0;//表示当前玩家要加的牌
    private static String[] remainingCards;
    private static String currentDiscardedCard;
    private static int stepWhenPlayersPlayCard = -1;
    private static int stepWhenPlaysPlayLocoCard = -1;
    private static int step = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int playerCount = Integer.parseInt(scanner.nextLine());
        List<ArrayList<String>> playerCards = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            ArrayList<String> cardsForPlayer = new ArrayList<>();
            String[] inputForPlayer = scanner.nextLine().split(" ");
            cardsForPlayer.addAll(Arrays.asList(inputForPlayer));
            playerCards.add(cardsForPlayer);
        }

        currentDiscardedCard = scanner.nextLine();
        String currentLocoCard = "";
        remainingCards = scanner.nextLine().split(" ");
        System.out.println("0: " + currentDiscardedCard);
        boolean finished = false;
        while (!finished) {
            // 每一轮对每个玩家计算其应该出的牌
            for (int i = 0; i < playerCards.size() && !finished; i++) {
                step ++;
                List<String> cards = playerCards.get(i);
                List<String> copyCards = List.copyOf(cards);
//                System.out.println((i+1) + ": " + Arrays.toString(copyCards.toArray()));
                String colorForCurrentCard = currentDiscardedCard.substring(0, 1);
                String numberForCurrentCard = currentDiscardedCard.substring(1, 2);
                if (!currentLocoCard.equals("") && (stepWhenPlaysPlayLocoCard + 1 == step)) {// 出牌前要先判断上一个玩家是不是指定了颜色，当上一玩家除了?8并指定了颜色
                    List<String> locoCards = findLocoCard(cards);
                    if (locoCards.isEmpty()) {// 当前玩家没有LOCO卡
                        // 找上一玩家指定颜色的卡
                        List<String> matchedLocoCardWithSameColor = findCardsWithSameColor(currentLocoCard, cards);
                        if (matchedLocoCardWithSameColor.isEmpty()) {// 无牌可出
                            System.out.println((i + 1) + ": DRAW");
                            handleCardWhenNoCardToPlay(cards);
                        } else {
                            handleCardForSameColor(currentLocoCard, cards, i, matchedLocoCardWithSameColor);
                            if (cards.size() == 0) {
                                System.out.println(" (WINNER)");
                                finished = true;
                            } else {
                                System.out.println();
                            }
                        }
                    } else {// 当前玩家有LOCO卡
                        // 按照颜色顺序选出一张LOCO卡
                        handleCardForSameNumber("8", cards, i, locoCards);
                        if (cards.isEmpty()) {
                            System.out.println(" (WINNER)");
                            finished = true;
                        } else {// 指定下一玩家要出的颜色
                            currentLocoCard = findColorForNextPlayer(cards);
                            stepWhenPlaysPlayLocoCard = step;
                            System.out.println(" LOCO " + currentLocoCard);
                        }
                    }
                    continue;
                }
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
                        if (cards.isEmpty()) {
                            System.out.println(" (WINNER)");
                            finished = true;
                        } else {
                            System.out.println();
                        }
                    }
                    continue;
                }
                // 根据定义的三条规则判断当前玩家应该出的牌
                if (matchedCardForSameColor.isEmpty() && matchedCardForSameNumber.isEmpty()) {//无牌可出，得抓牌
                    System.out.println((i + 1) + ": DRAW");
                    handleCardWhenNoCardToPlay(cards);
                } else if (matchedCardForSameNumber.size() > matchedCardForSameColor.size()) {// 数字相同的牌>颜色相同的牌
                    // 从数字相同的牌里按照规定的颜色优先顺序寻找最合适的牌
                    handleCardForSameNumber(numberForCurrentCard, cards, i, matchedCardForSameNumber);
                    if (cards.isEmpty()) {
                        System.out.println(" (WINNER)");
                        finished = true;
                    } else {
                        // 出牌后要确定自己是不是LOCO
                        String chosenCard = findChosenCard(copyCards, cards);
                        if (chosenCard.endsWith("8")) {//出得是LOCO卡，那么还需要出一张颜色
                            currentLocoCard = findColorForNextPlayer(cards);
                            stepWhenPlaysPlayLocoCard = step;
                            System.out.println(" LOCO " + currentLocoCard);
                        } else {
                            System.out.println();
                        }
                    }
                } else {
                    handleCardForSameColor(colorForCurrentCard, cards, i, matchedCardForSameColor);
                    if (cards.size() == 0) {//当前玩家牌出完了，则他为WINNER
                        System.out.println(" (WINNER)");
                        finished = true;
                    } else {
                        // 出牌后要确定自己是不是LOCO
                        String chosenCard = findChosenCard(copyCards, cards);
                        if (chosenCard.endsWith("8")) {//出得是LOCO卡，那么还需要出一张颜色
                            currentLocoCard = findColorForNextPlayer(cards);
                            stepWhenPlaysPlayLocoCard = step;
                            System.out.println(" LOCO " + currentLocoCard);
                        } else {
                            System.out.println();
                        }
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

    private static List<String> findLocoCard(List<String> cards) {
        List<String> locoCards = new ArrayList<>();
        for (String card : cards) {
            if (card.endsWith("8")) {
                locoCards.add(card);
            }
        }
        return locoCards;
    }

    private static String findColorForNextPlayer(List<String> cards) {
        String[] sortedColor = new String[]{"R", "Y", "G", "B"};
        for (String color : sortedColor) {
            for (String card : cards) {
                if (card.startsWith(color)) {
                    return color;
                }
            }
        }
        return "";
    }

    public static String findChosenCard(List<String> originalCards, List<String> cards) {
        for (String card : originalCards) {
            if (!cards.contains(card)) {
                return card;
            }
        }
        return "";
    }

    /**
     * 当前玩家无牌可出时，从剩余的牌中取一张
     *
     * @param cards
     */
    private static void handleCardWhenNoCardToPlay(List<String> cards) {
        if(indexForDrawingCard >= remainingCards.length) {
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
        int[] targetCards = new int[]{
                8, 1, 2, 3, 4, 5, 6, 7
        };
        for (int i = 0; i < targetCards.length; i++) {
            String targetCard = colorForCurrentCard + (targetCards[i]);
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
