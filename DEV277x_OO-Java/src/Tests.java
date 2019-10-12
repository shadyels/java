public class Tests {
    public static void main(String[] args){
        pointDistanceTest();
    }

    public static void pointDistanceTest(){
        Point point = new Point(1, 1);
        Point point1 = new Point(4, 11);
        point.returnDistance(point1);

        System.out.println(point.returnDistance(point1));
    }

    public static void fractionTests(){
        Fraction twoArgs = new Fraction(1, 2);
        Fraction oneArg = new Fraction(1);
        Fraction noArgs = new Fraction();
    }
}
