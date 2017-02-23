import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {

    private int t = 0;
    private double[] trialRuns;

    public PercolationStats(int n, int trials) {

        this.t = trials;

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Number of cols or trials can not be zero");
        }

        double sumOfOpenSites = 0;
        double curPercent;
        trialRuns = new double[trials];

        for (int i = 1; i <= trials; i++) {
            Percolation percolation = new Percolation(n);

            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(1, n+1), StdRandom.uniform(1, n+1));
            }

            curPercent = ((double) percolation.numberOfOpenSites())/(n*n);
            trialRuns[i-1] = curPercent;
            sumOfOpenSites = sumOfOpenSites + curPercent;
        }
    }

    public double mean() {
        return StdStats.mean(trialRuns);
    }

    public double stddev() {
        return StdStats.stddev(trialRuns);
    }

    public double confidenceLo() {
        return mean() - ((1.96*stddev())/Math.sqrt(this.t));
    }

    public double confidenceHi() {
        return mean() + ((1.96*stddev())/Math.sqrt(this.t));
    }

    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        StdOut.println("mean\t\t\t\t\t= " + stats.mean());
        StdOut.println("stddev\t\t\t\t\t= " + stats.stddev());
        StdOut.println("95% confidence interval = [" + stats.confidenceLo() + ", " + stats.confidenceHi() + "]");
    }
}