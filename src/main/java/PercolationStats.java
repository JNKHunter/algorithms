import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by jhunter on 2/12/17.
 */
public class PercolationStats {
    // perform trials independent experiments on an n-by-n grid

    private Percolation percolation;
    private int numTrials;
    private double mean;
    private double[] trialRuns;
    private double stddev;

    public PercolationStats(int n, int trials){

        numTrials = trials;
        double sumOfOpenSites = 0;
        double curPercent = 0;
        trialRuns = new double[trials];
        double sumOfSquares = 0;

        for(int i = 1; i <= trials; i++){
            percolation = new Percolation(n);

            while(!percolation.percolates()){
                percolation.open(StdRandom.uniform(1,n+1),StdRandom.uniform(1, n+1));
            }
            int numopen = percolation.numberOfOpenSites();

            curPercent = ((double)percolation.numberOfOpenSites())/(n*n);
            trialRuns[i-1] = curPercent;
            sumOfOpenSites = sumOfOpenSites + curPercent;
        }

        mean = (double)sumOfOpenSites / (double)trials;

        for(Double value : trialRuns){
            sumOfSquares = sumOfSquares + Math.pow((value - mean), 2);
        }

        stddev = sumOfSquares/(trials - 1);
    }

    // sample mean of percolation threshold
    public double mean(){
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return Math.sqrt(stddev);
    }

    // low  endpoint of 95% confidence interval
    //public double confidenceLo()

    // high endpoint of 95% confidence interval
    //public double confidenceHi()

    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(2,10000);
        System.out.println("Mean\t" + stats.mean());
        System.out.println("stddev:\t" + stats.stddev());
    }
}
