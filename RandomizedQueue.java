import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] a;
	private int size = 10;
	private int pos = 0;
	
	private class ListIterator implements Iterator<Item>{
		private Item[] copy = a;
		private int num = pos;
		
		private ListIterator() {
		}
		
		@Override
		public boolean hasNext() {
				return num > 0;
		}
		
		@Override
		public Item next() {
			if (isEmpty()) throw new NoSuchElementException();
			int nextRandom = StdRandom.uniform(num);
			Item it = copy[nextRandom];
			swap(copy, nextRandom, num - 1);
			num--;
			return it;
		}
		
		private void swap(Item[] a, int nextR, int last) {
			Item temp = a[last];
			a[last] = a[nextR];
			a[nextR] = temp;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue() {
		  a = (Item[]) new Object[size]; 
	}
	
    public boolean isEmpty() {
	   return pos == 0;
   }
    
    public int size() {
		return pos;
    }

    public void enqueue(Item item) {
    	if (item == null) throw new java.lang.NullPointerException();
		if (size == pos) { 
			   a = resize(a);
		}
		   a[pos] = item;
		   pos++;
    }
    
	@SuppressWarnings("unchecked")
	private Item[] resize(Item[] t) {
		int n = t.length;
		
		Item[] tResized = (Item[]) new Object [ 2 * n ];
		for (int i = 0; i < n; i++) {
	  		tResized[i] = t[i];
		}
		size = 2 * n;
		return tResized;
  }
    
    public Item dequeue() { // remove and return a random item
    	if (this.isEmpty()) {
			throw new java.util.NoSuchElementException();
		}
    	int c = size();
    	int p = StdRandom.uniform(c);
    	Item val = a[p];
    	swap(a, p, pos - 1);
    	pos--;
		return val;
    }
    
    private void swap(Item[] a, int nextR, int last) {
		Item temp = a[last];
		a[last] = a[nextR];
		a[nextR] = temp;
	}
    
    public Item sample() { // get a random item (doesn't remove it)
    	if (this.isEmpty()) {
			throw new java.util.NoSuchElementException();
		} 
    	int c = this.size();
    	int p = StdRandom.uniform(c);
    	Item val = a[p];
    	return val;
   }
    
    public Iterator<Item> iterator() throws UnsupportedOperationException, NoSuchElementException {
    	return new ListIterator();}         // return an iterator over items in order from front to end
   
    public static void main(String[] args) {
    	RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
    	
    	for (int n = 0; n < 20; n++) {
    		rq.enqueue(n);
    	}
    	
    	for (int n = 0; n < 20; n++) {
    		System.out.println(rq.sample());
    	}
   }
}

