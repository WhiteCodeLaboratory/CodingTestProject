package algorithm.sort;

public class InsertSortMain {

  // 삽입 정렬 : 각 숫자를 적절한 위치에 삽입하는 방법. 필요할때만 위치를 변경.
  // ex> 다음의 숫자들을 오름차순으로 정렬하는 프로그램을 작성하세요.
  public static void main(String[] args) {
    //int[] numbers = {5, 10, 1, 8, 7, 6, 4, 3, 2, 9};
    // int[] numbers = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};
    int[] numbers = {26, 5, 37, 1, 61, 11, 59, 15, 48, 19};
    System.out.println("######### Start ");
    printSort(numbers);
    case1(numbers);
  }

  private static void case1(int[] numbers) {
    int count = 0;
    int temp;
    // +1 로 비교 하므로 length에서 -1 해줌.
    for (int i = 0; i < numbers.length - 1; i++) {
      int j = i;
      System.out.println("######### select index " + (j));
      printSort(numbers);
      while (j >= 0 && numbers[j] > numbers[j + 1]) {
        temp = numbers[j];
        numbers[j] = numbers[j + 1];
        numbers[j + 1] = temp;
        j--;
        count++;
      }

    }
    System.out.println("######### complete count ::" + count);
    printSort(numbers);
  }

  private static void printSort(int[] numbers) {
    for (int number : numbers) {
      System.out.print(number + " ");
    }
    System.out.println();
  }

}
