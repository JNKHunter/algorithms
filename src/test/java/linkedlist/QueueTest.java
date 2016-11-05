package linkedlist;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 11/4/16.
 */
public class QueueTest {
    Queue<String> queue;

    @Before
    public void setUp() throws Exception {
        queue = new Queue<>();
        queue.enqueue("To");
        queue.enqueue("Be");
        queue.enqueue("Or");
        queue.enqueue("Not");
        queue.enqueue("To");
    }

    @Test
    public void testDequeue() throws Exception {
        queue.enqueue("Be");
        queue.dequeue();
        queue.dequeue();
        assertEquals("Or", queue.dequeue());
    }

    @Test
    public void testEach() throws Exception {
        for(String item: queue){
            assertTrue(item instanceof String);
        }
    }

}