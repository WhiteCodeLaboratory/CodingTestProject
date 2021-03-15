package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
 */
public class PracticeTest {

  public static void main(String[] args) {
    System.out.println(new PracticeTest().solution(new int[]{1, 2, 3, 4, 5}));
    System.out.println(new PracticeTest().solution(new int[]{1, 3, 2, 4, 2}));
  }

  public int[] solution(int[] answers) {
    Map<Integer, List<Integer>> userMap = new HashMap<>();
    userMap.put(1, Arrays.asList(1, 2, 3, 4, 5));
    userMap.put(2, Arrays.asList(2, 1, 2, 3, 2, 4, 2, 5));
    userMap.put(3, Arrays.asList(3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

    int userCount = 0;
    int tempUserNumber = 0;

    List<Integer> answerList = new ArrayList<>();
    for (Map.Entry<Integer, List<Integer>> user : userMap.entrySet()) {
      if (tempUserNumber == 0) {
        tempUserNumber = user.getKey();
        userCount = getUser3CorrectCount(answers, user.getValue());
        answerList.add(user.getKey());
      } else {
        int tempUserCount = getUser3CorrectCount(answers, user.getValue());
        if (userCount == tempUserCount) {
          answerList.add(user.getKey());
        } else if (userCount < tempUserCount) {
          answerList.clear();
          answerList.add(user.getKey());
        }
      }
    }
    if (answerList.isEmpty()) {
      return null;
    } else {
      return answerList.stream().mapToInt(value -> value).toArray();
    }

  }

  private int getUser3CorrectCount(int[] answers, List<Integer> user3) {
    int correctCount = 0;
    for (int i = 0; i < answers.length; i++) {
      if (answers[i] == user3.get(i % user3.size())) {
        correctCount++;
      }
    }
    return correctCount;
  }
}
