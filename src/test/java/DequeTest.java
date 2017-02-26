import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by jhunter on 2/25/17.
 */
public class DequeTest {

    private Deque<Integer> deque;

    @Before
    public void setUp(){
        deque = new Deque<Integer>();
        deque.addFirst(10);
        deque.addLast(20);
        deque.addLast(30);
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

}
