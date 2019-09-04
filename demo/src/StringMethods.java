import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args){
        /* String origin = "abcde";

        for(int i = 0; i < origin.length(); i++){
            System.out.println("The character at index "+i+" is "+origin.charAt(i));
        }
        System.out.println("-------");

        Scanner input = new Scanner(System.in);
        System.out.print("Choose a character: ");
        String s = input.next();

        System.out.println("The character "+s+" is at index: "+origin.indexOf(s)); */

        findString();
    }

    public static void findString(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Choose a word: ");
         String s1 = sc.next();
         String s2 = "cat";

         if(s1.contains(s2)){
             System.out.println("Found!");
         }
         else {
             System.out.println("Not Found!");
         }
    }
}
