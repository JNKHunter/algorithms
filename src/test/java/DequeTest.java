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

}
