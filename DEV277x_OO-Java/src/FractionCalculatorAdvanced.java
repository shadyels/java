import java.util.Scanner;

public class FractionCalculatorAdvanced{
    public static void main(String[] Args) {

        System.out.println("Welcome to Advanced Fraction Calculator!\nYou can use any of the following operations add (+), subtract (-), multiply (*) and divide (/), input Q or q to exit the program.\nInput you fraction either in the from a/b, or just a to get a/1, or don't input any argument to get a fraction of 0/1\n");

        int t = 0;
        while(t < 3){
        Fraction a = advancedMethod();
        System.out.println(a);
        System.out.println();
        t++;
        if(t < 3){
            System.out.println("Let's do this again!");
        } else {
            System.out.println("That's it for today, goodbye!");
        }
        }
    }

    public static Fraction advancedMethod(){
        System.out.print("Input your operation in the following form [FRACTION] [OPERATION] [FRACTION]: ");
        Scanner input = new Scanner(System.in);

        String userInput = input.nextLine();
        String[] split = userInput.split("\\s+");

        String fraction1Str = split[0];
        String operation = split[1];
        String fraction2Str = split[2];

        while (
            !operation.equals("/") &&
            !operation.equals("+") &&
            !operation.equals("*") &&
            !operation.equals("-") &&
            !operation.equals("Q")
        ){
            System.out.print("Syntax Error! Please input your operation in the following form [FRACTION] [OPERATION] [FRACTION]: ");
            userInput = input.nextLine(); //if doesn't work just restart the protocol
        }

        while (!isValidFraction(fraction1Str) && !isValidFraction(fraction2Str)) {
            System.out.print("Syntax Error! Please input your operation in the following form [FRACTION] [OPERATION] [FRACTION]: ");
            userInput = input.nextLine(); //if doesn't work re start
         }

        Fraction fraction1 = getFraction(fraction1Str);
        Fraction fraction2 = getFraction(fraction2Str);

        Fraction a = new Fraction(1,1);
        if(operation.equals("+")){
            a = fraction1.add(fraction2);
        } else if(operation.equals("-")){
            a = fraction1.subtract(fraction2);
        } else if(operation.equals("*")){
            a = fraction1.multiply(fraction2);
        } else if(operation.equals("/")){
            a = fraction1.divide(fraction2);
        } else {
            System.exit(0);
        }

        a.toLowestTerms();
        return a;
    }

    public static Fraction getFraction(String fractionStr) {
        if (fractionStr.contains("/")) {
            String[] inputParts = fractionStr.split("/");
            int num = Integer.parseInt(inputParts[0]);
            int den = Integer.parseInt(inputParts[1]);
            Fraction fraction = new Fraction(num, den);

            return fraction;

        } else if (fractionStr.matches("^-?\\d+$")) {
            int num = Integer.parseInt(fractionStr);
            Fraction fraction = new Fraction(num);

            return fraction;

        } else { //empty string regex
            Fraction fraction = new Fraction();
            return fraction;
        }
    }

    public static boolean isValidFraction(String input) {
        boolean test;
        if (input.contains("/")) {
            String[] inputSplit = input.split("/");
            test = inputSplit[0].matches("^-?\\d+$") && inputSplit[1].matches("^-?\\d+$"); // any int regex
        } else if (input.matches("^-?\\d+$") || input.matches("^$") || input.equalsIgnoreCase("Q")) {
            test = true;
        } else {
            test = false;
        }
        return test;
    }
}
