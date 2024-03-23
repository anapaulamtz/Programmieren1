import java.util.Random;
import java.util.Scanner;
public class Player {
    // die Eigenschaften des Objekts der Klasse Player erstellen.
    String name;
    private Stack kartenStapel; 
    private int punkteStand;
    // Konstruktor fuer das Objekt der Klasse Player.
    public Player(String name, int punkteStand, Stack kartenStapel) {
        this.name = name;
        this.punkteStand = punkteStand;
        this.kartenStapel = kartenStapel;
    }
    // die Restkarten zaehlen
    public int countCards() {
        return kartenStapel.count();
    }
    // die Punkte um ein erhoehen
    public void addPoint() {
        punkteStand++;
    }
    // den aktuellen Punktestand zeigen
    public int getPoints() {
        return punkteStand;
    }
    // die Methode, durch die ein Objekt der Klasse Stack zugegriffen wird.
    public Stack getKartenstapel() {
        return kartenStapel;
    }

    public void showCard() {
        kartenStapel.showCard();
    }
    
    public Card playCard(int kategorie) {
        return kartenStapel.playCard();
    }

    public Card playCard() {
        return kartenStapel.playCard();    
    }
    // Methode, dass der Spieler die Kategorie als eine Nummer eingibt.
    public int spielerchoosedKategorie() {
        System.out.println("Geben Sie bitte 1 für height, 2 für intelligence,3 für strength oder 4 für jedipower ein! ");
        Scanner sc = new Scanner(System.in);
        int kategorieofplayer = sc.nextInt();
        return kategorieofplayer;
    }
    // Methode, dass der Computer beliebig eine Kategorie als Nummer auswaehlt.
    public int computerchoosedKategorie() {
        Random random = new Random();
        int kategorieofcomputer = random.nextInt(4)+1;
        return kategorieofcomputer;
    }
}     