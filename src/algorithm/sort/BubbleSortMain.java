package algorithm.sort;

public class BubbleSortMain {

  // 버블정렬 : 옆에 있는 값과 비교해서 더 작은 값을 앞으로 보내는 방식. 큰 값이 점점 뒤로 간다.
  // 가장 느리다.
  public static void main(String[] args) {
    int[] numbers = {5, 10, 1, 8, 7, 6, 4, 3, 2, 9};
    System.out.println("######### Start ");
    printSort(numbers);
    for (int a = 0; a < numbers.length; a++) {
      // 버블정렬의 경우 뒤부터 정렬이 되기 때문에 뒷부분부터 줄여 나간다.
      for (int ii = 0; ii < numbers.length - (a + 1); ii++) {
        if (numbers[ii] > numbers[ii + 1]) {
          int temp = numbers[ii];
          numbers[ii] = numbers[ii + 1];
          numbers[ii + 1] = temp;
        }
      }
      System.out.println("######### select index " + (a));
      printSort(numbers);
    }
    System.out.println("######### complete ");
    printSort(numbers);
  }

  private static void printSort(int[] numbers) {
    for (int number : numbers) {
      System.out.print(number + " ");
    }
    System.out.println();
  }
}
