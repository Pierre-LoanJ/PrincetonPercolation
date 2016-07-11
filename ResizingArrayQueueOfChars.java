public class ResizingArrayQueueOfChars {
  private int first = 0;
  private int last  = 0;
  public ResizingArrayQueueOfChars(int n) {
    char[] a = new [n]; 
  }
  public String[] resize(char[] t) {
		int n = t.length;
		char[] tResized = new char [ 2 * n ];
		for (int i = 0; i < n; i++) {
	  		tResized[i] = t[i];
		}
		return tResized;
  }
  public static boolean isEmpty() {
    return a[first] == null;
  }
  public void enQueue(char c) {
    if (a.length >= last) a = resize(a);
    a[last] = c;
    last++;
  }
  public char deQueue() {
    char car = a[first];
    first++;
   return car;
  }
}
