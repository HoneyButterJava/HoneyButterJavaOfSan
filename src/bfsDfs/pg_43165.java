package bfsDfs;

// 타겟넘버 : https://school.programmers.co.kr/learn/courses/30/lessons/43165

public class pg_43165 {
	int count = 0;

	public int solution(int[] numbers, int target) {
		dfs(numbers, 0, target, 0);
		int answer = this.count;
//		전역변수 사용

		return answer;
	}

	public void dfs(int[] numbers, int depth, int target, int result){
		if (depth == numbers.length) {
//	모든 숫자를 다 사용해야 하기 떄문에 깊이가 끝까지 들어갔는지 확인한다.
			if (target == result) {
				this.count++;
			}
			return;
		}
		dfs(numbers, depth+1, target, result + numbers[depth]);
//	앞에 + 일 때
		dfs(numbers, depth+1, target, result - numbers[depth]);
//	앞에 - 일 때
	}
}
