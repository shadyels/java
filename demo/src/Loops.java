import java.util.Scanner;

// table using nested loop
public class Loops {
    public static void main(String[] args) {
        for (int row = 0; row <= 5; row++) {
            System.out.print("row "+row+": ");
            for (int col = 0; col <= 10; col++) {
                System.out.print(col+" ");
            }
            System.out.println();
        }

        for (int i = 1; i <= 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        whileLoop();
        whileHello();
    }

    public static void whileLoop() {
        int i = 0;
        while (i<5) {
            System.out.println("infinite");
            i++;
        }
    }

    public static void whileHello() {
        Scanner input = new Scanner(System.in);
        String g = input.next();
        while (g.equalsIgnoreCase("Hello")){
            System.out.println("Hello");
            g = input.next();
        }
        System.out.println("Goodbye!");
    }
}
