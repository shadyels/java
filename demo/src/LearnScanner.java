import java.util.Scanner;

public class LearnScanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.println("Hello!");
        System.out.println("What is your name?");
        String name = input.next();
        System.out.println("Hello "+ name);
        System.out.println("what about your address?");
        String address = input2.nextLine();
        System.out.println(address);
        double myDouble;
        System.out.print("Type a double: ");
        Scanner doubleIn = new Scanner(System.in);
        myDouble = doubleIn.nextDouble();
        System.out.println("Succes print "+myDouble);
    }
}
