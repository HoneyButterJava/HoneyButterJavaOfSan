package bruteForceSearch;

// 모의고사 : https://school.programmers.co.kr/learn/courses/30/lessons/42840
/*
 * 1. 와 진짜 이거 일도 감이 안왘ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
 * 2. 에 뭐부터 해야하는거즤.......
 * 3. 흙흙흑흐긓ㄹ르르 멀어지는 네이버
 * 4.
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class pg_42840 {

	int[] first = {1, 2, 3, 4, 5};
	int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
	int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

	public int[] solution(int[] answers) {
		int problem = answers.length;
		int[] solve = {0, 0, 0};

		for (int i = 0; i < problem; i++) {
			if (answers[i] == first[i % 5]) {
				solve[0]++;
			}
			//			second를 위한 if
			if (answers[i] == second[i % 8]) {
				solve[1]++;
			}
			if (answers[i] == third[i % 10]) {
				solve[2]++;
			}
		}
		int max = Arrays.stream(solve).max().getAsInt();
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			if (solve[i] == max) {
				ans.add(i + 1);
			}
		}

		return ans.stream().mapToInt(i -> i).toArray();
	}

}
