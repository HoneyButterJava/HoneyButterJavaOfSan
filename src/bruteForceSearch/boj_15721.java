package bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15721 {

	static int A, T, N;

	static void input() {
		FastReader scan = new FastReader();
		A = scan.nextInt();
		T = scan.nextInt();
		N = scan.nextInt();
	}

	public static void main(String[] args) {
		input();
		int[] count = {0, 0};
		int round = 1;

		while (count[N] != T) {
			if (count[0] + round + 3 < T) {
				count[0] += round + 3;
				count[1] += round + 3;
				round++;
				continue;
			}
			for (int i = 0; i < 4; i++) { // 번-데기-번-데기
				if (i % 2 == 0) {
					count[0]++;
				} else {
					count[1]++;
				}
				if (count[N] == T) {
					System.out.println((count[0] + count[1] - 1) % A);
					return;
				}
			}

			for (int i = 0; i < (round + 1) * 2; i++) { //번-번-데기-데기
				if (i < round + 1) {
					count[0]++;
				} else {
					count[1]++;
				}
				if (count[N] == T) {
					System.out.println((count[0] + count[1] - 1) % A);
					return;
				}
			}
			round++;
		}
		System.out.println(count[N] % A);
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
