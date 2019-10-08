public class Point {
    int x;
    int y;

    public Point(int x, int y){
       this.x = x;
       this.y = y;
    }

    public double returnDistance(Point other){
        double distance = (this.x - other.x)^2 + (this.y - other.y)^2;
        return distance;
    }
}
