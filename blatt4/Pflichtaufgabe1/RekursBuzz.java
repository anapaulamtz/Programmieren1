class RekursBuzz {

    //Wir erstellen eine FizzBuzz-Funktion, die einen String zurückgibt.
    //Die Funktion benötigt die letzte Zahl, bis zu der gedruckt werden soll und die erste.
    public static String FizzBuzz(int oberschrank , int unterschrank ) {
        //Wir erstellen eine Variable vom Typ String, die die Elemente speichert, die wir zurückgeben möchten.
        String a = null;

        //Wir weisen der Variablen ein Element zu.
        if ( unterschrank % 15 == 0) {
            a = "Fizz-Buzz";
        } else if ( unterschrank % 3 == 0 ) {
            a = "Fizz";
        } else if ( unterschrank % 5 == 0 ) {
            a = "Buzz";
        } else {
            a = String.valueOf(unterschrank);
        }

        //Wenn der letzte Wert gleich dem ersten ist, geben wir ihn zurück
        if ( oberschrank == unterschrank) {
            return " " + a + " ";

        //Wenn nicht, geben wir den String zurück, der mit dem ersten Wert beginnt, und rufen die rekursive Funktion auf, 
        //die 1 zum Anfangswert hinzufügt, bis der letzte Wert erreicht ist.
        } else {
            return " " + a + " " + FizzBuzz(oberschrank, unterschrank + 1);
        }
    }
    
    public static void main(String[] args) {
        String output = FizzBuzz(Integer.parseInt(args[0]), 1);
        System.out.print(output);
    }
}

