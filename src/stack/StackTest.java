package stack;

public class StackTest {
  // pop = 마지막 데이터 가지고 오면서 삭제
  // push = 새로운 데이터 삽입
  // peek = 맨마지막 데이터 보기
  // isEmpty = 빈값 체크

  static class Stack<T> {
    private Node<T> top;

    class Node<T> {
      private T data;
      private Node<T> next;

      public Node(T data) {
        this.data = data;
      }
    }

    public T pop() {
      T item = top.data;
      top = top.next;
      return item;
    }

    public void push(T item) {
      Node<T> node = new Node<>(item);
      top.next = top;
      top = node;
    }

    public T peek() {
      return top.data;
    }

    boolean isEmpty() {
      return top == null;
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.peek());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
    System.out.println(stack.pop());
    System.out.println(stack.isEmpty());
  }

}
