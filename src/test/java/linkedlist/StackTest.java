package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 11/4/16.
 */
public class StackTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testPush() throws Exception {
        Stack<String> shakespeare = new Stack<>();
        shakespeare.push("To");
        shakespeare.push("Be");
        shakespeare.push("Or");
        shakespeare.push("Not");

        assertEquals("Not", shakespeare.pop());
        assertEquals("Or", shakespeare.pop());
        assertEquals("Be", shakespeare.pop());
        assertEquals("To", shakespeare.pop());
        assertEquals("To", shakespeare.pop());
    }

}