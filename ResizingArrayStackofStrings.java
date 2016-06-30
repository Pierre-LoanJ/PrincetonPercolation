public class ResizingArrayStackOfStrings {
	private String[] t;
	private int pos = 0;
	
	public ResizingArrayStackOfStrings(int n) {
		t = new String[n];
	}
	
	public boolean isFull(String[] tab) { return pos == tab.length; }
	
	public String[] resize() {
	  int n = t.length;
	  String[] tResized = new String [ 2 * n ];
	  for (i = 0; i < n; i++) {
	  	tResized[i] = t[i];
	    }
	    return tResized;
	}
	
	public boolean isEmpty() { return this.pos == 0; }
	
	public void push(String item) {
	  if (this.isFull(t)) t = resize(t);
		t[pos++] = item;
	}
	
	public String pop() {
		String val = t[pos];
		pos--;
		return val;
	}
	
	public static void main(String[] args) {
	  }
	}
