import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
   private double[] a;
   private int numberOfTimes;
   //private Percolation perf;
   private int count;
   public PercolationStats(int n, int t) {
       if (n <= 0 || t <= 0) {
		   throw new java.lang.IllegalArgumentException();
	   }
	   a = new double[t];
	   numberOfTimes = 0;
	   count = 0;
       for (int i = 0; i < t; i++) {
           Percolation perform = new Percolation(n);
           if (perform.percolates()) a[i] = count;
           numberOfTimes++;
       }
    }     // perform T independent experiments on an N-by-N grid
   public double mean() {
       double mean = StdStats.mean(a);
       //mean = this.perf.compteurFinal / numberOfTimes;
       return mean;
   }
   // sample mean of percolation threshold
   public double stddev() {
       double stddev = StdStats.stddev(a);
       return stddev;
   }
   // sample standard deviation of percolation threshold
   public double confidenceLo() {
       double confidenceLo = mean() - stddev();
       return confidenceLo;
       
   }
   // low  endpoint of 95% confidence interval
   public double confidenceHi() {
       double confidenceHi = mean() + stddev();
       return confidenceHi;
   }
   // high endpoint of 95% confidence interval

   public static void main(String[] args) {
       String N = args[0];
       String T = args[1];
       int n = Integer.parseInt(N);
       int t = Integer.parseInt(T);
       PercolationStats stats = new PercolationStats(n, t);
   }   // test client (described below)
}
