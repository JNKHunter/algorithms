/**
 * Created by jhunter on 3/14/17.
 */
public class Board {

    private int[][] blocks;
    private int dimension;

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
        int count = 0;

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {

                //While we are not on the last block
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
        return null;
    }

    public String toString() {
        return this.toString();
    }

}
