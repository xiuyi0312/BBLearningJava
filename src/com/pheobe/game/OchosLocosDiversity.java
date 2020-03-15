package com.pheobe.game;

import java.util.Scanner;

public class OchosLocosDiversity {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        int P = Integer.parseInt(scanner.nextLine());
        // P players
        for (int i = 0; i < P; i++) {
            String line = scanner.nextLine();
            String[] strs = line.split(" ");

            Player player = null;
            if(strs[1].equals("C")) {
                player = new ColorPlayer(strs[0]);
            } else if(strs[1].equals("N")) {
                player = new NumberPlayer(strs[0]);
            } else if (strs[1].equals("S")) {
                player = new StrategicPlayer(strs[0]);
            } else {
                player = new Player(strs[0]);
            }
            player.addCardToHand(new Card(strs[2]));
            player.addCardToHand(new Card(strs[3]));
            player.addCardToHand(new Card(strs[4]));
            player.addCardToHand(new Card(strs[5]));
            player.addCardToHand(new Card(strs[6]));
            game.addPlayer(player);
        }

        // the discard card
        String discardCard = scanner.nextLine();
        game.setDiscardCard(new Card(discardCard));

        int remainingCardCount = 32 - P * 5 - 1;
        for (int i = 0; i < remainingCardCount; i++) {
            String input = scanner.next();
            game.addCard(new Card(input));
        }

        while (true) {
            Card currentCard = game.nextPlay();
            if (currentCard == null) {// draw
                System.out.println(game.getCurrentPlayer().toString() + ": " + "DRAW");
            } else {
                System.out.println(game.getCurrentPlayer().toString() + ": " + currentCard.toString());
            }
            if (game.getCurrentPlayer().hasWon()) {
                System.out.println(game.getCurrentPlayer().getName() + " is the winner!");
                break;
            }
            if (game.outOfCards()) {
                System.out.println("That was fun!");
                break;
            }
        }
    }

}
/* Example Input 2
4
Alice C Y3 Y7 Y8 B1 B7
Bob N R8 Y1 G4 G8 B8
Carol S R3 R4 R7 Y6 B5
Dave B R2 G5 B6 Y5 G3
B3
G2 Y4 R1 G1 Y2 G6 B4 R5 G7 R6 B2
 */
