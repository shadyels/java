import java.util.Scanner;

public class rpsGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("What does Player 1 choose? ");
        String playerOne = input.next();

        System.out.print("What does Player 2 choose? ");
        String playerTwo = input.next();

        if (playerOne.equals("rock")) {
            if (playerTwo.equals("scissors")) {
                System.out.println("Player 1 wins");
            }
            else if (playerTwo.equals("paper")){
                System.out.println("Player 2 wins");
            }
            else {
                System.out.println("It's a tie");
            }
        }

        else if (playerOne.equals("scissors")) {
            if (playerTwo.equals("paper")) {
                System.out.println("Player 1 wins");
            }
            else if (playerTwo.equals("rock")){
                System.out.println("Player 2 wins");
            }
            else {
                System.out.println("It's a tie");
            }
        }

        else if (playerOne.equals("paper")) {
            if (playerTwo.equals("rock")) {
                System.out.println("Player 1 wins");
            }
            else if (playerTwo.equals("scissor")){
                System.out.println("Player 2 wins");
            }
            else {
                System.out.println("It's a tie");
            }
        }

        else {
            System.out.println("Invalid Choices");
        }
    }
}
