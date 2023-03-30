package bruteForceSearch;

/*
 * 소수 찾기, level2 : https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * 1. 조합으로 숫자의 경우의 수를 찾고
 * 2. for문을 돌면서 나눠지는 숫자가 있는지 확인한다. (없으면 소수)
 *
 * 훔냐ㅑ 답안지 슥삭 했습니다.....
 * 슥삭한 블로그 : https://dding9code.tistory.com/18
 * 1. 소수를 판단하는 함수 + DFS로 숫자를 조합하는 함수를 구현한다.
 * */

import java.util.ArrayList;

public class pg_42839 {

	//	숫자 조합을 저장할 ArrayList
	static ArrayList<Integer> arr = new ArrayList<>();
	//	같은 숫자 중복을 확인하기 위한 배열
	static boolean[] check = new boolean[7];

	public int solution(String numbers) {
		int answer = 0;

		for (int i = 0; i < numbers.length(); i++) {
			dfs(numbers, "", i + 1);
		}

		for (int i = 0; i < arr.size(); i++) {
			if (prime(arr.get(i))) {
				answer++;
			}
		}

		return answer;
	}

	private void dfs(String numbers, String s, int m) {
		if (s.length() == m) {
			int num = Integer.parseInt(s);
			if (!arr.contains(num)) { // 이미 만들어진 숫자 거르기
				arr.add(num);
			}
		}
		for (int i = 0; i < numbers.length(); i++) {
			if (!check[i]) {
				check[i] = true;
				s += numbers.charAt(i);
				dfs(numbers, s, m);
				check[i] = false;
				s = s.substring(0, s.length() - 1);
			}
		}
	}

	private boolean prime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
