import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jhunter on 3/12/17.
 */
public class FastCollinearPoints {

    private Point[] sortedPoints;
    private LineSegment[] segments;
    private double[] slopes;
    private List<Double> existingSlopes;


    public FastCollinearPoints(Point[] points){

        if (points == null) {
            throw new NullPointerException("Point array cannot be null");
        }

        segments = new LineSegment[0];
        existingSlopes = new ArrayList<>();
        sortedPoints = Arrays.copyOf(points, points.length);
        slopes = new double[points.length];

        for (int i = 0; i < points.length; i++) {

            Arrays.sort(sortedPoints, points[i].slopeOrder());

            for (int j = 0; j < sortedPoints.length; j++) {
                slopes[j] = points[i].slopeTo(sortedPoints[j]);
            }

            int rightPointer = 1;
            int leftPointer = 0;

            while (rightPointer < slopes.length) {

                if (!(Double.compare(slopes[leftPointer], slopes[rightPointer]) == 0)) {

                    if ((rightPointer - 1) - leftPointer >= 2) {

                        Point biggest = points[i];
                        Point smallest = points[i];
                        for (int k = leftPointer; k <= rightPointer - 1; k++) {
                            if (biggest.compareTo(sortedPoints[k]) == -1) {
                                biggest = sortedPoints[k];
                            }

                            if (sortedPoints[k].compareTo(smallest) == -1) {
                                smallest = sortedPoints[k];
                            }
                        }

                        LineSegment segmentToAdd = new LineSegment(smallest, biggest);

                        boolean duplicate = false;
                        for (int l = 0; l < segments.length; l++){
                            if (segmentToAdd.toString().equals(segments[l].toString())){
                                duplicate = true;
                            }
                        }

                        if (!duplicate){
                            segments = Arrays.copyOf(segments, segments.length + 1);
                            segments[segments.length - 1] = new LineSegment(smallest,
                                    biggest);
                        }
                    }
                    leftPointer = rightPointer;
                }
                rightPointer += 1;
            }

            if ((rightPointer - 1) - leftPointer >= 2) {

                Point biggest = points[i];
                Point smallest = points[i];
                for (int k = leftPointer; k <= rightPointer - 1; k++) {
                    if (biggest.compareTo(sortedPoints[k]) == -1) {
                        biggest = sortedPoints[k];
                    }

                    if (sortedPoints[k].compareTo(smallest) == -1) {
                        smallest = sortedPoints[k];
                    }
                }

                LineSegment segmentToAdd = new LineSegment(smallest, biggest);

                boolean duplicate = false;
                for (int l = 0; l < segments.length; l++){
                    if (segmentToAdd.toString().equals(segments[l].toString())){
                        duplicate = true;
                    }
                }

                if (!duplicate){
                    segments = Arrays.copyOf(segments, segments.length + 1);
                    segments[segments.length - 1] = new LineSegment(smallest,
                            biggest);
                }
            }
        }
        int asdfadsf = 1;
    }

    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return segments;
    }
}
