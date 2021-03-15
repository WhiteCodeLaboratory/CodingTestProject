package algorithm.sort;

import java.util.NoSuchElementException;

// Quick 정렬 :
// 역순의 경우 부등호만 변경.
public class QuickSortMain {
  public static void main(String[] args) {
    int[] numbers = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};
    System.out.println("######### Start ");
    printSort(numbers);
    case1(numbers, 0, numbers.length - 1);
    System.out.println("######### complete ");
    printSort(numbers);
  }

  private static void case1(int[] numbers, int start, int end) {
    if (numbers.length == 0) {
      throw new NoSuchElementException();
    }
    if (start > end) {
      return;
    }

    int pointKey = start;
    int startIndex = start + 1;
    int endIndex = end;
    while (startIndex <= endIndex) {
      while (startIndex < numbers.length && numbers[pointKey] >= numbers[startIndex]) {
        startIndex++;
      }
      while (endIndex > 0 && numbers[pointKey] < numbers[endIndex]) {
        endIndex--;
      }
      if (startIndex >= endIndex) {
        int temp = numbers[pointKey];
        numbers[pointKey] = numbers[endIndex];
        numbers[endIndex] = temp;
      } else {
        int temp = numbers[startIndex];
        numbers[startIndex] = numbers[endIndex];
        numbers[endIndex] = temp;
      }
      printSort(numbers);
    }
    case1(numbers, start, endIndex - 1);
    case1(numbers, endIndex + 1, end);
  }

  private static void printSort(int[] numbers) {
    for (int number : numbers) {
      System.out.print(number + " ");
    }
    System.out.println("");
  }

}
