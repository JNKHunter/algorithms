import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Created by jhunter on 2/10/17.
 */
public class Percolation {

    private int n;
    private boolean sites[];
    private int numOpenSites;
    private WeightedQuickUnionUF uf;


    public Percolation(int n) {
        if(n <= 0){
            throw new IllegalArgumentException("N can not be less than or equal to zero");
        }

        this.n = n;
        uf = new WeightedQuickUnionUF((n * n + 2));
        sites = new boolean[(n * n) + 2];

        for(int i = 0; i < sites.length; i++){
            sites[i] = false;
        }

        //Set top virtual site and bottom virtual site to open
        sites[0] = true;
        sites[sites.length - 1] = true;

        numOpenSites = n * n;
    }

    public int getNumSites(){
        return sites.length - 2;
    }



    public void open(int row, int col){
        //If site is already open, return
        validate(row, col);
        if(isOpen(row,col)){
            return;
        }

        int index = rowCol2ArrayIndex(row, col);
        sites[index] = true;
        numOpenSites--;


        boolean isTop = false;
        boolean isBottom = false;

        //If site is in the top row, connect it to the top n node sites[0]
        if(index > 0 && index <= n){
            uf.union(0, index);
            isTop = true;
        }

        //If site is in the bottom row, connect it to the bottom n node sites[length - 1]
        if((index >= rowCol2ArrayIndex(n,1)) && (index <= rowCol2ArrayIndex(n, n))){
            uf.union(sites.length - 1, index);
            uf.union(sites.length - 1, index);
            isBottom = true;
        }

        //If site has adjacent open sites, connect them
        //If site is not on the left edge
        if(index % n != 1){
            if(sites[index - 1]){
               uf.union(index, index-1);
            }
        }

        //If site is not on the right edge
        if(index % n != 0){
            if(sites[index + 1]){
                uf.union(index, index + 1);
            }
        }

        //If site is not on the top edge
        if(!isTop){
            if(sites[index - n]){
                uf.union(index, index - n);
            }
        }

        //If site is not on the bottom edge
        if(!isBottom){
            if(sites[index + n]){
                uf.union(index, index + n);
            }
        }

    }

    public int rowCol2ArrayIndex(int row, int col){
        return ((row - 1)* n) + col;
    }

    public WeightedQuickUnionUF getUf(){
        return uf;
    }

    public int numberOfOpenSites(){
        return numOpenSites;
    }

    private void validate(int rowOrCol){
        if(rowOrCol < 0 || rowOrCol > this.n){
            throw new IndexOutOfBoundsException("Row or column is out of grid bounds");
        }
    }

    private void validate(int row, int col){
        validate(row);
        validate(col);
    }

    public boolean isOpen(int row, int col){
        return sites[rowCol2ArrayIndex(row, col)];
    }

    public boolean isFull(int row, int col){

        return uf.connected(rowCol2ArrayIndex(row, col), 0);
    }

    public boolean percolates(){
        return uf.connected(0, sites.length - 1);
    }
}
