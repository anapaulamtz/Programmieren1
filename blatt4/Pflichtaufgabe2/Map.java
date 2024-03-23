
import java.util.Random;
public class Map {

    MapObjekt[][] map;
    int anzahlHerbivore;
    int anzahlCarnivore;

    String[] herbivoreName = {"Achelousaurus", "Aegyptosaurus", "Agilisaurus", "Alamosaurus", "Anchisaurus",
                        "Albertaceratops", "Amargasaurus", "Ammosaurus", "Ampelosaurus", "Amygdalodon",
                        "Anchiceratops", "Ankylosaurus", "Antarctosaurus" , "Apatosaurus" , "Aragosaurus", 
                        "Aralosaurus", "Archaeoceratops", "Argentinosaurus", "Arrhinoceratops" , "Atlascocosaurus"};

    String[] carnivoreName = {"Allosaurus", "Dimetrodon", "Plesiosaurus", "Pterodactyl", "Spinosaurus"};

    int[] herbivoreId = { 10, 11, 12, 13, 14, 
                        15, 16, 17, 18, 19,
                        20, 21, 22, 23, 24,
                        25, 26, 27, 28, 29};

    int[] carnivoreId = { 30, 31, 32, 33, 34};

        
    // In dem Konstruktor wird die Karte hergestellt.
    public Map( int breite, int länge, int anzahlHerbivore, int anzahlCarnivore) {
        this.anzahlHerbivore = anzahlHerbivore;
        this.anzahlCarnivore = anzahlCarnivore;   
        this.map = new MapObjekt[breite][länge];
    }
    // 10% der Karte wird mit Fence gesetzt und gleichzeitig wird das Objekt Fence erstellt.
    public void randomZaun() {
        int counter = 0;
        do {
            Random i = new Random();
            int indexi = i.nextInt(map.length);
            Random j = new Random();
            int indexj = j.nextInt(map[0].length);
            if ( map[indexi][indexj] == null ) {
                map[indexi][indexj] = new Fence(); 
                counter++;
            } 
        } while ( counter < (map.length)*(map[0].length)*0.1 );
    }
    // 20 Objekte von Herbivoren werden hergestellt und in der Karte gesetzt.
    public void randomHerbivore() {
        int counter = 0;
        do {
            Random i = new Random();
            int indexi = i.nextInt(map.length);
            Random j = new Random();
            int indexj = j.nextInt(map[0].length);
            if ( map[indexi][indexj] == null ) {
                map[indexi][indexj] = new Herbivore(herbivoreId[counter], herbivoreName[counter]);   
                counter++;
            }  
        } while ( counter < anzahlHerbivore );
    }
    // 5 Objekte von Carnivoren werden hergestellt und in der Karte gesetzt.
    public void randomCarnivore() {
        int counter = 0;
        do {
            Random i = new Random();
            int indexi = i.nextInt(map.length);
            Random j = new Random();
            int indexj = j.nextInt(map[0].length);
            if ( map[indexi][indexj] == null ) {
                map[indexi][indexj] = new Carnivore(carnivoreId[counter], carnivoreName[counter]);   
                counter++;
            }  
        } while ( counter < anzahlCarnivore );
    }
    //  die Objekte von Empty werden hergestellt und in der Karte gesetzt.
    public void addLeerzeichen() {
        for (int a = 0; a < map.length; a++) {
            for (int b = 0; b < map[0].length; b++) {
                if ( map[a][b] == null ) {
                    map[a][b] = new Empty();
                }
            }
        }
    }

    /*
     * @param x
     * @param y
     * @return boolean
     */
    // check, ob der Koordinate Dino enthält, true in dem Falll von Dino, false in dem Fall von Fence und Empty.
    public boolean checkCoordinate(int x, int y) {
        if ( map[x][y].getType() == MapObjektType.EMPTY || map[x][y].getType() == (MapObjektType.FENCE)) { 
            return false;
        } else {
            return true;
        }
    }
    // getCoordinate, wenn die Koordinate in der Karte liegt, sonst wird null zurückgegeben.
    public MapObjekt getCoordinate(int x, int y) {
        if ( x < 0 || x > map.length - 1 || y < 0 || y > map[0].length - 1) {
            return null;
        }
        return map[x][y];
    }
    // print Map.
    public String toString() {
        String output = "------------------------------------------------------------------------------------"+
                        "--------------------------------------------------------" + "\n";
        for (int a = 0; a < map.length; a++) {
            for (int b = 0; b < map[0].length; b++) {
                output += map[a][b].print();
            }
            output +="\n";
        }
        output += "------------------------------------------------------------------------------------"+
                    "--------------------------------------------------------";
        return output;
    }
}

