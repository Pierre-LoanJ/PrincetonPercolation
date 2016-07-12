public class ResizingArrayQueueOfChars {
	  private int first = 0;
	  private int last  = 0;
	  private char[] a;
	  public ResizingArrayQueueOfChars(int n) {
	    a = new char[n]; 
	  }
	  public char[] shift(char[] t) {
	  	char[] tShifted = new char[t.length];
	  	int oldFirst = first;
	  	for (int i = first; i < t.length; i++) {
	  		if (i > last) break;
	  		tShifted[i - first] = t[i];
	  	}
	  	first = first - oldFirst;
	  	last = last - oldFirst;
	  	return tShifted;
	  }
	  public char[] resize(char[] t) {
			int n = t.length;
			char[] tResized = new char [ 2 * n ];
			for (int i = 0; i < n; i++) {
		  		tResized[i] = t[i];
			}
			return tResized;
	  }
	  public boolean isEmpty() {
	    return last == 0;
	  }
	  public void enQueue(char c) {
	    if (last >= a.length) a = resize(a);
	    a[last] = c;
	    last++;
	  }
	  public char deQueue() {
	    if (isEmpty()) return Character.MIN_VALUE;
	    char c = a[first];
	    first++;
	    if (first >= a.length / 4) a = shift(a);
	    return c;
	   }
	  public static void main(String args[]) {
		ResizingArrayQueueOfChars queue = new ResizingArrayQueueOfChars(5);
		queue.enQueue('a');
		queue.enQueue('b');
		queue.enQueue('c');
		System.out.println(queue.deQueue());
	  }
	}
