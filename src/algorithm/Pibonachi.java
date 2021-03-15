package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Pibonachi {

  // 피보나치 수열 출력
  // An = an-1 + an-2
  // 1 1 2 3 5 8 13 21 34

  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(1, 2, 3, 0, 111, 10000000, 5, 99);
    int max = Collections.max(a);
    System.out.println(max);

    List<Integer> b = Arrays.asList(1, 2, 4, 3, 111, 5, 99);
    max = b.stream().max(Integer::compareTo).get();
    System.out.println(max);

    List<Integer> c = b;
    // 중앙값 구하기
    if (c.size() % 2 == 0) {
      System.out.println("짝수");
    } else {
      Collections.sort(c);
      System.out.println("중앙값" + c.get(c.size()/2));
    }
  }

}
