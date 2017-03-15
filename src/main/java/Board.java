import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jhunter on 3/14/17.
 */
public class Board {

    private int[][] blocks;
    private int dimension;
    private int[] zeroPosition;

    public Board(int[][] blocks) {
        this.blocks = blocks;
        dimension = blocks.length;

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] == 0) {
                    zeroPosition = new int[2];
                    zeroPosition[0] = i;
                    zeroPosition[1] = j;
                }
            }
        }
    }

    public Board twin() {
        int[][] twin = cloneBlocks();
        int randomRow1 = StdRandom.uniform(0, dimension());
        int randomCol1 = StdRandom.uniform(0, dimension());
        int randomRow2 = StdRandom.uniform(0, dimension());
        int randomCol2 = StdRandom.uniform(0, dimension());
        int tmp = twin[randomRow1][randomCol1];
        twin[randomRow1][randomCol1] = twin[randomRow2][randomCol2];
        twin[randomRow2][randomCol2] = tmp;
        return new Board(twin);
    }

    public int dimension() {
        return dimension;
    }

    public int hamming() {
        int count = 0;

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {

                // While we are not on the last block
                if (!(i == blocks.length-1 && j == blocks[blocks.length-1].length-1)) {

                    int expectedValue = (((blocks.length * i) + j) + 1);
                    if (blocks[i][j] != expectedValue) {
                        count += 1;
                    }
                }
            }
        }

        return count;
    }

    public int manhattan() {
        int count = 0;
        int expectedRow;
        int expectedCol;

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {

                if (blocks[i][j] != 0){

                    expectedRow = (blocks[i][j] - 1) / blocks.length;
                    expectedCol = (blocks[i][j] - 1) % blocks.length;

                    count += Math.abs(expectedRow - i) + Math.abs(expectedCol - j);

                }
            }
        }

        return count;
    }

    public boolean isGoal() {
        int expectedValue;
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                expectedValue = (((blocks.length * i) + j) + 1);
                if (blocks[i][j] != 0) {
                    if (blocks[i][j] != expectedValue) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean equals(Object y) {
        if (this.dimension() != ((Board) y).dimension()){
            return false;
        }

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                if (blocks[i][j] != ((Board) y).blocks[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public Iterable<Board> neighbors() {

        List<Board> neighbors = new ArrayList<>();

        if (!(zeroPosition[0] == 0)) {
            int[][] topNeighbor = cloneBlocks();
            topNeighbor[zeroPosition[0]][zeroPosition[1]] = topNeighbor[zeroPosition[0] - 1][zeroPosition[1]];
            topNeighbor[zeroPosition[0] - 1][zeroPosition[1]] = 0;
            neighbors.add(new Board(topNeighbor));

        }

        if (!(zeroPosition[0] == blocks.length-1)) {
            int[][] bottomNeighbor = cloneBlocks();
            bottomNeighbor[zeroPosition[0]][zeroPosition[1]] = bottomNeighbor[zeroPosition[0] + 1][zeroPosition[1]];
            bottomNeighbor[zeroPosition[0] + 1][zeroPosition[1]] = 0;
            neighbors.add(new Board(bottomNeighbor));
        }

        if (!(zeroPosition[1] == 0)) {
            int[][] leftNeighbor = cloneBlocks();
            leftNeighbor[zeroPosition[0]][zeroPosition[1]] = leftNeighbor[zeroPosition[0]][zeroPosition[1] - 1];
            leftNeighbor[zeroPosition[0]][zeroPosition[1] - 1] = 0;
            neighbors.add(new Board(leftNeighbor));
        }

        if (!(zeroPosition[1] == blocks.length-1)) {
            int[][] rightNeighbor = cloneBlocks();
            rightNeighbor[zeroPosition[0]][zeroPosition[1]] = rightNeighbor[zeroPosition[0]][zeroPosition[1] + 1];
            rightNeighbor[zeroPosition[0]][zeroPosition[1] + 1] = 0;
            neighbors.add(new Board(rightNeighbor));
        }

        return neighbors;
    }

    public String toString() {
        String outputString = "";

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                outputString += "\t" + blocks[i][j];
            }
            outputString += "\n";
        }

        return outputString;
    }

    private int[][] cloneBlocks() {
        int[][] tmpArray = new int[blocks.length][];

        for (int a = 0; a < blocks.length; a++) {
            tmpArray[a] = blocks[a].clone();
        }

        return tmpArray;
    }

}