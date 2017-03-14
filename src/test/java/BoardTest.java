import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jhunter on 3/14/17.
 */
public class BoardTest {

    int[][] blocks;
    Board board;

    @Before
    public void setUp() throws Exception {
        blocks = new int[3][3];
        board = new Board(blocks);
    }

    @Test
    public void testDimension() throws Exception {
        assertEquals(3, board.dimension());
    }
}
