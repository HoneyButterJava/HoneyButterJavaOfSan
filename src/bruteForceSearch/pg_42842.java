package bruteForceSearch;

/*
 * 완전탐색 level2
 * 카펫 :https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * 노란색의 가로 세로를 x, y | 갈색의 가로 세로를 x+2, y+2 로 두고 넓이를 이용한 방정식을 통해 해결
 * */

public class pg_42842 {

	public int[] solution(int brown, int yellow) {
		int x = 0;
		//         y = brownSum - x;
		int brownSum = (brown - 4) / 2;

		for (int i = 0; i < 2500; i++) {
			if (i * (brownSum - i) == yellow) {
				x = i;
				break;
			}
		}
		int[] answer = {brownSum + 2 - x, x + 2};
		return answer;
	}
}
