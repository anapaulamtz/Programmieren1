import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Mastermind2{
    public static void main(String[] args){
        int a, b, c, d; /*Wir deklarieren 4 int-Variablen, die die 4 Randomzahlen sein werden */
        boolean x; /* Wir deklarieren eine boolesche Variable x */
        int[] code= new int[4]; /*Wir erstellen ein Array von Ints, es ist unser Code */
        Random random= new Random(); /*eine Instanz von die Klasse Random erzeugen, um "zufällige" Integer zu erzeugen */

/*Wir weisen den Variablen a,b,c und d einen zufälligen Wert von 1 bis 9 zu. */
     do{
        a=random.nextInt(8)+1;
        b=random.nextInt(8)+1;
        c=random.nextInt(8)+1;
        d=random.nextInt(8)+1;

/*Wenn die Variablen denselben Wert haben, nimmt die Variable x den Wert falsch an */
        if(a==b || a==c || a==d){
            x=false;
        } else if(b==c || b==d){
            x=false;
        }else if(c==d){
            x=false;
/*Wenn alle Variablen einen anderen Wert haben, fügen wir sie dem Array hinzu, sodass sie den Code bilden */
        }else{
            x= true;
            code[0]=a;
            code[1]=b;
            code[2]=c;
            code[3]=d;

            

        }
   
    
         }while(x==false);
         /*Wir wiederholen diese Block bis alle die Variablen eine verschiede Wert */


         System.out.println(code[0]);
         System.out.println(code[1]);
         System.out.println(code[2]);
         System.out.println(code[3]);

        funktionMastermind(code);
    }

    public static void funktionMastermind(int code1[]){
        Scanner input= new Scanner(System.in);
        /*Wir wandeln den Code in einen String um, um besser vergleichen zu können */
        String code2= Arrays.toString(code1);
        /*Wir trennen die vier Elemente des Codes und weisen sie 4 Variablen zu */
        String cod1, cod2, cod3, cod4;
        cod1= Character.toString(code2.charAt(1));
        cod2= Character.toString(code2.charAt(4));
        cod3= Character.toString(code2.charAt(7));
        cod4= Character.toString(code2.charAt(10));
               
/*Wir erstellen einen Block for bis zu 10, da es nur 10 Versuche gibt */
        for(int i=0; i<10; i++){
        int versuchen=10; /* Variable mit der Zahl des Versuchens */
        int zahler1=0; /* Zahler für die richtige Ziffern an der richtigen Stelle */
        int zahler2=0; /* Zahler für die Ziffern zwar richtig, aber an der falschen Stelle*/
        
        /*Do block bis alle die richtige Ziffern sind an der richtige Stelle, dh bis zahler1=4 */
            do{

              versuchen= versuchen-1;
              /*Wir versuchen die Code zu erraten */
              System.out.print("Gib deine vier Zahlen an.");
              String eingabe= input.next();
              int len= eingabe.length();
              String eingabe1, eingabe2, eingabe3, eingabe4;

            if(len==4){
              eingabe1=Character.toString(eingabe.charAt(0));
              eingabe2=Character.toString(eingabe.charAt(1));
              eingabe3=Character.toString(eingabe.charAt(2));
              eingabe4=Character.toString(eingabe.charAt(3));


                if(eingabe1.equals(cod1)){
                  zahler1++;
 
                 } else if(eingabe1.equals(cod2) || eingabe1.equals(cod3) ||  eingabe1.equals(cod4)){
                    zahler2++;
                 }
                if(eingabe2.equals(cod2)){
                    zahler1++;
                  }else if(eingabe2.equals(cod1) || eingabe2.equals(cod3) || eingabe2.equals(cod4)){
                    zahler2++;
                     }
                if(eingabe3.equals(cod3)){
                    zahler1++;
                  }else if(eingabe3.equals(cod1)|| eingabe3.equals(cod2)|| eingabe3.equals(cod4)){
                    zahler2++;
                    }

                if(eingabe4.equals(cod4)){
                    zahler1++;
                 }else if(eingabe4.equals(cod1)|| eingabe4.equals(cod2) || eingabe4.equals(cod3)){
                    zahler2++;
                }

                if(zahler1!=4){
                System.out.println("Die richtige Ziffern an der richtigen Stelle sind");
                System.out.println(zahler1);
                System.out.println("Die Ziffern zwar richtig, aber an der falschen Stelle sind:");
                System.out.println(zahler2);
                System.out.println("Du hast noch");
                System.out.println(versuchen);
                System.out.println("versuchen");
                zahler1=0;
                zahler2=0;
              
              }

                 
            
               }
               
            else{
                System.out.println("Du kannst nur 4 Zahlen eingeben. Versucht noch einmal. Du hast noch");
                System.out.println(versuchen);
                System.out.println("versuchen");
               }

               
        
            }while(zahler1!=4 );

            System.out.println("Du hast recht. Die Zahlen sind:");
            System.out.println(code2);

          }
      }
         
}
        
 
       
    
        
 




   
        
    
            






