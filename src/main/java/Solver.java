import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jhunter on 3/15/17.
 */
public class Solver {

    private int moves = 0;
    private Board previous;

    private MinPQ<Board> queue;
    private List<Board> gameTree;

    public Solver(Board initial) {

        Board searchNode;

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

        gameTree = new ArrayList<>();

        previous = null;
        searchNode = initial;

        while (!searchNode.isGoal()) {
            previous = searchNode;
            gameTree.add(searchNode);

            List<Board> neighbors = (ArrayList<Board>) searchNode.neighbors();

            for (Board neighbor : neighbors) {
                if (!neighbor.equals(previous)) {
                    queue.insert(neighbor);
                }
            }

            searchNode = queue.delMin();
            moves += 1;
        }
        gameTree.add(searchNode);
    }

    public boolean isSolvabale() {
        return false;
    }

    public int moves() {
        return moves;
    }

    public Iterable<Board> solution() {
        return gameTree;
    }
}
