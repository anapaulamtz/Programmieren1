import java.util.Random;
class GameMaster{
    // ein Objekt des Datentyps Map erstellen, wobei ein Map 20x20 gleichzeitig erstellt wird.
    Map karte = new Map(20, 20, 20, 5);
    // die Methode, dass Carnivore das Herbivore fresst.
    public void Eat() {
        int[] dinoToEat = new int[2];
        for ( int a = 0; a < karte.map.length; a++ ) {
            for ( int b = 0; b < karte.map[0].length; b++) {
                // check, ob die Koordinate Carnivore enthält und ob sein Nachbarfeld Herbivore enthält.
                if(karte.getCoordinate(a, b).getType() == MapObjektType.CARNIVORE && Move(a, b, MapObjektType.HERBIVORE)) {
                    // such eine Koordinate des Nachbarfeldes, wo Herbivore enthält und die Koordinate in einer Reference speichern
                    dinoToEat = Nachbar(a, b, MapObjektType.HERBIVORE);
                    /* Carnivore versuch Herbivore zu fressen
                    wenn es erfolgreich Herbivore fresst, wird das Nachbarfeld durch das Objekt Leer ersetzt*/
                    if(((Carnivore)karte.map[a][b]).attemptEat()) {
                        karte.map[dinoToEat[0]][dinoToEat[1]] = new Empty();
                    }
                }
            }
        }
    }
    // die Methode, der Dino bewegen zu lassen.
    public void Bewegung() {
        int count = 0;
        // ein 25 stelliges Array erstellen, das die schon bewegten Dinos speichert.
        MapObjekt[] temp = new MapObjekt[25];
        // ein 2-stelliges Array, das die Koordinate speichert, nach der der Dino bewegen wird.
        int[] nachbartoswitch = new int[2];
        for ( int a = 0; a < karte.map.length; a++ ) {
            for ( int b = 0; b < karte.map[0].length; b++) {
                // check, ob die Koordinate ein Dino enthält.
                if(karte.checkCoordinate(a, b)){
                    // check, ob das betrachtete Dino schon bewegt hat und ob seine Nachnarn leer sind.
                    if(isnotMoved(karte.map[a][b], temp) && Move(a, b, MapObjektType.EMPTY)) {
                        // Such eine Richtung, nach der das Dino bewegen wird und die Information in einer Reference gespeichert
                        nachbartoswitch = Nachbar(a, b, MapObjektType.EMPTY);
                        // Tauschen die Koordinate des betrachteten Dino mit der Koordinate des gesuchten Nachbars
                        // gleichzeitig wird dieser bewegte Dino in einem Array speichern.
                        temp[count] = karte.map[a][b];
                        karte.map[a][b] = karte.map[nachbartoswitch[0]][nachbartoswitch[1]];
                        karte.map[nachbartoswitch[0]][nachbartoswitch[1]] = temp[count];
                        count++;
                    } 
                }
            }
        }
    }
    // check, ob sich der Dino schon bewegt hat.
    public boolean isnotMoved(MapObjekt testobjekt, MapObjekt[] testtemp) {
        boolean x = true;
        for ( MapObjekt i : testtemp ) {
            if (testobjekt.equals(i)) {
                x = false;
            }
        }
        return x;
    }
    // check, ob der Nachbar von betrachtem Dino leer ist oder Herbivore ist
    public boolean Move(int a, int b, MapObjektType type) {
        boolean x = false;
        if((karte.getCoordinate( a, b + 1) != null) && (karte.getCoordinate( a, b + 1).getType() == type)) {
            x = true;
        }
        if((karte.getCoordinate( a + 1, b) != null) && (karte.getCoordinate( a + 1, b).getType() == type)) {
            x = true;
        }
        if((karte.getCoordinate( a + 1, b + 1) != null) && (karte.getCoordinate( a + 1, b + 1).getType() == type)) {
            x = true;
        }
        if((karte.getCoordinate( a, b - 1) != null) && (karte.getCoordinate( a, b - 1).getType() == type)) {
            x = true;
        }
        if((karte.getCoordinate( a + 1, b - 1) != null) && (karte.getCoordinate( a + 1, b - 1).getType() == type)) {
            x = true;
        }
        if((karte.getCoordinate( a - 1, b) != null) && (karte.getCoordinate( a - 1, b).getType() == type)) {
            x = true;
        }
        if((karte.getCoordinate( a - 1, b + 1) != null) && (karte.getCoordinate( a - 1, b + 1).getType() == type)) {
            x = true;
        }
        if((karte.getCoordinate( a - 1, b - 1) != null) && (karte.getCoordinate( a - 1, b - 1).getType() == type)) {
            x = true;
        } 
        return x;
    }
    // gib ein 2-stelliges Array zurück, in dem die erste, zweite Stelle die Koordinate des Felds  zeigt, nach dem der Dino geht.
    public int[] Nachbar(int a, int b, MapObjektType type) {
        int[] arr = new int[2];
        Random random = new Random();
        int beliebigeZahl = 0;
        // eine Zahl von 1 bis 8 wird immer erstellt, bis bei dem korrespondierenden Fall eine geeignete Koordinate gesucht wird. 
        do {
            beliebigeZahl = random.nextInt(8) + 1;
            switch(beliebigeZahl) {
                case 1:
                    /* wenn die Koordinate innerhalb der Karte ist und die betrachtete Type enthält, dann wird die
                    entsprechende Koordinate in dem erstellten Array gespeichert.*/
                    if((karte.getCoordinate( a, b + 1) != null) && (karte.getCoordinate( a, b + 1).getType() == type)) {
                        arr[0] = a;
                        arr[1] = b + 1;
                    }
                    break;
                case 2:
                    if((karte.getCoordinate( a + 1, b) != null) && (karte.getCoordinate( a + 1, b).getType() == type)) {
                        arr[0] = a + 1;
                        arr[1] = b;
                    }
                    break;
                case 3:
                    if((karte.getCoordinate( a + 1, b + 1) != null) && (karte.getCoordinate( a + 1, b + 1).getType() == type)) {
                        arr[0] = a + 1;
                        arr[1] = b + 1;
                    }
                    break;
                case 4:
                    if((karte.getCoordinate( a, b - 1) != null) && (karte.getCoordinate( a, b - 1).getType() == type)) {
                        arr[0] = a;
                        arr[1] = b - 1;
                    }
                    break;
                case 5:
                    if((karte.getCoordinate( a + 1, b - 1) != null) && (karte.getCoordinate( a + 1, b - 1).getType() == type)) {
                        arr[0] = a + 1;
                        arr[1] = b - 1;
                    }
                    break;
                case 6:
                    if((karte.getCoordinate( a - 1, b) != null) && (karte.getCoordinate( a - 1, b).getType() == type)) {
                        arr[0] = a - 1;
                        arr[1] = b;
                    }
                    break;
                case 7:
                    if((karte.getCoordinate( a - 1, b + 1) != null) && (karte.getCoordinate( a - 1, b + 1).getType() == type)) {
                        arr[0] = a - 1;
                        arr[1] = b + 1;
                    }
                    break;
                case 8:
                    if((karte.getCoordinate( a - 1, b - 1) != null) && (karte.getCoordinate( a - 1, b - 1).getType() == type)) {
                        arr[0] = a - 1;
                        arr[1] = b - 1;
                    } 
                    break;
                default:
                    break;
            }
        } while(arr[0] == 0 && arr[1] == 0);
    return arr;
    }
    // check, ob die Karte noch Herbivore enthält.
    public boolean existierHerbivore() {
        boolean x = false;
        for ( int a = 0; a < karte.map.length; a++ ) {
            for ( int b = 0; b < karte.map[0].length; b++) {
                if (karte.map[a][b].getType() == MapObjektType.HERBIVORE){
                    x = true;
                }
            }
        }
        return x;
    }
    // die Anzahl der Dinos zählen
    public int[] anzahlDino() {
        int anzahlHerbi = 0;
        int anzahlCarni = 0;
        int[] x = new int[2];
        for ( int a = 0; a < karte.map.length; a++ ) {
            for ( int b = 0; b < karte.map[0].length; b++) {
                if (karte.map[a][b].getType() == MapObjektType.HERBIVORE){
                    anzahlHerbi++;
                }
                if (karte.map[a][b].getType() == MapObjektType.CARNIVORE){
                    anzahlCarni++;
                } 
            }
        }
        x[0] = anzahlHerbi;
        x[1] = anzahlCarni;
        return x;
    }
    // die restlichen Herbivore auflisten
    public void listeHerbivore() {
        System.out.print("die lebenden Herbivoren sind: " + "\n");
        for ( int a = 0; a < karte.map.length; a++ ) {
            for ( int b = 0; b < karte.map[0].length; b++) {
                if (karte.map[a][b].getType() == MapObjektType.HERBIVORE){
                    System.out.print(karte.map[a][b].print());  
                }
            }
        }
    }
    // die restlichen Carnivore auflisten
    public void listeCarnivore() {
        System.out.print("die Carnivoren sind: " +"\n");
        for ( int a = 0; a < karte.map.length; a++ ) {
            for ( int b = 0; b < karte.map[0].length; b++) {
                if (karte.map[a][b].getType() == MapObjektType.CARNIVORE){
                    System.out.print(karte.map[a][b].print());  
                }
            }
        }
    }
    // das Programm wird hier ausgeführt.
    public void gameLoop() {
        // ein 2-stelliges Array, das die restliche Anzahl von Herbivore(Stelle 0) und Carnivore(Stelle 1) speichert
        int[] anzahldino = new int[2];
        int Runde = 0; // die Runde zählen
        // die Objekte auf der Karte setzen
        karte.randomZaun();
        karte.randomCarnivore();
        karte.randomHerbivore();
        karte.addLeerzeichen();
        do {
            System.out.print(karte.toString() +"\n"); // Map drucken
            anzahldino = anzahlDino();
            listeHerbivore(); // in der Konsole die Liste von Herbivoren ausgeben
            // gib die Anzahl der Herbivore in der Konsole aus
            System.out.println("\n"+ "die Anzahl der Herbivore: " + anzahldino[0]);
            listeCarnivore(); // in der Konsole die Liste von Carnivoren ausgeben.
            // gib die Anzahl der Carnivore in der Konsole aus
            System.out.println("\n" + "die Anzahl der Carnivore: " + anzahldino[1] + "\n");
            Eat(); // Such die Carnivore, wenn es Herbivore herum um Carnivore gibt, versuch Carnivore den Herbivore zu fressen
            Bewegung(); // Such die Dinos, wenn es herum um Dinos leer ist, bewegt das Dino in randome Richtung.
            Runde++; // Anzahl der Ruch um 1 hochsetzen
        } while(existierHerbivore()); // der Vorgang läuft, solange es noch Herbivoren in der Karte gibt.
        System.out.print(karte.toString() + "\n"); // print die Karte
        listeCarnivore(); // die Carnivore auflisten
        // Anzahl der Dinos ausgeben
        System.out.println("\n"  + "die Anzahl der Carnivore: " + anzahlDino()[1]+
                            "\n" + "die Anzahl der Herbivore: " + anzahlDino()[0]);
        System.out.println("die gesamten Runden: " + Runde); // Gib die gesamten Runde aus
    }

    public static void main(String[] args) {
        GameMaster gameEngine = new GameMaster();
        gameEngine.gameLoop();
    }
}
