import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jhunter on 3/15/17.
 */
public class Solver {




    private boolean isSolvable;

    // Initial solver
    private int moves = 0;
    private List<Board> gameTree;


    public Solver(Board initial) {

        isSolvable = false;

        if (initial == null) {
            throw new NullPointerException("Initial board can not be null");
        }

        Board previous = null;
        Board previousTwin = null;

        gameTree = new ArrayList<>();
        previous = null;

        Board searchNode = initial;
        Board searchNodeTwin = initial.twin();
        MinPQ<Board> queue = getQueue();
        MinPQ<Board> queueTwin = getQueue();

        while (!(searchNode.isGoal() || searchNodeTwin.isGoal())) {
            previous = searchNode;
            gameTree.add(searchNode);

            Iterable<Board> neighbors = searchNode.neighbors();

            for (Board neighbor : neighbors) {
                if (!neighbor.equals(previous)) {
                    queue.insert(neighbor);
                }
            }

            searchNode = queue.delMin();
            moves += 1;

            // Twin search
            previousTwin = searchNodeTwin;
            Iterable<Board> neighborsTwin = searchNodeTwin.neighbors();

            for (Board neighborTwin : neighborsTwin) {
                if (!neighborTwin.equals(previousTwin)) {
                    queueTwin.insert((neighborTwin));
                }
            }

            searchNodeTwin = queueTwin.delMin();
        }
        if (searchNode.isGoal()){
            gameTree.add(searchNode);
            isSolvable = true;
        } else {
            isSolvable = false;
            moves = -1;
            gameTree = null;

        }

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

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] blocks = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                blocks[i][j] = in.readInt();
        Board initial = new Board(blocks);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable())
            StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
