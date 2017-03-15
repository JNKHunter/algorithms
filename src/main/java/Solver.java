import edu.princeton.cs.algs4.MinPQ;

import java.util.Comparator;

/**
 * Created by jhunter on 3/15/17.
 */
public class Solver {

    private int moves = 0;

    private MinPQ<Board> queue;

    public Solver(Board initial) {
        if (initial == null) {
            throw new NullPointerException("Initial board can not be null");
        }
        queue = new MinPQ<>(0, new Comparator<Board>() {
            @Override
            public int compare(Board board, Board t1) {

                if (board.manhattan() + moves > t1.manhattan() + moves) return 1;
                if (board.manhattan() + moves < t1.manhattan() + moves) return -1;

                return 0;
            }
        });
        queue.insert(initial);
    }

    public boolean isSolvabale() {
        return false;
    }

    public int moves() {
        return moves;
    }

    public Iterable<Board> solution() {
        return null;
    }
}
