package com.pheobe.game;

/**
 * CSCI 1110
 *
 * @author ASiegel and YOU
 */

import java.util.Scanner;

public class PoD {


    /**
     * ====Method for you to complete====
     * Looks for a card (string) in a player's hand (string array). If found, it replaces it
     * with an "X" and returns "FOUND". If not, it returns "NOT FOUND".
     * @param cardToFind String card to look for, and if found replace with an "X"
     * @param cardsInHand String array of all cards (strings) in hand
     * @return String "NOT FOUND" if card is not found in hand, or "FOUND" if it is.
     */

    public static String findAndRemoveCard(String cardToFind, String[] cardsInHand) {

        // BEGIN WORK HERE
//        boolean found = false;
//        for (int i = 0; i < cardsInHand.length; i++) {
//            if (cardsInHand[i].equals(cardToFind)) {
//                // 这里不需要break，因为可能数组里存在多个cardToFind，要全部替换
//                cardsInHand[i] = "X";
//                found = true;
//            }
//        }
//        if (found) {
//            return "FOUND";
//        } else {
//            return "NOT FOUND";
//        }

        for (int i = 0; i < cardsInHand.length; i++) {
            if (cardsInHand[i].equals(cardToFind)) {
                cardsInHand[i] = "X";
                return "FOUND";
            }
        }
        return "NOT FOUND";
        //END WORK HERE
    }

    public static Scanner in;

    public static void main(String[] args) {
        //INPUT
        in = new Scanner(System.in);

        String[] cardsInHand = new String[Integer.parseInt(in.nextLine())];
        readInCards(cardsInHand);
        String cardToFind = in.next();

        outputCardsInHand("Starting ", cardsInHand);

        System.out.print("Looking for: " + cardToFind + "  ");
        System.out.println(findAndRemoveCard(cardToFind, cardsInHand));

        outputCardsInHand("New ", cardsInHand);

        in.close();
    }


    public static void outputCardsInHand(String descriptor, String[] cardsInHand) {
        System.out.print(descriptor + "Hand: ");
        int n = cardsInHand.length;
        for (int i = 0; i < n - 1; i++) {
            String card = cardsInHand[i];
            if (card.length() > 0) {
                System.out.print(cardsInHand[i] + " - ");
            }
        }
        System.out.println(cardsInHand[n - 1]);
    }

    public static void readInCards(String[] cardsInHand) {
        for (int i = 0; i < cardsInHand.length; i++) {
            String newCard = in.nextLine();
            cardsInHand[i] = newCard;
        }
    }

}