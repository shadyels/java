import java.util.Scanner;

public class FractionCalculator {
    public static void main(String[] Args) {

        System.out.println("Welcome to Fraction Calculator");
        Fraction a = calculation();
        System.out.println(a);
    }

    public static Fraction calculation(){
        String operation = getOperation();
        Fraction fraction1 = getFraction();
        Fraction fraction2 = getFraction();

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

    public static String getOperation() {
        System.out.print("Choose an operation: ");
        Scanner input = new Scanner(System.in);
        String operation = input.nextLine();

        while (
            !operation.equals("/") &&
            !operation.equals("+") &&
            !operation.equals("*") &&
            !operation.equals("-") &&
            !operation.equals("Q")
        ){
            System.out.print("input a valid operation");
            operation = input.nextLine();
        }

        return operation;
    }

    public static boolean isValidFraction(String input) {
        boolean test;
        if (input.contains("/")) {
            String[] inputSplit = input.split("/");
            test = inputSplit[0].matches("^-?\\d+$") && inputSplit[1].matches("^-?\\d+$"); // any int regex
        } else if (input.matches("^-?\\d+$") || input.matches("^$")) {
            test = true;
        } else {
            test = false;
        }
        return test;
    }

    public static Fraction getFraction() {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a numerator (a) or a function (a/b): ");
        String fractionString = input.nextLine();

        while (!isValidFraction(fractionString)) {
            System.out.print("Invalid fraction. Please enter a fraction (a/b) or (a), where a and b are integers and b is not zero: ");
            fractionString = input.nextLine();
        }

        if (fractionString.contains("/")) {
            String[] inputParts = fractionString.split("/");
            int num = Integer.parseInt(inputParts[0]);
            int den = Integer.parseInt(inputParts[1]);
            Fraction fraction = new Fraction(num, den);
            return fraction;
        } else if (fractionString.matches("^-?\\d+$")) {
            int num = Integer.parseInt(fractionString);
            Fraction fraction = new Fraction(num);
            return fraction;
        } else { //empty string regex
            Fraction fraction = new Fraction();
            return fraction;
        }
    }
}