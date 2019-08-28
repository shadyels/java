import java.util.Locale;
import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args) {
        intro();
        budget();
    }

    public static void intro(){
        System.out.println("Welcome to vacation planner!");
        System.out.print("What is your name? ");
        Scanner inputIntro = new Scanner(System.in);
        String name = inputIntro.next();
        System.out.print("Nice to meet you "+name+" where are you travelling to? ");
        Scanner inputDest = new Scanner(System.in);
        String destination = inputDest.nextLine();
        System.out.println("Great! "+destination+" sounds like a great trip.");
    }

    public static void budget(){
        System.out.print("How many days are you traveling? ");
        Scanner inputDays = new Scanner(System.in);
        int days = inputDays.nextInt();

        System.out.print("How much money are you taking with you? ");
        Scanner inputMoney = new Scanner(System.in);
        int money = inputMoney.nextInt();

        System.out.print("How many MXC are there in 1 USD? ");
        Scanner inputRate = new Scanner(System.in).useLocale(Locale.US);
        double rate = inputRate.nextDouble();

        System.out.println("if you are traveling for "+days+" days that is the same as "+(days*24)+" hours or "+(days*24*60)+" minutes");
        System.out.println("If you are going to spend "+days+" days you can spend up to "+(money/days)+" USD per day");
        System.out.println("Your total budget in MXC is "+(rate*money)+" which per day is "+(rate*money)/days+" MXC");
    }

    public static void time() {
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        Scanner inputHrs = new Scanner(System.in);
        int hours = inputHrs.nextInt();
        System.out.println("That means that when it is midnight at home it will be "+hours+":00 at your travel destination. And when it is noon it will be"+(12+hours)+":00");
    }
}
