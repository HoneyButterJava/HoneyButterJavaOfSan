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
//		여러 배열을 함께 봐야하기때문에 인덱스를 따로 둠.
		for (int i = 0; i < n; i++) {
			student[i] = 1;

//			reserve였어도 lost면 개수를 빼야하기 때문에 reserve에 대한 값을 먼저 적용하고 lost를 적용했습니다.
//			둘다 확인해야 하기 때문에 그냥 조건에만 맞으면 확인하도록 if로 나눴습니다.
			if (reserveIndex < reserve.length && reserve[reserveIndex] - 1 == i) {
				student[i] = 2;
				reserveIndex++;
			}
			if (lostIndex < lost.length && lost[lostIndex] - 1 == i) {
				student[i]--;
				lostIndex++;
			}
//			기본적으로 지금 체육복을 1개 이상 가지고 있으면 체육복을 입을 수 있기 떄문에 answer up
			if (student[i] > 0)
				answer++;
		}

//		이제 체육복을 안가져온 불량 학생들에게 빌려줍니다. 빌린 학생들은 answer up 할겁니다.
		for (int i = 0; i < n; i++) {
//		지금 체육복이 2개다? 그럼 빌려줄 애가 있는지 앞에부터 확인해봅니다.
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