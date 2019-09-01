

public class JavaMath {
    public static void main(String[] args){
        int a = 5;
        int b = 6;
        double aSq = Math.pow(a, 2);
        double bSq = Math.pow(b, 2);

        double c = Math.sqrt(aSq+bSq);
        long cLong = Math.round(c);
        System.out.println(c);
        System.out.println(cLong);
        System.out.println("-------------");

        double r = Math.random()*10;
        System.out.println(r);
        System.out.println("-------------");

        for(int i = 50; i >= 0; i-=5){
            System.out.println(i);
        }
    }
}
