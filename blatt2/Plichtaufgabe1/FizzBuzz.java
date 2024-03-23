public class FizzBuzz {
    public static void main(String[] args) {
        if ( args.length == 0) {
        // Wird keine in der Konsole eingegeben, wird der Satz gedrueckt
            System.out.println( "Mit diesem Spiel kann man nur eine Zahl geben");
        } else {  
            /* Wird eine Zahl eingegeben, wird ein Array mit Length n, also
            Wert der eingegeben Zahl, erzeugt*/
            String[] array = new String[Integer.parseInt(args[0])];
            for ( int i = 0; i < Integer.parseInt(args[0]); i++ ) {                 
                /* gib die Stellen des Arrays eine Liste aller Zahlen von 1 bis n*/ 
                int currentNumber = i + 1;
                array[i] = String.valueOf(currentNumber);                                
                if ( currentNumber % 3 == 0 && currentNumber % 5 == 0 ) {
                    array[i] = "Fizz-Buzz"; // durch 3 und 5 teilbar, dann FizzBuzz
                } else if ( currentNumber % 3 == 0 ) {
                    array[i] = "Fizz"; // durch 3 teilbar, dann Fizz
                } else if ( currentNumber % 5 == 0) {
                    array[i] = "Buzz"; // durch 5 teilbar, dann Buzz                       
                } else {
                    array[i] = array[i]; // sonst, erhalten bleiben
                }                            
                System.out.println("mein Array " + array[i]);    
            }             
        }
    }
}  
    
