/**
 * Created by jhunter on 3/14/17.
 */
public class Board {

    int[][] blocks;
    int dimension;

    public Board(int[][] blocks) {
        this.blocks = blocks;
        dimension = blocks.length;
    }

    public Board twin() {
        return null;
    }

    public int dimension() {
        return dimension;
    }

    public int hamming() {
        return 0;
    }

    public int manhattan() {
        return 0;
    }

    public boolean isGoal() {
        return false;
    }

    public boolean equals(Object y) {
        return false;
    }

    public Iterable<Board> neighbors() {
        return null;
    }

    public String toString() {
        return this.toString();
    }

}
