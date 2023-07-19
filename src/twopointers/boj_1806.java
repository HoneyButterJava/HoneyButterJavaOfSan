package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1806 {

	static FastReader scan = new FastReader();

	static int N, S;
	static int[] A;

	static void input() {
		N = scan.nextInt();
		S = scan.nextInt();
		A = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = scan.nextInt();
		}
	}

	public static void main(String[] args) {
		input();

		int R = 0, sum = 0, ans = N + 1;
		for (int L = 1; L <= N; L++) {
			sum -= A[L - 1];

			while (R + 1 <= N && sum < S) {
				sum += A[++R];
			}

			if (sum >= S) {
				ans = Math.min(ans, R - L + 1);
			}
		}

		if (ans == N + 1) {
			ans = 0;
		}
		System.out.println(ans);
	}

	static class FastReader {

		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
