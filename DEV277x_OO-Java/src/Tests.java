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
}
