package no.ntnu.filipbv.cardgame;

import java.util.Random;

/**
 * Klasse som holder 52 kort
 *
 */

public class DeckOfCards {
    //class attributes
    private String[] deck;
    private String[] suit;

    /**
     * Constructor metoden som setter opp arrays og lager kortstokken.
     *
     */

    DeckOfCards() {
        this.suit = new String[]{"Hearts", "Diamonds", "Clubs", "Spades"};
        deck = new String[52];
        int idx = 0;
        for(int i = 0; i < suit.length; i++) {
            char c = suit[i].charAt(0);
            for(int j = 0; j < 13; j++) {
                deck[idx] = c + "" + (j + 1);
                idx++;
            }
        }
    }

    /**
     * Metode for å dele ut en hånd.
     * Trekker tilfeldige kort og putter de i hånden
     *
     */

    public Hand dealHand(int n) {
        Hand hand = new Hand(n);
        for(int i = 0; i < n; i++) {
            int random = new Random().nextInt(52);
            String card = deck[random];
            if(!hand.contains(card)) {
                hand.add(card);
            }
            else {
                i--;
            }
        }
        return hand;
    }
}
