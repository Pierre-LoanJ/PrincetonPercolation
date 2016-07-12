public class ResizingArrayStackofStrings {
	private String[] t;
	private int pos = 0;
	
	public ResizingArrayStackofStrings(int n) {
		t = new String[n];
	}
	
	public boolean isFull(String[] tab) { return pos == tab.length; }
	
	public String[] resize(String[] t) {
		int n = t.length;
		String[] tResized = new String [ 2 * n ];
		for (int i = 0; i < n; i++) {
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
		String val = t[--pos];
		return val;
	}
	
	public static void main(String[] args) {
		ResizingArrayStackofStrings stack = new ResizingArrayStackofStrings(3);
		System.out.println(stack.t.length);
		stack.push("a");
		stack.push("b");
		stack.push("c");
		System.out.println(stack.t.length);
		stack.push("d");
		System.out.println(stack.t.length);
	}
}
