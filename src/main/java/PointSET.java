import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;

/**
 * Created by jhunter on 3/21/17.
 */
public class PointSET {

    public PointSET() {

    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 0;
    }

    public void insert(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Point Cannot Be Null");
        }
    }

    public boolean contains(Point2D p) {
        if (p == null) {
            throw new NullPointerException("Point Cannot Be Null");
        }
        return false;
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
