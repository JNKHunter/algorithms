import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jhunter on 3/14/17.
 */
public class BoardTest {

    int[][] blocks;
    private int[][] blocks4x4;
    Board board;
    Board board4x4;

    @Before
    public void setUp() throws Exception {
        blocks = new int[][] {{8,1,3},{4,0,2},{7,6,5}};
        blocks4x4 = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};


        board = new Board(blocks);
        board4x4 = new Board(blocks4x4);
    }

    @Test
    public void testDimension() throws Exception {
        assertEquals(3, board.dimension());
    }

    @Test
    public void testHamming() throws Exception {
        assertEquals(5, board.hamming());
    }

    @Test
    public void testManhattan() throws Exception {
        assertEquals(10, board.manhattan());
        assertEquals(0, board4x4.manhattan());
    }

    @Test
    public void testIsGoal() throws Exception {
        //assertTrue(board4x4.isGoal());
        assertFalse(board.isGoal());
    }
}
