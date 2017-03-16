import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jhunter on 3/14/17.
 */
public class Board {

    private int[][] blocks;
    private int dimension;
    private int[] zeroPosition;

    public Board(int[][] blocks) {
        dimension = blocks.length;
        this.blocks = cloneBlocks(blocks);


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
        int randomRow1;
        int randomCol1;
        int randomRow2;
        int randomCol2;

        randomRow1 = randomRow2 = randomCol1 = randomCol2 = 0;

        while (randomRow2 == randomRow1 && randomRow2 != zeroPosition[0] && randomRow1 != zeroPosition[0]) {
            randomRow1 = StdRandom.uniform(0, dimension());
            randomRow2 = StdRandom.uniform(0, dimension());
        }

        while (randomCol2 == randomCol1 && randomCol2 != zeroPosition[1] && randomCol1 != zeroPosition[1]) {
            randomCol1 = StdRandom.uniform(0, dimension());
            randomCol2 = StdRandom.uniform(0, dimension());
        }


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

                if (blocks[i][j] != 0) {

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

        if (y == null) {
            return false;
        }

        if (this.dimension() != ((Board) y).dimension()) {
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
        StringBuffer outputString = new StringBuffer();

        outputString.append(dimension + "\n");

        String outputFormatFirst = "%" + (dimension-1) + "d";
        String outputFormatRest = "%" + dimension + "d";

        for (int i = 0; i < blocks.length; i++) {

            for (int j = 0; j < blocks[i].length; j++) {
                if (j == 0){
                    outputString.append(String.format("%2d", blocks[i][j]));
                } else {
                    outputString.append(String.format("%3d", blocks[i][j]));
                }

            }
            outputString.append("\n");
        }

        return outputString.toString();
    }

    private int[][] cloneBlocks() {
        return cloneBlocks(blocks);
    }

    private int[][] cloneBlocks(int[][] gameBlocks) {
        int[][] tmpArray = new int[dimension][dimension];

        for (int i = 0; i < gameBlocks.length; i++) {
            for (int j = 0; j < gameBlocks[i].length; j++) {
                tmpArray[i][j] = gameBlocks[i][j];
            }
        }
        return tmpArray;
    }

}