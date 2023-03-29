package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class pg_64061 {

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int turn = moves.length;
		//		int[] bucket = new int[arrSize];
		Deque<Integer> bucket = new ArrayDeque<>();

		for (int i = 0; i < turn; i++) {
			int position = moves[i];
			int doll = findDoll(board, position);
			//			System.out.println(i + " | doll : " + doll);
			if (doll == 0) {
				continue;
			}
			if (!bucket.isEmpty() && bucket.peekLast() == doll) {
				bucket.removeLast();
				answer += 2;
			} else {
				bucket.addLast(doll);
				//				System.out.println("size : " + bucket.size());
			}
		}
		return answer;
	}

	private int findDoll(int[][] board, int position) {
		int arrSize = board.length;
		int doll = 0;

		for (int i = 0; i < arrSize; i++) {
			if (board[i][position - 1] != 0) { // 인형이 있으면
				doll = board[i][position - 1];
				board[i][position - 1] = 0;
				break;
			}
		}
		return doll;
	}

}
