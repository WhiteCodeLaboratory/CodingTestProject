package algorithm.sort;

public class SelectionSortMain {

  // 선택 정렬 : 가장 작은값을 선택해서 가장 앞으로 보내는 정렬.
  // 등차 수열 N*(N+1)/2 = 55
  public static void main(String[] args) {
    int[] numbers = {5, 10, 1, 8, 7, 6, 4, 3, 2, 9};
    System.out.println("######### Start");
    printSort(numbers);
    int minIndex = 0;
    for (int a = 0; a < numbers.length; a++) {
      int min = numbers[a];
      for (int j = a; j < numbers.length; j++) {
        if (min > numbers[j]) {
          min = numbers[j];
          minIndex = j;
        }
      }
      if (numbers[a] != min) {
        int temp = numbers[a];
        numbers[a] = numbers[minIndex];
        numbers[minIndex] = temp;
      }
      System.out.println("######### select index " + (minIndex + 1));
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
