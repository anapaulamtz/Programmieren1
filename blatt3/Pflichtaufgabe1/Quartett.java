import java.util.Random;

public class Quartett {
    // zwei Objekte der Klasse Player fuer zwei Spieler erstellen.
    Stack stapelcomputer = new Stack();
    Stack stapelplayer = new Stack();
    Player computer = new Player("Bot", 0, stapelcomputer); 
    Player player = new Player("Player", 0, stapelplayer);
    // 8 Karten erstellen
    public Card[] cardGenerator() {  
        Card[] cardArray = new Card[8];
        cardArray[0] = new Card("Grogu", "REBEL", 1.67, 4, 5, 9);
        cardArray[1] = new Card("Max", "REBEL", 1.61, 9, 2, 7);
        cardArray[2] = new Card("Tim", "REBEL", 1.55, 6, 6, 6);
        cardArray[3] = new Card("Mac", "REBEL", 1.58, 5, 9, 5);
        cardArray[4] = new Card("Trox", "IMPERIUM", 1.52, 10, 3, 4);
        cardArray[5] = new Card("Stephen", "IMPERIUM", 1.63, 3, 4, 3);
        cardArray[6] = new Card("Marco", "IMPERIUM", 1.53, 7, 1, 8);
        cardArray[7] = new Card("John", "IMPERIUM", 1.62, 2, 7, 1);
        return cardArray;
    }
    // 8 Karten mischen
    public Card[] ShuffleOfCards() {
        Card[] deckOfCard = cardGenerator();
        Random random = new Random();
        int j;
        for ( int i = 0; i < deckOfCard.length; i++ ) {
            j = random.nextInt(8);
            Card temp = deckOfCard[i];
            deckOfCard[i] = deckOfCard[j];
            deckOfCard[j] = temp;
        }
        return deckOfCard;
    }
    // 8 gemischte Karten werden an zwei Spieler ausgeteilt.
    public void DealCards(Player computer, Player player) {
        Card[] shuffleCard = ShuffleOfCards();
        for (int i = 0; i < 4; i++) {     
            computer.getKartenstapel().cardStack[i] = shuffleCard[i];      
        }
        for (int i = 0; i < 4; i++) {
            player.getKartenstapel().cardStack[i] = shuffleCard[7-i];
        }   
        /*for (Card card : player.getKartenstapel().cardStack) {
            System.out.println("Karten vom Spieler: "+ card);
        }  
        for (Card card : computer.getKartenstapel().cardStack) {
            System.out.println("Karten vom Computer: "+ card);
        }  */  
    } 
    // die Spielregel zeigen
    public void spielRegel() {
        System.out.println("Sie haben jetzt 4 Karte als ein Kartenstapel. Nur die oberstekarte dürfen Sie kennen.");
        System.out.println("Wählen Sie bitte jetzt eine Kategorie: getHeight(), getIntelligence(), getStrength(), getJedipower().");
        System.out.println("Es werden deine oberstekarten und die von deinem Gegner in dieser Kategorie überprüft.");
        System.out.println("Wählen Sie bitte jetzt eine Kategorie: getHeight(), getIntelligence(), getStrength(), getJedipower().");
        System.out.println("Der Spieler mit dem höchsten Wert in dieser Kategorie gewinnt die Runde und erhält einen Punkt.");
        System.out.println("Jeder anschließende Spielrunde wird vom vorherigen Sieger begonnen.");
        System.out.println("Das Spiel endet, sobald alle Karten gespielt wurden.");
        System.out.println("Am Ende des Spiels gewinnt der Spieler, der mehr Punkte kriegt. So los geht's");
    }
    // die Methode wird aufgerufen, wenn der Spieler die Kategorie in einer Runde auswaehlt.
    public void spielerchoose() {
        System.out.println("Du bist dran. Ihre oberste Karte ist: ");
        player.showCard();
    }
    // die Indices der ausgewaehlte Kategorie des Spielers und des Computers vergleichen
    public boolean compareto(int kategorie, Player playercompare, Player playertocompare, boolean x) {
        boolean a = false;
        switch (kategorie) {
            case 1:
                if (playercompare.playCard().getHeight() > playertocompare.playCard().getHeight() ) {
                    a = true;
                }
                break;
            case 2:
                if (playercompare.playCard().getIntelligence() > playertocompare.playCard().getIntelligence() ) {
                    a = true;
                }
                break;
            case 3:
                if (playercompare.playCard().getStrength() > playertocompare.playCard().getStrength() ) {
                    a = true;
                }
                break;
            case 4:
                if (playercompare.playCard().getJedipower() > playertocompare.playCard().getJedipower() ) {
                    a = true;
                }
                break;
            default:
                break;
        }
        return a;
    }

    public static void main(String[] args) {
        Quartett run = new Quartett();
        // erstmal die Karten mischen und an die Spieler und den Computer austeilen
        run.DealCards(run.computer, run.player);
        // den Regel anleiten
        run.spielRegel();
        // In erster Runde waehlt der Spieler die Kategorie.
        run.spielerchoose();
        boolean x = true; 
        int kategorieofplayer = run.player.spielerchoosedKategorie(); // Spieler waehlt die Kategorie
        System.out.println("die Karte Ihres Gegners ist ");
        run.computer.showCard(); // die oberste Karte des Computers zeigen
        // Fang an, die Karten vom Spieler und dem Computer zu vergleichen.
        boolean resultofRound = run.compareto(kategorieofplayer, run.player, run.computer, x);      
        while ( run.player.countCards() != 0) {
            // der Fall, in dem der Computer in einer Runde gewinnt.
            if (resultofRound == false) {
                run.computer.addPoint(); // den Punktestand vom Computer um ein erhoehen
                System.out.println("Sie sind in dieser Runde leider verloren.");
                // den Punktestand vom Spieler zeigen
                System.out.println("Ihre aktuelle Punkrunand ist:" + run.player.getPoints());
                // der Computer waehlt die Kategorie.
                int kategorieofcomputer = run.computer.computerchoosedKategorie();
                System.out.println("Ihr Gegner wählt die Kategorienummer: "+ kategorieofcomputer);
                // die Karten vom Spielr und Computer zeigen
                System.out.println("Ihre nächste Karte und die nächste Karte Ihres Gegners sind:");
                run.player.showCard();
                run.computer.showCard();
                // weiter die ausgewaehlte Kategorie der obersten Karte vom Spieler und Computer vergleichen
                resultofRound = !run.compareto(kategorieofcomputer, run.computer, run.player, x); 
            // der Fall, in dem der Spieler in einer Runde gewinnt.
            } else {
                System.out.println( "Sie sind in dieser Runde gewonnen." );
                // den Punktestand vom Spieler um ein erhoehen
                run.player.addPoint(); 
                // den Punktestand vom Spieler zeigen
                System.out.println("Ihre aktuelle Punkrunand ist:" + run.player.getPoints());
                // Sag den Spieler, eine Kategorie auszuwaehlen
                run.spielerchoose(); 
                kategorieofplayer = run.player.spielerchoosedKategorie();
                // Zeig dem Spieler die verglichene Karte vom Spieler.
                System.out.println("die Karte Ihres Gegners ist ");
                run.computer.showCard();
                // weiter vergleichen
                resultofRound = run.compareto(kategorieofplayer, run.player, run.computer, x);   
            }
        }
          // In letzter Runde gewinnt der Spieler
        if (resultofRound == true) {
            System.out.println( "Sie sind in letzter Runde gewonnen." );
            run.player.addPoint();
            System.out.println("Ihr endlicher Punkrunand ist:" + run.player.getPoints());
        } // In letzter Runde gewinnt der Computer
          else {
            run.computer.addPoint();
            System.out.println("Sie sind in letzter Runde leider verloren.");
            System.out.println("Ihre endlicher Punkrunand ist " + run.player.getPoints());
        }
        // Wenn der Spieler in dem ganzen Spiel gewinnt
        if ( run.player.getPoints() > run.computer.getPoints()) {
            System.out.println("Congratulation!Sie sind gewonnen!");
            System.out.println("die Punkte Ihres Gegners ist " + run.computer.getPoints());
        } // Wenn der Computer in dem ganzen Spiel gewinnt
          else if (run.player.getPoints() < run.computer.getPoints()) {
            System.out.println("Sie sind in dem Game leider verloren." );
            System.out.println("die Punkte Ihres Gegners ist " + run.computer.getPoints()+" .Versuch nochmal!");
        } // Wenn der Computer und Spieler gleichen Punktestand haben
          else {
            System.out.println("Nicht schlecht! Sie und der Bott haben gleiche Punkte." );
            System.out.println("die Punkte Ihres Gegners ist auch " + run.computer.getPoints());
        }
    }  
}