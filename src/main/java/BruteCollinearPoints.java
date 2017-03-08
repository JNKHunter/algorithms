/**
 * Created by jhunter on 3/7/17.
 */
public class BruteCollinearPoints {

    Point[] points;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException("Point array cannot be null");
        }

        for(Point point : points) {
            if (point == null ) {
                throw new NullPointerException("Point cannot be null");
            }
        }

        this.points = points;
    }

    public int numberOfSegments(){
        return 0;
    }

    public LineSegment[] segments(){
        return null;
    }
}
