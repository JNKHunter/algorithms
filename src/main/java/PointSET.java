import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by jhunter on 3/21/17.
 */
public class PointSET {

    private TreeSet<Point2D> point2DS;
    private int count;

    public PointSET() {
        count = 0;
        point2DS = new TreeSet<>(new Comparator<Point2D>() {
            @Override
            public int compare(Point2D point2D, Point2D t1) {
                return point2D.compareTo(t1);
            }
        });
    }

    public boolean isEmpty() {
        return(count == 0);
    }

    public int size() {
        return count;
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Point Cannot Be Null");
        }

        point2DS.add(p);
        count += 1;
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Point Cannot Be Null");
        }
        return(point2DS.contains(p));
    }

    public void draw() {

    }

    public Iterable<Point2D> range(RectHV rect) {

        List<Point2D> points = new ArrayList<>();

        if (rect == null) {
            throw new NullPointerException("Rect Cannot Be Null");
        }

        for (Point2D point : point2DS) {
            if (rect.contains(point)) {
                points.add(point);
            }
        }
        return points;
    }

    public Point2D nearest(Point2D p) {
        Point2D closest= null;

        for (Point2D point : point2DS) {

            if (closest != null) {
                if (p.distanceTo(point) < p.distanceTo(closest)) {
                    closest = point;
                }
            } else {
                closest = point;
            }

        }
        return closest;
    }
}
