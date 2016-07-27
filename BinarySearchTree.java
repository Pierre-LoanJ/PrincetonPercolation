/*
* tree, not obviously perfectly balanced, (this depends on the order keys are inserted)
* used to implement efficient symbol table data structure
* we talk about explicit tree data structure as we use node objects to link the data inside the tree
*/

public class BinarySearchTree {
  private Node root;
  
  public class Node {
    private int val;
    private char key;
    private Node left;
    private Node right;
    
    public Node(char key, int val) {
      this.val = val;
      this.key = key;
    }
  }
  public void put(char key, int val) {
    root = put(root, key, val);
  }
  private Node put(Node n, char key, int val) {
    if (root == null) return new Node(key, val);
    else {
      if      (n.key == key) n.val   = val;
      else if (n.key <  key) n.right = put(n.right, key, val);
      else if (n.key >  key) n.left  = put(n.left, key, val);
      return n;
    }
  }
  public Integer get(char key) {
    Node x = root;
    while (x != null) {
      if      (x.key == key) return x.val;
      else if (x.key <  key) x = x.right;
      else if (x.key >  key) x = x.left;
    }
    return null;
  }
  public void delete(char key) {
    
  }
  public static void main(String[] args) {
    BinarySearchTree t = new BinarySearchTree();
  }
}
