import java.util.*;

public class ExerciseMult3 {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        Double  num1 = sc.nextDouble();

        Method2(Method1(num1));
    }
    public static int Method1(double x){
        int y=(int)(x);
        return y;
    }

    public static void Method2(int x){
        x = 3*x;
        System.out.println(x);
    }
}


