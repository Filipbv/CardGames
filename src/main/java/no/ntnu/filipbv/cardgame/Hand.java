package no.ntnu.filipbv.cardgame;

/**
 * Klassen som holder på korttene den er delt.
 *
 */
public class Hand {

    private String[] hand;
    private int index;

    /**
     * constructor som starter array
     *
     */
    Hand(int n) {
        hand = new String[n];
        index = 0;
    }

    /**
     * metoden som legger til kort til hånden.
     *
     */
    public void add(String card) {
        hand[index] = card;
        index++;
    }

    /**
     * metoden som sjekker om hånden inneholder et kort
     *
     */
    public boolean contains(String card) {
        for(int i = 0; i < hand.length; i++) {
            if(hand[i] != null && hand[i].equals(card)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metode som regner sammen summen av kortene i hånden.
     *
     */
    public int calculateSum() {
        int sum = 0;
        for(int i = 0; i < hand.length; i++) {
            sum += Integer.parseInt(hand[i].substring(1, hand[i].length()));
        }
        return sum;
    }

    /**
     * metoden som sjekker om spar damene er i hånden.
     *
     */
    public boolean hasQueenOfSpades() {
        for(int i = 0; i < hand.length; i++) {
            if(hand[i].equals("S12")) {
                return true;
            }
        }
        return false;
    }


    /**
     * metoden som sjekker om det er en flush i hånden.
     *
     */
    public boolean fiveFlush() {
        char suit = hand[0].charAt(1);
        for(int i = 0; i < hand.length; i++) {
            if(suit != hand[i].charAt(0)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Metoden som finner alle hjerter i hånden.
     *
     */
    public String getHearts() {
        String s = "";
        for(int i = 0; i < hand.length; i++) {
            if(hand[i].charAt(0) == 'H') {
                s += hand[i] + " ";
            }
        }
        if(!s.contains("H")) {
            s = "No Hearts";
        }
        return s;
    }
    /**
     * metode som gir deg størelsen av hånden
     *
     */
    public int size() {
        return hand.length;
    }

    /**
     * metoden returnener alle kort i hånden i form av en string.
     *
     */
    @Override
    public String toString() {
        String h = "";
        for(int i = 0; i < hand.length; i++) {
            h += hand[i] + " ";
        }
        return h;
    }
}
