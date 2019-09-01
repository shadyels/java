import java.util.*;

public class ReturnsEx {
    public static void main(String[] args){
        float r = method3(method1(), method2());
        System.out.println(r);
    }

    public static int method1(){
        int pInt=5;
        return pInt;
    }

    public static double method2() {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        double pDouble = input.nextDouble();
        return pDouble;
    }

    public static float method3(int x, double y){
        float z = (float)(x+y);
        return z;
    }
}
