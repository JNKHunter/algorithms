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
    private Point sTest1;
    private Point sTest2;
    private Point sTest3;
    private Point sTest4;
    private Point sTest5;
    private Point sTest6;
    private Point sTest7;
    private Point sTest8;
    private Point sTest9;
    private Point sTest10;
    private Point sTest11;
    private Point sTest12;

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

        // Segments test
        // Straight line
        sTest1 = new Point(1,1);
        sTest2 = new Point(2,2);
        sTest3 = new Point(3,3);
        sTest4 = new Point(4,4);
        sTest4 = new Point(5,5);

        //non straight line
        sTest5 = new Point(30,2);
        sTest6 = new Point(52,5);
        sTest7 = new Point(92,9);
        sTest8 = new Point(190,10);

        sTest9 = new Point(1,2);
        sTest10 = new Point(2,4);
        sTest11 = new Point(3, 6);
        sTest12 = new Point(4, 8);
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

    @Test
    public void testSegments() throws Exception {
        Point[] linearPoints = {sTest1, sTest2, sTest3, sTest4, sTest5,
                sTest6, sTest7, sTest8, sTest9, sTest10, sTest11, sTest12};
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(linearPoints);
        assertEquals(2,bruteCollinearPoints.numberOfSegments());
    }

    @Test
    public void testFastSegments() throws Exception {
        Point[] linearPoints = {sTest1, sTest2, sTest3, sTest4, sTest5,
                sTest6, sTest7, sTest8, sTest9, sTest10, sTest11, sTest12};

        FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(linearPoints);
        assertEquals(2, fastCollinearPoints.numberOfSegments());
    }

}