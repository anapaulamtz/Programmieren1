
public class Calculator2 {
    public static void main (String[] args){

        int operand1=Integer.parseInt(args[0]);
        String operator=args[1];
        int operand2=Integer.parseInt(args[2]);

        switch(operator){
            case "+":
                System.out.println(operand1+operand2);
                break;

            case "-":
                System.out.println(operand1-operand2);
                break;
            case "*":
                 System.out.println(operand1*operand2);
                 break;
            case "/":
                System.out.println(operand1/operand2);
                break;

            default:
                System.out.println("Nicht gültig Operation");
                break;  

        }
           

    }
}

