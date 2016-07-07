public class LinkedQueueGeneric<Type> {
	private Node first, last;
	
	private class Node {
		Type item;
		Node next;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public void enqueue(Type item){
		Node oldlast = last;
		Node last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) first = last;
		else oldlast.next = last;
	}
	
	public Type dequeue(){
		if (isEmpty()) {
			last = null;
		}
		Type val = first.item;
		first = first.next;
		return val;
	}
	public static void main(String[] args) {
		}


}
