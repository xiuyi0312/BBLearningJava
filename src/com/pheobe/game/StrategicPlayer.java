package com.pheobe.game;

public class StrategicPlayer extends Player {
    public StrategicPlayer(String name) {
        super(name);
    }

    @Override
    public Card findMatch(Card card) {
        int matchedSameColorCount = 0;
        int matchedSameNumberCount = 0;
        Card firstSameNumberCard = null;// 记录第一次找到匹配的数字卡，防止多次for循环查找
        Card firstSameColorCard = null;// 记录第一次找到匹配的颜色卡，避免多次for循环查找
        for (int i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            if(c.matchesNumber(card)) {
                if(firstSameNumberCard == null) {
                    firstSameNumberCard = c;
                }
                matchedSameNumberCount ++;
            }
            if(c.matchesColor(card)) {
                if(firstSameColorCard == null) {
                    firstSameColorCard = c;
                }
                matchedSameColorCount ++;
            }
        }
        if(matchedSameNumberCount > matchedSameColorCount) {
            return firstSameNumberCard;
        } else {
            if(matchedSameColorCount == matchedSameNumberCount && matchedSameColorCount == 0) {// 没找到匹配的卡
                return null;
            } else {
                return firstSameColorCard;
            }
        }
    }
}
