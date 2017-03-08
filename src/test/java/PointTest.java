import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jhunter on 3/6/17.
 */
public class PointTest {

    private Point point;
    private Point zeroSlopePoint;
    private Point infiniteSlopePoint;
    private Point equalPoint;
    private Point originPoint;
    private Point zeroSlopePointFurther;
    private Point highSlopePoint;
    private Point lowSlopePoint;

    @Before
    public void setUp(){
        point  = new Point(1,1);
        highSlopePoint = new Point(2, 10);
        lowSlopePoint = new Point(10, 2);
        zeroSlopePoint = new Point(5,1);
        zeroSlopePointFurther = new Point(10,1);
        infiniteSlopePoint = new Point (1,5);
        equalPoint = new Point(1, 1);
        originPoint = new Point(0,0);
    }


    @Test
    public void testSlopeTo() throws Exception {
        assertEquals(Double.POSITIVE_INFINITY, point.slopeTo(infiniteSlopePoint), 0.0f);
        assertEquals(Double.NEGATIVE_INFINITY, point.slopeTo(equalPoint), 0.0f);
        assertEquals(+0.0f, point.slopeTo(zeroSlopePoint), 0.0f);
        assertEquals(+1.0f, point.slopeTo(originPoint), 0.0f);
    }

    @Test
    public void testCompareTo() throws Exception {
        assertEquals(0, point.compareTo(equalPoint));
        assertEquals(-1, point.compareTo(infiniteSlopePoint));
        assertEquals(1, point.compareTo(originPoint));
    }

    @Test
    public void testComparator() throws Exception {
        assertEquals(0, point.slopeOrder().compare(zeroSlopePoint, zeroSlopePointFurther));
        assertEquals(1, point.slopeOrder().compare(highSlopePoint, lowSlopePoint));
        assertEquals(-1, point.slopeOrder().compare(lowSlopePoint, highSlopePoint));
    }

}