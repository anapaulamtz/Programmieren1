public class Calculator {
    public static void main (String[] args){

        int operand1=Integer.parseInt(args[0]);
        String operator=args[1];
        int operand2=Integer.parseInt(args[2]);

        if (operator.equals("+")) {
            System.out.println(operand1+operand2);
            
        } else {
            System.out.println(operand1-operand2);

        }
           

    }
}
    
