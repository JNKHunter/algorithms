import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int n;
    private boolean[] sites;
    private int numOpenSites;
    private WeightedQuickUnionUF uf;

    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("N can not be less than or equal to zero");
        }

        this.n = n;
        uf = new WeightedQuickUnionUF((n * n + 2));
        sites = new boolean[(n * n) + 2];

        for (int i = 0; i < sites.length; i++) {
            sites[i] = false;
        }

        sites[0] = true;
        sites[sites.length - 1] = true;

        numOpenSites = 0;
    }

    public void open(int row, int col) {

        validate(row, col);

        if (isOpen(row, col)) {
            return;
        }

        int index = rowCol2ArrayIndex(row, col);
        sites[index] = true;
        numOpenSites++;


        boolean isTop = false;
        boolean isBottom = false;

        if (index > 0 && index <= n) {
            uf.union(0, index);
            isTop = true;
        }

        if ((index >= rowCol2ArrayIndex(n, 1)) && (index <= rowCol2ArrayIndex(n, n))) {
            uf.union(sites.length - 1, index);
            isBottom = true;
        }

        if (index % n != 1) {
            if (sites[index - 1]) {
               uf.union(index, index-1);
            }
        }

        if (index % n != 0) {
            if (sites[index + 1]) {
                uf.union(index, index + 1);
            }
        }

        if (!isTop) {
            if (sites[index - n]) {
                uf.union(index, index - n);
            }
        }

        if (!isBottom) {
            if (sites[index + n]) {
                uf.union(index, index + n);
            }
        }
    }

    private int rowCol2ArrayIndex(int row, int col) {
        return ((row - 1)* n) + col;
    }

    public int numberOfOpenSites() {
        return numOpenSites;
    }

    private void validate(int rowOrCol) {
        if (rowOrCol <= 0 || rowOrCol > this.n) {
            throw new IndexOutOfBoundsException("Row or column is out of grid bounds");
        }
    }

    private void validate(int row, int col) {
        validate(row);
        validate(col);
    }

    public boolean isOpen(int row, int col) {
        validate(row, col);
        return sites[rowCol2ArrayIndex(row, col)];
    }

    public boolean isFull(int row, int col) {
        validate(row, col);
        return uf.connected(rowCol2ArrayIndex(row, col), 0);
    }

    public boolean percolates() {
        return uf.connected(0, sites.length - 1);
    }
}