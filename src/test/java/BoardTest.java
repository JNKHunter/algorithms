import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jhunter on 3/14/17.
 */
public class BoardTest {

    int[][] blocks;
    private int[][] blocks4x4;
    private int[][] blocksNotEqual;
    Board board;
    Board board4x4;
    private Board board4x4Copy;
    private Board boardNotEqual;

    @Before
    public void setUp() throws Exception {
        blocks = new int[][] {{8,1,3},{4,0,2},{7,6,5}};
        blocksNotEqual = new int[][] {{8,1,2},{4,0,3},{7,6,5}};
        blocks4x4 = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,0},{13,14,15,0}};


        board = new Board(blocks);
        boardNotEqual = new Board(blocksNotEqual);
        board4x4 = new Board(blocks4x4);
        board4x4Copy = new Board(blocks4x4);
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
        assertTrue(board4x4.isGoal());
        assertFalse(board.isGoal());
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(board4x4.equals(board4x4Copy));
        assertFalse(board.equals(boardNotEqual));
    }

    @Test
    public void outout() throws Exception {
        // System.out.println(board.toString());
        // System.out.println(board4x4.toString());
        List<Board> neighbors = (ArrayList<Board>) board4x4.neighbors();

        for(Board board : neighbors) {
            System.out.println(board);
        }
    }
}
