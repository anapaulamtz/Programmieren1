
import java.util.Scanner;

public class Zahlenraten{
    public static void main(String[] args){
           selberraten();         
        }                              
             
    
    public static void selberraten() {
        int Suchzahl = (int)(Math.random()*100);
        Scanner sc = new Scanner(System.in);
        int nextNummer = sc.nextInt();

        while(nextNummer != Suchzahl ){
            System.out.println("weiterraten");
            
            if(nextNummer > Suchzahl){                                
                System.out.println("Die Suchzahl ist kleiner");
                nextNummer = sc.nextInt();
            }    
            else{
                System.out.println("die Suchzahl ist groesser");
                nextNummer = sc.nextInt();

            }                             
        }
        System.out.println("korrekt"); 
            
    }

}