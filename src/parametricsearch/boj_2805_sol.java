package parametricsearch;

import java.util.Scanner;

public class boj_2805_sol {

	static int N, M;
	static int[] A;

	static void input() {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = scanner.nextInt();
		}
	}

	static boolean determination(int H) {
		// H 높이로 나무들을 잘랐을 때, M 만큼을 얻을 수 있으면 true, 없으면 false를 return하는 함수
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			if (A[i] > H) {
				sum += A[i] - H;
			}
		}
		return sum >= M;
	}

	public static void main(String[] args) {
		long L = 0, R = 2000000000, ans = 0;

		input();

		while (L <= R) {
			int mid = (int) ((L + R) / 2);
			if (determination(mid)) {
				ans = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		System.out.println(ans);
	}
}
