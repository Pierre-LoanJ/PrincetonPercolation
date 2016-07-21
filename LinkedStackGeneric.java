public class LinkedStackGeneric<Type> {
	private Node first = null;
	
	private class Node {
		Type item;
		Node next;
	}
	public boolean isEmpty() { 
		return first == null;
	}
	public void push(Type arg) {
		Node oldfirst = first;
		first = new Node();
		first.item = arg;
		first.next = oldfirst;
	}
	public Type pop() {
		Type obj = first.item;
		first = first.next;
		return obj;
	}
}
/* l'astuce ici est de garder une référence sur le premier élément de la pile
 */
