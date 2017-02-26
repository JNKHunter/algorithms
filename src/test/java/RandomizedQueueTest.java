import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jhunter on 2/25/17.
 */
public class RandomizedQueueTest {

    RandomizedQueue<Integer> randomizedQueue;

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
    }

    @Test
    public void testSize(){
        assertEquals(9, randomizedQueue.size());
    }

    @Test
    public void testSample() throws Exception {
        System.out.println(randomizedQueue.sample());
    }

    @Test
    public void testDequeue() throws Exception {
        randomizedQueue.dequeue();
        randomizedQueue.dequeue();
        assertEquals(3, (int) randomizedQueue.dequeue());
    }

}