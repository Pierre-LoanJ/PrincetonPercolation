import java.util.Iterator;
import java.lang.Exception;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
private Node first, last;
private int size;

private class Node {
	Item item;
	Node next;
	Node previous;
}

public Deque() {} // construct an empty deque

	private class ListIterator implements Iterator<Item> {
		Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public Item next() {
			if (isEmpty()) throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	   }
	   
	
	   public boolean isEmpty() {
		   return first == null;
		}                // is the deque empty?
	   
	   public int size() {
		return size;
		}                        // return the number of items on the deque
	   
	
	public void addFirst(Item item) throws NullPointerException {
		   if (item == null) throw new java.lang.NullPointerException();
		   size++;
		   
		   boolean firstTime = false;
		   if (this.isEmpty()) {
			   firstTime = true;
		   }
		   Node oldFirst = this.first;
		   
		   this.first = new Node();
		   this.first.item = item;
		   this.first.next = oldFirst;
		   this.first.previous = null;
		   
		   
		   if (firstTime) {
			   this.last = this.first;
		   }
		   else {
			   oldFirst.previous = this.first;
		   }
	   }          // add the item to the front
	   
	   public void addLast(Item item) throws NullPointerException {  // enqueue()
		   if (item == null) throw new java.lang.NullPointerException();
		   size++;
		   Node oldLast = this.last;
		   
		   this.last = new Node();
		   this.last.item = item;
		   this.last.next = null;
		   if (oldLast != null) {
			   this.last.previous = oldLast;
			   oldLast.next = this.last;
		   }
		   
		   if (this.isEmpty()) {
			   this.first   = this.last;
		   }
	   }           // add the item to the end
	   
	public Item removeFirst() throws NoSuchElementException { // dequeue()
		   if (this.isEmpty()) {
				this.first = null;
				throw new java.util.NoSuchElementException();
			}
		   size--;
		   
		   Item val = this.first.item;
		   this.first = this.first.next;
		   if (!this.isEmpty()) this.first.previous = null;
		   return val;
		}                // remove and return the item from the front
	   
	   
	public Item removeLast() throws NoSuchElementException {
			if (this.isEmpty()) {
				this.last = null;
				throw new java.util.NoSuchElementException();
			}
			size--;
			Item val = this.last.item;
			this.last = this.last.previous;
			if (this.last != null) this.last.next = null;
			if (this.size() == 0) this.first = null;
			return val;
		}                 // remove and return the item from the end
	   
	   
	   public Iterator<Item> iterator() throws UnsupportedOperationException, NoSuchElementException {
		   return new ListIterator();}         // return an iterator over items in order from front to end
	   
	   public static void main(String[] args)  {
		   Deque<String> deck = new Deque<String>();
		   deck.addFirst("a");
		   deck.addFirst("b");
		   for (String s : deck) System.out.println(s); // deck.iterator().next()
	   }
	}
