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
    private MinPQ<Board> queueTwin;
    private List<Board> gameTree;
    private boolean isSolvable;

    public Solver(Board initial) {

        isSolvable = true;

        if (initial == null) {
            throw new NullPointerException("Initial board can not be null");
        }

        queue = getQueue();
        gameTree = new ArrayList<>();
        previous = null;
        Board searchNode = initial;

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

    private MinPQ<Board> getQueue() {
        return new MinPQ<>(0, new Comparator<Board>() {
            @Override
            public int compare(Board board, Board t1) {

                if (board.manhattan() + moves > t1.manhattan() + moves) return 1;
                if (board.manhattan() + moves < t1.manhattan() + moves) return -1;

                return 0;
            }
        });
    }

    public boolean isSolvable() {
        return isSolvable;
    }

    public int moves() {
        return moves;
    }

    public Iterable<Board> solution() {
        return gameTree;
    }
}
