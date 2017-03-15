import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jhunter on 3/15/17.
 */
public class SolverTest {

    private int[][] blocks1Move;
    private int[][] blocks2Move;
    private Solver solver2Move;
    private Solver solver1Move;
    private Solver solver3Move;
    private int[][] blocks3Move;

    @Before
    public void setUp() throws Exception {
        blocks1Move = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,0,15}};
        blocks2Move = new int[][] {{1,2,3,4},{5,6,7,0},{9,10,11,8},{13,14,15,12}};
        blocks3Move = new int[][] {{1,2,3,0},{5,6,7,4},{9,10,11,8},{13,14,15,12}};

        solver1Move = new Solver(new Board(blocks1Move));
        solver2Move = new Solver(new Board(blocks2Move));
        solver3Move = new Solver(new Board(blocks3Move));
    }

    @Test
    public void testSolver() throws Exception {
        assertEquals(1, solver1Move.moves());
        assertEquals(2, solver2Move.moves());
        assertEquals(3, solver3Move.moves());
    }
}
