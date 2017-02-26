import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by jhunter on 2/25/17.
 */
public class DequeTest {

    private Deque<Integer> deque;
    private Iterator<Integer> iterator;

    @Before
    public void setUp(){
        deque = new Deque<Integer>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);

        iterator = deque.iterator();
    }

    @Test
    public void testRemoveFirst(){
        deque.addFirst(40);
        assertEquals(40, (int) deque.removeFirst());
    }

    @Test
    public void testRemoveLast(){
        assertEquals(30, (int) deque.removeLast());
    }

    @Test
    public void testIsEmptyRemovingLast(){
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        assertEquals(true, deque.isEmpty());
    }

    @Test
    public void testIsEmptyRemovingFirst(){
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        assertEquals(true, deque.isEmpty());
    }

    @Test
    public void testIsNotEmplty(){
        assertEquals(false, deque.isEmpty());
    }

    @Test
    public void testIsEmptyRemovingFirstAndLastAndAdding(){
        deque.addFirst(13);
        deque.addLast(15);
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        deque.removeFirst();
        deque.addFirst(15);
        deque.removeLast();
        deque.addLast(15);
        deque.removeLast();
        deque.removeFirst();
        assertEquals(true, deque.isEmpty());
    }

    @Test
    public void testSize(){
        deque.addLast(1);
        assertEquals(4, deque.size());
        deque.addFirst(2);
        assertEquals(5, deque.size());
        deque.addFirst(3);
        deque.addLast(3);
        deque.removeFirst();
        deque.removeLast();
        deque.addLast(1);
        deque.addFirst(2);
        assertEquals(7, deque.size());
    }

    @Test
    public void testIterator(){
        assertTrue(iterator.hasNext());
        iterator.next();
        iterator.next();
        iterator.next();
        assertFalse(iterator.hasNext());
    }

}
