package bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14501 {

	static int N;
	static int[] T, P;
	static int max = Integer.MIN_VALUE;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		T = new int[N + 1];
		P = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			T[i] = scan.nextInt();
			P[i] = scan.nextInt();
		}
	}

	static void rec_func(int k, int sum) {
		if (k == N + 1) {
			if (sum > max) {
				max = sum;
			}
		} else {
			if (k < N + 1) {
				rec_func(k + T[k], sum + P[k]);
				rec_func(k + 1, sum);
			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1, 0);
		System.out.println(max);
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
