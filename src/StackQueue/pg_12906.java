package StackQueue;
import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
// level 1 - 같은 숫자는 싫어

public class pg_12906 {

  public int[] solution(int []arr) {
    ArrayList<Integer> arrTmp = new ArrayList<>();

    arrTmp.add(arr[0]);
    for (int i = 1; i < arr.length; i++) {
      if (arr[i - 1] != arr[i])
        arrTmp.add(arr[i]);
    }

    int []answer = arrTmp.stream()
            .mapToInt(i -> i)
            .toArray();

    return answer;
  }
}
