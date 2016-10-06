import java.awt.Font;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;
    private int size;
    private int nCarre;
    private int virtualTop;
    private int virtualBottom;
    private int compteur;
    private int compteurFinal;
    private WeightedQuickUnionUF id;
    public Percolation(int n) {
        if (n <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        this.size = n;
        this.nCarre = n * n;
        this.compteur = 0;
        this.compteurFinal = 0;
        this.id = new WeightedQuickUnionUF(nCarre + 2);
        
        this.virtualTop = this.id.find(0);
        this.virtualBottom = this.id.find(nCarre + 1);
       
        this.grid = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                this.grid[i][j] = 0; // 0 = blocked
            }
        }
    }

    public void open(int i, int j) {
        if (i <= 0 || i > size || j <= 0 || j > size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        if (!this.isOpen(i, j)) {
            this.grid[i][j] = 1;
            if (i == 1) this.id.union(gridToId(i, j, size), this.virtualTop);
            // si on ouvre un top alors directement connecte a virtual top
            if (i == size) this.id.union(gridToId(i, j, size), this.virtualBottom);
            
            // si voisins les connecter ensemble
             int current = gridToId(i, j, size);
             int voisinLeft = 0;
             int voisinRight = 0;
             int voisinHaut = 0;
             int voisinBas = 0;
           if (i - 1 >= 1) {
              if (this.isOpen(i - 1, j)) {
                  voisinHaut = gridToId(i - 1, j, size);
                  this.id.union(current, voisinHaut);
                  compteur++;
               //   if (this.id.connected(current, voisinHaut)) this.grid[i][j] = 2;
                  
              }
           }
           if (i + 1 <= size) {
              if (this.isOpen(i + 1, j)) {
            	  voisinBas = gridToId(i + 1, j, size);
                  this.id.union(current, voisinBas);
                  compteur++;
               //  if (this.id.connected(current, voisinBas)) this.grid[i][j] = 2;
              }
           }
           if (j - 1 >= 1) {
              if (this.isOpen(i, j - 1)) {
            	  voisinLeft = gridToId(i, j - 1, size);
                  this.id.union(current, voisinLeft);
                  compteur++;
               //   if (this.id.connected(current, voisinLeft)) this.grid[i][j] = 2;
              }
           }
           if (j + 1 <= size) {
              if (this.isOpen(i, j + 1)) {
            	  voisinRight = gridToId(i, j + 1, size);
                   this.id.union(current, voisinRight);
                   compteur++;
                 //  if (this.id.connected(current, voisinRight)) this.grid[i][j] = 2;
              }
           }
        }
        
    }
    
    public boolean isOpen(int i, int j) {
        if (i <= 0 || i > size || j <= 0 || j > size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        boolean isOpen = false;
        if (this.grid[i][j] == 1) {
            isOpen = true;
              //System.out.println(" VOISIN AUSSI OPEN (ou ancien deja ouvert)");
        }
        return isOpen;
    }

    public boolean isFull(int i, int j) { // a site is full if it is open and connected to a top open site
        if (i <= 0 || i > size || j <= 0 || j > size) {
            throw new java.lang.IndexOutOfBoundsException();
        }
        boolean isFull = false;
        if (this.id.connected(gridToId(i, j, size),  this.virtualTop)) isFull = true;
       // if (this.grid[i][j] == 2) isFull = true;
        return isFull;
    }

    public boolean percolates() { // percolates if a bottom site is full
        boolean percolates = false;
        if (this.id.connected(this.virtualTop, this.virtualBottom)) {
        	percolates = true;
        	compteurFinal = compteur;
        }
        return percolates;
    }
     
    private static int gridToId(int i, int j, int n) { //translate i,j coordinates to an index in id[] 
      if (i <= 0 || j <= 0 || i > n || j > n) throw new IndexOutOfBoundsException();
        return n * (i - 1) + j;
        //test OK
    }
    // draw N-by-N percolation system
   /* public static void draw(Percolation perc, int N) {
        StdDraw.clear();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setXscale(-.05*N, 1.05*N);
        StdDraw.setYscale(-.05*N, 1.05*N);   // leave a border to write text
        StdDraw.filledSquare(N/2.0, N/2.0, N/2.0);

        // draw N-by-N grid
        int opened = 0;
        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                if (perc.isFull(row, col)) {
                    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                    opened++;
                }
                else if (perc.isOpen(row, col)) {
                    StdDraw.setPenColor(StdDraw.WHITE);
                    opened++;
                }
                else
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(col - 0.5, N - row + 0.5, 0.45);
            }
        }

        // write status text
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(.25*N, -N*.025, opened + " open sites");
        if (perc.percolates()) StdDraw.text(.75*N, -N*.025, "percolates");
        else                   StdDraw.text(.75*N, -N*.025, "does not percolate");

    }*/
    public static void main(String[] args) {
        //Monte Carlo
        int n = 50;
        int nCarre = 2500;
        int x, y;
        int count = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int topIndex = 0;
        int downIndex = 0;
        int currentIndex = 0;
        double sommeP = 0;
        double p;
        int time = 100;
        double moyenne;
        long finFor = 0;
        long debFor = 0;
        long deb = 0;
        long fin = 0;
        long sumFor = 0;
        
        // CODE DONNANT p* = 0.54 de moyenne
        deb = System.currentTimeMillis();
        for (int t = 0; t < time; t++) {
            count = 0;
            p = 0;
            Percolation name = new Percolation(n); // initialise all sites of the matrix as blocked
            WeightedQuickUnionUF id = new WeightedQuickUnionUF(nCarre + 3);
            int virtualTop = nCarre;
            int virtualBottom = nCarre + 1;
            //till percolates
            while (!name.percolates()) {
                //choose a random site and open it
                x = StdRandom.uniform(1, n + 1);
                y = StdRandom.uniform(1, n + 1);
                currentIndex = gridToId(x, y, n);
                //System.out.println("x="+x +" y="+y);    
                if (!name.isOpen(x, y)) {
                     name.open(x, y);
                     //if x,y is on top or bottom then connect it to virtual top/bottom
                     if (y == 0) {
                          id.union(currentIndex, virtualTop);
                     }
                     
                     if (y == n - 1) {
                          id.union(currentIndex, virtualBottom);
                     }
                     //left neighbour
                     if (y - 1 >= 1) {
                          if (name.isOpen(x, y - 1)) {
                               //System.out.println(" VOISIN GAUCHE ");
                               leftIndex = gridToId(x, y - 1, n);
                               //lcurrent = currentIndex;
                               if (!id.connected(currentIndex, leftIndex)) {
                                    id.union(currentIndex, leftIndex);
                                    count++;
                               }
                          }
                     }
                     //right neighbour                    
                     if (y + 1 < n + 1) {
                          if (name.isOpen(x, y + 1)) {
                               //System.out.println(" VOISIN DROITE ");
                               rightIndex = gridToId(x, y + 1, n);
                               //rcurrent = currentIndex;
                               if (!id.connected(currentIndex, rightIndex)) {
                                    id.union(currentIndex, rightIndex);
                                    count++;
                               } 
                          }
                     }
                     //top neighbour
                     if (x - 1 >= 1) {
                          if (name.isOpen(x - 1, y)) {
                               //System.out.println(" VOISIN TOP ");
                               topIndex = gridToId(x - 1, y, n);
                               //tcurrent = currentIndex;
                               if (!id.connected(currentIndex, topIndex)) {
                                    id.union(currentIndex, topIndex);
                                    count++;
                               } 
                          }
                     }
                     //down neighbour
                     if (x + 1 < n + 1) {
                          if (name.isOpen(x + 1, y)) {
                               //System.out.println(" VOISIN BAS ");
                               downIndex = gridToId(x + 1, y, n);
                               //dcurrent = currentIndex;
                               if (!id.connected(currentIndex, downIndex)) {
                                    id.union(currentIndex, downIndex);
                                    count++;
                               }
                          }
                     }
                     //is top connected to bottom
                     debFor = 0;
                     debFor = System.currentTimeMillis();
                     if (id.connected(virtualTop, virtualBottom))
                     finFor = 0;
                     finFor = System.currentTimeMillis();
                     sumFor += (finFor-debFor);
                }
            }
            fin = 0;
            fin = System.currentTimeMillis();
            p = (double) (count) / (double) (nCarre);
            System.out.println("p*=" + p);
            sommeP += p;
        }
        moyenne = sommeP / (double) (time);
        System.out.println("p* moyen =" + moyenne);
        long dTot = (fin - deb);
        double pCentFor = sumFor * 100 / dTot;
        System.out.println("FOR:" + sumFor + " ms");
        System.out.println("TOT:" + dTot + " ms");
        System.out.println("soit FOR prend" + pCentFor + " %");
    }
  }
