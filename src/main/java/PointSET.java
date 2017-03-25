import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

import java.util.Comparator;
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
        if (rect == null) {
            throw new NullPointerException("Rect Cannot Be Null");
        }
        return null;
    }

    public Point2D nearest(Point2D p) {
        return null;
    }
}
