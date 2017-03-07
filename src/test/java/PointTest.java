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

    @Before
    public void setUp(){
        point  = new Point(1,1);
        zeroSlopePoint = new Point(5,1);
        zeroSlopePoint = new Point(5,1);
        infiniteSlopePoint = new Point (1,5);
        equalPoint = new Point(1, 1);
        originPoint = new Point(0,0);
    }


    @Test
    public void testSlopeTo() throws Exception {

    }

    @Test
    public void testCompareTo() throws Exception {
        assertEquals(0, point.compareTo(equalPoint));
        assertEquals(-1, point.compareTo(infiniteSlopePoint));
        assertEquals(1, point.compareTo(originPoint));
    }

}