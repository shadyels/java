import java.util.Locale;
import java.util.Scanner;

public class Parameters {
    public static void main(String[] args){
        powerOf2(3);
        power(2, 3);
        power(2, 20);
        power(4, 3);
        power(9, 2);

        Scanner input = new Scanner(System.in);
        System.out.print("Choose your base: ");
        double base = input.nextDouble();
        System.out.print("Choose your exp: ");
        int exp = input.nextInt();

        power(base, exp);

    }

    public static void powerOf2 (int exp) {
        int result = 1;
        for(int i = 1; i <= exp; i++){
            result *= 2;
        }
        System.out.println("2 to the power of " + exp + " = " + result);
    }

    public static void power(double base, int exp){
        int result = 1;
        for(int i = 1; i <= exp; i++){
            result *= base;
        }
        System.out.println(base+" to the power of " + exp + " = " + result);
    }
}
