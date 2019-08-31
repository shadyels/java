import java.util.*;

public class OddsOrEvens {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Hello what is your name? ");
        String name = input.next();

        System.out.print("Nice to meet you"+name+"! Do you choose (O)dds or (E)vens? ");
        String playerChoice = input.next();

        if(playerChoice.equalsIgnoreCase("O")){
            System.out.println(name+" has picked Odds! The computer will be Evens");
            String computerChoice = "E";
        }
        else if (playerChoice.equalsIgnoreCase("E")){
            System.out.println(name+" has picked Evens! The computer will be Odds");
            String computerChoice = "E";
        }

        else {
            System.out.println("You did not choose a valid number");
        }

        System.out.println("------------------");

        System.out.println("Hello "+name+" which number are you going to play? ");
        int player = input.nextInt();

        Random rand = new Random();
        int computer = rand.nextInt(6);

        System.out.println("You have played "+player+" the computer has played "+computer+".");

        int sum = player+ computer;
        boolean oddsOrEven = sum % 2 == 0;

        if(oddsOrEven){
            if(playerChoice.equalsIgnoreCase("E")){
                System.out.println(player+"+"+computer+" = "+sum+" and is Even. "+name+" won the game!");
            }
            else {
                System.out.println(player+"+"+computer+" = "+sum+" and is Even. The computer won the game!");
            }
        }
        else{
            if (playerChoice.equalsIgnoreCase("O")){
                System.out.println(player+"+"+computer+" = "+sum+" and is Odd. The computer won the game!");
            }
            else {
                System.out.println(player+"+"+computer+" = "+sum+" and is Odd. "+name+" won the game!");
            }
        }
    }
}


