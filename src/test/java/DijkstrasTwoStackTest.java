import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 11/4/16.
 */
public class DijkstrasTwoStackTest {


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSingleParenthesis() throws Exception{
        double result = DijkstrasTwoStack.evaluate("(1+1)");
        assertEquals(2, result, 0.001);
    }

    @Test
    public void testTwoStatements() throws Exception{
        double result = DijkstrasTwoStack.evaluate("((1+2)+(2+3))");
        assertEquals(8, result, 0.001);
    }

    @Test
    public void testThreeStatements() throws Exception{
        double result = DijkstrasTwoStack.evaluate("(((1+2)+(2+3))*3)");
        assertEquals(24, result, 0.001);
    }

    @Test
    public void testFourStatements() throws Exception{
        double result = DijkstrasTwoStack.evaluate("((((1+2)+(2+3))*3)/8)");
        assertEquals(3, result, 0.001);
    }

}