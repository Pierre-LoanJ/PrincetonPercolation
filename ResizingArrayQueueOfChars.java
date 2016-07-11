public class ResizingArrayQueueOfChars {
  private int first = 0;
  private int last  = 0;
  public ResizingArrayQueueOfChars(int n) {
    char[] a = new [n]; 
  }
  public static void isEmpty() {
    return a[first] == null;
  }
  public void enQueue(char c) {
    a[last] = c;
    last++;
  }
  public char deQueue() {
    char car = a[first];
    first++;
   return car;
  }
}
