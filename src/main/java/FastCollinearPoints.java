import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;
/**
 * Created by jhunter on 3/8/17.
 */
public class FastCollinearPoints {
    private LineSegment[] segments;
    private Point[] sortedPoints;
    private double[] existingSlopes;

    public FastCollinearPoints(Point[] points) {

        if (points == null) {
            throw new NullPointerException("Point array cannot be null");
        }

        segments = new LineSegment[0];
        existingSlopes = new double[0];
        sortedPoints = Arrays.copyOf(points, points.length);

        Double currentSlope = null;
        Double previousSlope = null;
        int numberOfPointsInCurrentSegment = 2;
        Point currentEndpoint = null;

        for (int i = 0; i < points.length - 3; i++){
            Arrays.sort(sortedPoints, points[i].slopeOrder());

            for (int j = 0; j < points.length; j++){

                if (currentSlope == null) {
                    currentSlope = points[i].slopeTo(sortedPoints[j]);
                } else {
                    previousSlope = currentSlope;
                    currentSlope = points[i].slopeTo(sortedPoints[j]);

                    if (currentSlope.equals(previousSlope)){
                        numberOfPointsInCurrentSegment += 1;
                        currentEndpoint = sortedPoints[j];
                    } else {

                        if (numberOfPointsInCurrentSegment > 3){

                            boolean exists = false;

                            for (int k = 0; k < existingSlopes.length; k++ ) {
                                if (existingSlopes[k] == previousSlope){
                                    exists = true;
                                }
                            }

                            numberOfPointsInCurrentSegment = 2;

                            if (exists){
                                j = points.length;
                                continue;
                            } else {
                                segments = Arrays.copyOf(segments, segments.length + 1);
                                segments[segments.length - 1] = new LineSegment(sortedPoints[i], currentEndpoint);

                                existingSlopes = Arrays.copyOf(existingSlopes, existingSlopes.length + 1);
                                existingSlopes[existingSlopes.length - 1] = previousSlope;
                            }

                        } else {
                            numberOfPointsInCurrentSegment = 2;
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
