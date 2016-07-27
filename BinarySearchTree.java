/*
* tree data structure, not obviously perfectly balanced, this depends on the order keys are inserted
*/

/*
* efficient data structure to implement a priority queue which provides a convenient API such as delMax()
*
*/
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
    root = put(root, key, val);
  }
  private Node put(Node n, char key, int val) {
    if (this.root == null) {
      this.root = new Node(key, val);
    }
    else {
      while(n != null) {
        if      (n.key == key) n.val = val;
        else if (n.key <  key) n.right = put(n.right, key, val);
        else if (n.key >  key) n.left = put(n.left, key, val);
      }
      return n;
    }
  }
  public int get(int key) {
    
  }
  public static void main(String[] args) {
    BinarySearchTree t = new BinarySearchTree();
  }
}
