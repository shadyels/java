import java.util.Locale;
import java.util.Scanner;

public class ClassGrades {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("This program calculates the grades and average for the class");
        System.out.print("How many grades do you want to input? ");
        int numGrades = input.nextInt();

        int[] myGrades = new int[numGrades];
        for(int i = 0; i < myGrades.length; i++){
            System.out.print("Input the grade for HW "+(i+1)+" out of "+myGrades.length+": ");
            myGrades[i] = input.nextInt();
        }

        int sum = 0;
        for(int i = 0; i < myGrades.length; i++){
            sum += myGrades[i];
        }

        int avg = sum/myGrades.length;

        int aboveAvg = 0;
        for(int i = 0; i < myGrades.length; i++){
            if(myGrades[i] > avg){
                ++aboveAvg;
            }
        }

        System.out.println("The average score was "+avg);
        System.out.println(aboveAvg+" homeworks were above average");
    }
}
