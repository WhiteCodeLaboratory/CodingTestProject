package stack;

import java.util.EmptyStackException;

public class StackArray {
  int size = 10;
  int[] stack = new int[size];
  int offset = 0;

  public int poll() {
    int item = stack[0] ;
    offset--;
    return item;
  }

  public int peek() {
    return stack[0];
  }

  public void push(int data) {
    if (isFull()) {
      throw new EmptyStackException();
    } else {
      offset++;
      stack[offset] = data;
    }
  }

  public boolean isFull() {
    return offset == size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public static void main(String[] args) {

  }

}
