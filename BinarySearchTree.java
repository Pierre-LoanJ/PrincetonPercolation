public class BinarySearchTree {
  private Node root;
  
  public class Node {
    private int val;
    private int key;
    private Node left;
    private Node right;
    
    public Node(int key, int val) {
      this.val = val;
      this.key = key;
    }
  }
  public void put(int key, int val) {
    if (this.root == null) {
      this.root = new Node(key, val);
    }
  }
  public int get(int key) {
    
  }
  public static void main(String[] args) {
    BinarySearchTree t = new BinarySearchTree();
  }
}
