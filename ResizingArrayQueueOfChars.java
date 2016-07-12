public class ResizingArrayQueueOfChars {
  private int first = 0;
  private int last  = 0;
  public ResizingArrayQueueOfChars(int n) {
    char[] a = new [n]; 
  }
  public char[] shift(char[] t) {
  	char [] tShifted = new char[t.length];
  	for (int i = j; i < t.length; i++) {
  		if (i > last) break;
  		t[i - first] = t[i];
  		t[i] = null;
  	}
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
  public static boolean isEmpty() {
    return a[first] == null;
  }
  public void enQueue(char c) {
    if (a.length >= last) a = resize(a);
    a[last] = c;
    last++;
  }
  public char deQueue() {
    if (!iSEmpty()) {
    	char c = a[first];
    	first++;
    	if (first >= a.length / 4) a = shift(a);
    	return c;
    }
  }
}
