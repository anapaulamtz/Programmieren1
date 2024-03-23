class Card {
        // die Eigenschaft des Objekts der Klasse Karte erstellen
        private String name;
        private String zugehörigkeit;
        private double height;
        private int intelligence, strength, jedipower;
        // Konstruktor fuer ein Objekt Karte.
        public Card(String name, String zugehörigkeit, double height, int intelligence, int strength, int jedipower) {
            this.name = name;
            this.zugehörigkeit = zugehörigkeit;
            this.height = height;
            this.intelligence = intelligence;
            this.strength = strength;
            this.jedipower = jedipower;
        }
        // die Methoden getFunktionen, durch die die Eigenschaften der Karten zugegriffen werden.
        public String getName() {
            return name;
        }
    
        public String getZugehörigkeit() {
            return zugehörigkeit;
        }
    
        public double getHeight() {
            return height;
        }
    
        public int getIntelligence() {
            return intelligence;
        }
    
        public int getStrength() {
            return strength;
        }
    
        public int getJedipower() {
            return jedipower;
        }
        // die Methode, die Karte zusammen mit ihren Eigenschaften drueckt.
        public String toString() {
            String returnString =  "\n"+"######"+"\n"
                                    +getName()+"\n"
                                    +getZugehörigkeit()+"\n"
                                    +"height: "+getHeight()+"\n"
                                    +"intelligence: "+getIntelligence()+"\n"
                                    +"strength: "+getStrength()+"\n"
                                    +"jedi power: "+getJedipower()+"\n"
                                    +"######";
            return returnString;
        }
    }


