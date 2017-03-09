import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;
/**
 * Created by jhunter on 3/8/17.
 */
public class FastCollinearPoints {
    private LineSegment[] segments;
    private Point[] sortedPoints;

    public FastCollinearPoints(Point[] points) {

        if (points == null) {
            throw new NullPointerException("Point array cannot be null");
        }

        segments = new LineSegment[0];
        int numCollinear = 0;
        int pointer = 1;
        boolean tryNext = true;
        int counter = 0;

        Double currentSlope = null;
        Double previousSlope = null;
        int numberOfPointsInCurrentSegment = 2;
        Point currentEndpoint = null;

        for (int i = 0; i < points.length - 3; i++){
            sortedPoints = Arrays.copyOf(points, points.length);
            Arrays.sort(sortedPoints, points[i].slopeOrder());

            for (int j = i+1; j < points.length; j++){
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
                            LineSegment segmentToAdd = new LineSegment(sortedPoints[i], currentEndpoint);

                            for (LineSegment segment : segments) {
                                if (segment.toString().equals(segmentToAdd.toString())) {
                                    exists = true;
                                }
                            }

                            if (exists) {
                                continue;
                            }
                            segments = Arrays.copyOf(segments, segments.length + 1);
                            segments[segments.length - 1] = new LineSegment(sortedPoints[i], currentEndpoint);
                            numberOfPointsInCurrentSegment = 2;

                        } else {
                            currentSlope = null;
                            previousSlope = null;
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
