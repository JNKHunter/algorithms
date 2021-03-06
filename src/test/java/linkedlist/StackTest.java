package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 11/4/16.
 */
public class StackTest {
    Stack<String> shakespeare;

    @Before
    public void setUp() throws Exception {
        shakespeare = new Stack<>();
        shakespeare.push("To");
        shakespeare.push("Be");
        shakespeare.push("Or");
        shakespeare.push("Not");
    }

    @Test
    public void testPop() throws Exception {
        assertEquals("Not", shakespeare.pop());
        assertEquals("Or", shakespeare.pop());
        assertEquals("Be", shakespeare.pop());
        assertEquals("To", shakespeare.pop());
    }

    @Test
    public void testIsEmpty() throws Exception {
        shakespeare.pop();
        shakespeare.pop();
        shakespeare.pop();
        shakespeare.pop();

        assertEquals(shakespeare.isEmpty(), true);
    }

    @Test
    public void testEach() throws Exception {
        for(String item: shakespeare){
            assertTrue(item instanceof String);
        }
    }
}