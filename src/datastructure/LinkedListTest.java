package datastructure;

public class LinkedListTest {


  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.append(99);
    list.append(11);
    list.append(22);

    list.getNode(2);
    list.getNode(1);
    list.getNode(0);
    list.getNode(3);

    list.append(55, 0);
    list.getNode(0);
    list.getNode(3);

    list.append(1000, 4);
    list.getNode(0);
    list.getNode(4);

    System.out.println(list);

    list.remove(3);
    System.out.println(list);

    list.remove(0);
    System.out.println(list);

    list.remove(2);
    System.out.println(list);

    list.remove(1);
    System.out.println(list);

    list.remove(0);
    System.out.println(list);

    list.append(99);
    list.append(11);
    list.append(22);
    list.append(55, 0);
    list.append(1000, 4);
    list.append(22);
    System.out.println(list);
    list.removeDups();
    System.out.println(list);
    list.append(1000);
    System.out.println(list);
    list.removeDups();
    System.out.println(list);


//    list.remove();
  }
}

class LinkedList {
  private Node head;
  private Node tail;
  private int size = 0;

  public void append(int data) {
    Node newNode = new Node(data);
    if (size == 0) {
      addFirst(newNode);
    } else {
      addLast(newNode);
    }
    size++;
  }

  public void append(int data, int index) {
    Node newNode = new Node(data);
    if (index == 0) {
      addFirst(newNode);
    } else {
      Node temp1 = getNode(index - 1);
      Node temp2 = temp1.next;
      temp1.next = newNode;
      newNode.next = temp2;
      if (newNode.next == null) {
        tail = newNode;
      }
    }
    size++;
  }

  private void addLast(Node newNode) {
    System.out.println("!!! addLast !!!");
    tail.next = newNode;
    tail = newNode;
  }

  private void addFirst(Node newNode) {
    System.out.println("!!! addFirst !!!");
    newNode.next = head;
    head = newNode;
    tail = newNode;
  }

  public void remove(int index) {
    if (index == 0) {
      Node firstNode = head;
      head = firstNode.next;
    } else if (index + 1 == size) {
      Node temp1 = getNode(index - 1);
      temp1.next = null;
      tail = temp1;
    } else {
      Node temp1 = getNode(index - 1);
      temp1.next = temp1.next.next;
    }
    size--;
  }

  public void removeDups() {
    Node node = head;
    for (int a = 0; a < size; a++) {
      Node temp = node.next;
      for (int b = 1; b < size; b++) {
        if (node.data == temp.data) {
          System.out.println("!! removeDups : " + b);
          remove(a);
        }
        if (temp.next == null) {
          break;
        } else {
          temp = temp.next;
        }
      }
      node = node.next;
    }
  }

  @Override
  public String toString() {
    return "LinkedList{" +
      "head=" + head +
      ", tail=" + tail +
      ", size=" + size +
      '}';
  }

  public Node getNode(int index) {
    if (index >= size) {
      System.out.println("ERROR");
      return null;
    }
    Node node = head;
    for (int loof = 0; loof < index; loof++) {
      node = node.next;
    }
    return node;
  }

  private class Node {
    int data;
    Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }

    @Override
    public String toString() {
      return "Node{" +
        "data=" + data +
        ", next=" + next +
        '}';
    }
  }
}