import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by jhunter on 2/25/17.
 */
public class RandomizedQueueTest {

    RandomizedQueue<Integer> randomizedQueue;
    Iterator<Integer> iter;


    @Before
    public void setUp() {
        randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(3);
        randomizedQueue.enqueue(4);
        randomizedQueue.enqueue(5);
        randomizedQueue.enqueue(6);
        randomizedQueue.enqueue(7);
        randomizedQueue.enqueue(8);
        randomizedQueue.enqueue(9);

        iter = randomizedQueue.iterator();
    }

    @Test
    public void testSize(){
        assertEquals(9, randomizedQueue.size());
    }

/*    @Test
    public void testSample() throws Exception {
        System.out.println(randomizedQueue.sample());
    }*/

    @Test(expected = NullPointerException.class)
    public void testEnqueuWithNull() {
        randomizedQueue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testDequeueWithEmpty() {
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
    }

    @Test
    public void testIteratorHasNext(){
        boolean truthy = iter.hasNext();
        assertTrue(iter.hasNext());
    }

    @Test
    public void testIteratorHasNextEmpty(){
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        iter.next();
        assertFalse(iter.hasNext());
    }

}