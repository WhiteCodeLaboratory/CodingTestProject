package algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionMain {
  public static void main(String[] args) {
    question1();
  }

  // 문제
  // N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
  //
  // 입력
  // 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다.
  // 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
  //
  //출력
  //첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
  public static void question1() {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();
    if (count == 0 || count > 1000) {
      return;
    }
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      int input = sc.nextInt();
      if (input > 1000) {
        return;
      }
      boolean dup = false;
      for (int number : numbers) {
        if (number == input) {
          dup = true;
          break;
        }
      }
      if (!dup) {
        numbers.add(input);
      }

    }
    // 오름차순 정렬
    // 선택정렬 (가장 작은 값을 선택해서 앞으로 보내는 정렬)
    for (int i = 0; i < numbers.size(); i++) {
      int min = numbers.get(i);
      int minIndex = i;
      for (int j = i; j < numbers.size(); j++) {
        if (min > numbers.get(j)) {
          min = numbers.get(j);
          minIndex = j;
        }
      }
      int temp = numbers.get(i);
      numbers.set(i, numbers.get(minIndex));
      numbers.set(minIndex, temp);
    }
    printSort(numbers);
  }

  private static void printSort(List<Integer> numbers) {
    for (int number : numbers) {
      System.out.println(number);
    }
  }
}
