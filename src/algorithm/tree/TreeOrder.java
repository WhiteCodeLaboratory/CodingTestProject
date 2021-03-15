package algorithm.tree;

public class TreeOrder {

  //       (1)
  //   (2)   (3)
  //(4)(5)
  public static void main(String[] args) {
    TreeOrder treeOrder = new TreeOrder();
    Node n1 = treeOrder.makeTree(null, null, 4);
    Node n2 = treeOrder.makeTree(null, null, 5);
    Node n3 = treeOrder.makeTree(n1, n2, 2);
    Node n4 = treeOrder.makeTree(null, null, 3);
    Node n5 = treeOrder.makeTree(n3, n4, 1);

    System.out.println("### inOrder ###");
    treeOrder.inOrder(n5);
    System.out.println("### preOrder ###");
    treeOrder.preOrder(n5);
    System.out.println("### postOrder ###");
    treeOrder.postOrder(n5);
  }

  private Node root;

  public void inOrder(Node node) {
    if (node != null) {
      inOrder(node.left);
      System.out.println(node.data);
      inOrder(node.right);
    }
  }

  public void preOrder(Node node) {
    System.out.println(node.data);
    inOrder(node.left);
    inOrder(node.right);
  }

  public void postOrder(Node node) {
    inOrder(node.left);
    inOrder(node.right);
    System.out.println(node.data);
  }

  public Node makeTree(Node left, Node right, int data) {
    return new Node(data, left, right);
  }

  // InOrder
  // PreOrder
  // PostOrder

  class Node {
    private Node left;
    private Node right;
    private int data;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

  }


}
