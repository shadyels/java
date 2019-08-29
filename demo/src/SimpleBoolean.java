import java.util.Scanner;

public class SimpleBoolean {
    public static void main(String[] args) {

        System.out.print("What is your grade? ");
        Scanner input = new Scanner(System.in);
        int grade = input.nextInt();

        if (grade > 60) {
            System.out.println("Congratulations! You're admitted");
        }

        else if (grade > 40 && grade < 60) {
            System.out.println("You're not on the shortlist but we will contact you if necessary");
        }

        else {
            System.out.println("We regret to inform you that you have not been selected.");
        }
    }
}
