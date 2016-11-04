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
    public void testExpressionWithNoParenthesis() throws Exception{
        double result = DijkstrasTwoStack.evaluate("1+1");
        assertEquals(2, result, 0.001);
    }

}