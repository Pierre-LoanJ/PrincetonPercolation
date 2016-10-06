import edu.princeton.cs.algs4.StdIn;

public class Subset {
   public static void main(String[] args) {
	   //int k = Integer.parseInt(args[0]);
	   int k = 3;
	   int i = 0;
	   RandomizedQueue<String> rq = new RandomizedQueue<String>();
	   
	   String in = StdIn.readLine();
	   String[] a = in.split(" ");
	   for (int j = 0; j < a.length; j++) {
		   rq.enqueue(a[j]);
	   }
	   while ( k > rq.size()) {
		   k = StdIn.readInt();
	   }
	   while (i < k ) {
		   System.out.println(rq.dequeue());   
		   i++;
	   }
   }
}
