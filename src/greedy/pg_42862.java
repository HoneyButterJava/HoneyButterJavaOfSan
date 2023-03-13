package greedy;

// 체육복 : https://school.programmers.co.kr/learn/courses/30/lessons/42862

import java.util.Arrays;

public class pg_42862 {
	public static int solution(int n, int[] lost, int[] reserve) {
		int[] student = new int[n];
		Arrays.sort(lost);
		Arrays.sort(reserve);

		int answer = 0;
		int lostIndex = 0;
		int reserveIndex = 0;
		for (int i = 0; i < n; i++) {
			student[i] = 1;
			if (reserveIndex < reserve.length && reserve[reserveIndex] - 1 == i) {
				student[i] = 2;
				reserveIndex++;
			}
			if (lostIndex < lost.length && lost[lostIndex] - 1 == i) {
				student[i]--;
				lostIndex++;
			}
			if (student[i] > 0)
				answer++;
		}
		for (int i = 0; i < n ; i++)
			System.out.print(student[i] +" ");

		for (int i = 0; i < n; i++) {
			if (student[i] == 2) {
				if (i > 0 && student[i - 1] == 0) {
					student[i - 1]++;
				} else if (i < n - 1 && student[i + 1] == 0) {
					student[i + 1]++;
				} else {
					continue;
				}
				student[i]--;
				answer++;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int result = solution(5, new int[]{1, 2, 3}, new int[]{2, 3, 4});
		System.out.println("solution is " + result);
	}
}

//5	[2, 4]	[1, 3, 5]	5
//5	[2, 4]	[3]	4
//3	[3]	[1]	2