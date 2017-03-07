import java.util.Comparator;

/**
 * Created by jhunter on 3/6/17.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(){

    }

    public void drawTo(Point that){

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public int compareTo(Point that){
        return 0;
    }

    public double slopeTo(Point that){
        return 0.0f;
    }

    public Comparator<Point> slopeOrder(){
        return new Comparator<Point>() {
            @Override
            public int compare(Point point, Point t1) {
                return 0;
            }
        };
    }
}
