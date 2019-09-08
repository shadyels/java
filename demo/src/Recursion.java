import java.util.Scanner;

public class Recursion {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Choose a number: ");
        int n = input.nextInt();
        System.out.println("Method 1: "+factorial(n));
        System.out.println("Method 2: "+factorial2(n));
        System.out.println("Method 3: "+factorial3(n));
        System.out.println("-----");
        System.out.println("Fibonacci: "+fibonacci(n));

        Scanner inputStr = new Scanner(System.in);
        System.out.print("Choose a String to reverse: ");
        String s = inputStr.nextLine();
        System.out.println(reverse(s));
    }

    public static int factorial(int n){
        if(n == 1){return 1; }
        return n*factorial(n-1);
    }

    public static int factorial2(int n){
        int result = 1;
        for(int i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }

    public static int factorial3(int n){
        if(n==1){
            return 1;
        }
        else {
            return n * factorial3(n-1);
        }
    }

    public static int fibonacci(int n){
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 1;
        }
        else{
            return n = fibonacci(n-1)+fibonacci(n-2);
        }
    }

    public static String reverse (String s){
        if(s.length()<=1){
            return s;
        }
        else {
            return reverse(s.substring(1))+s.charAt(0);
        }
    }
}
