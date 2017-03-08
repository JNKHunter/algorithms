import java.util.Arrays;

/**
 * Created by jhunter on 3/7/17.
 */
public class BruteCollinearPoints {

    private Point[] points;
    private LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new NullPointerException("Point array cannot be null");
        }

        for (Point point : points) {
            if (point == null) {
                throw new NullPointerException("Point cannot be null");
            }
        }

        this.points = points;

        double slopeij;
        double slopeik;
        double slopeil;

        segments = new LineSegment[0];

        for (int i = 0; i < points.length - 3; i++){
            for (int j = i+1; j < points.length - 2; j++){
                for (int k = j+1; k < points.length - 1; k++){
                    for (int l = k+1; l < points.length; l++){
                       slopeij = points[i].slopeTo(points[j]);
                       slopeik = points[i].slopeTo(points[k]);
                       slopeil = points[i].slopeTo(points[l]);

                       if ((slopeij == slopeik) && (slopeij == slopeil)){
                           segments = Arrays.copyOf(segments, segments.length + 1);
                           segments[segments.length - 1] = new LineSegment(points[i], points[l]);
                       }
                    }
                }
            }
        }
    }

    public int numberOfSegments(){
        return segments.length;
    }

    public LineSegment[] segments(){
        return segments;
    }
}
