import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jhunter on 3/7/17.
 */
public class BruteCollinearPoints {

    private Point[] points;
    private LineSegment[] segments;
    private int numberOfSegments;

    public BruteCollinearPoints(Point[] points) {

        numberOfSegments = 0;

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

        List<Point> segmentPoints;

        segments = new LineSegment[0];

        boolean duplicate = false;
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicate points not allowed");
                }

                for (int k = j+1; k < points.length; k++) {
                    if (points[i].compareTo(points[k]) == 0) {
                        throw new IllegalArgumentException("Duplicate points not allowed");
                    }

                    if (points[j].compareTo(points[k]) == 0) {
                        throw new IllegalArgumentException("Duplicate points not allowed");
                    }

                    for (int l = k+1; l < points.length; l++) {

                        if (points[i].compareTo(points[l]) == 0) {
                            throw new IllegalArgumentException("Duplicate points not allowed");
                        }


                        if (points[j].compareTo(points[l]) == 0) {
                            throw new IllegalArgumentException("Duplicate points not allowed");
                        }

                        if (points[k].compareTo(points[l]) == 0) {
                            throw new IllegalArgumentException("Duplicate points not allowed");
                        }

                       slopeij = points[i].slopeTo(points[j]);
                       slopeik = points[i].slopeTo(points[k]);
                       slopeil = points[i].slopeTo(points[l]);



                       if ((slopeij == slopeik) && (slopeij == slopeil)) {
                           segmentPoints = new ArrayList<>();
                           segmentPoints.add(points[i]);
                           segmentPoints.add(points[j]);
                           segmentPoints.add(points[k]);
                           segmentPoints.add(points[l]);

                           segmentPoints.sort(new Comparator<Point>() {
                               @Override
                               public int compare(Point point, Point t1) {
                                   return point.compareTo(t1);
                               }
                           });

                           segments = Arrays.copyOf(segments, segments.length + 1);
                           segments[segments.length - 1] = new LineSegment(segmentPoints.get(0), segmentPoints.get(segmentPoints.size()-1));

                           numberOfSegments += 1;
                       }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return numberOfSegments;
    }

    public LineSegment[] segments() {
        return segments;
    }
}
