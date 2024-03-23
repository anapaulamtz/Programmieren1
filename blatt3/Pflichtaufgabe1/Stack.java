public class Stack {
    // ein Stack besteht aus 4 Karten.
    Card[] cardStack = new Card[4]; 
    // die Methode, die die obersteKarte zurueckzugeben und sie aus dem Stapel zu entfernen.
    public Card playCard() {
        Card obersteCard = null;
        for ( int i = 3; i > -1; i--) {
            if (cardStack[i] != null) {
                obersteCard = cardStack[i];
                cardStack[i] = null;
                break;
            }             
        }
        return obersteCard;        
    }
    // die Methode, die oberste Karte zu zeigen.
    public void showCard() {
        Card obersteCard = null;
        for ( int i = 3; i > -1; i--) {
            if (cardStack[i] != null) {
                obersteCard = cardStack[i];
                break;
            }             
        }
        System.out.println(obersteCard); 
    }
    // die Methode, die Restkarten zu zaehlen.
    public int count() {
        int restKarten = 0;
        for ( int i = 3; i > -1; i--) {
            if ( cardStack[i] != null ) {
                restKarten = i+1;
                break;
            }
        }
        return restKarten;
    }
}

