public class ResizingArrayQueueOfChars {
  //private int first = 0;
  private int last  = 0;
  public ResizingArrayQueueOfChars(int n) {
    char[] a = new [n]; 
  }
  public static void isEmpty() {
    return a[0] == null;
  }
  public void enQueue(char c) {
    t[last] = c;
    //first++;
    last++;
  }
  public char deQueue() {
    char car = t[last];
    last--;
  }
}
