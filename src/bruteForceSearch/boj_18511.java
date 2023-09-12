package bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18511 {

	static int N, count;
	static int[] K;
	static int max = Integer.MIN_VALUE;
	static int num;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		count = scan.nextInt();
		K = new int[count];
		for (int i = 0; i < count; i++) {
			K[i] = scan.nextInt();
		}
	}

	static void findMostBigNumber() {
		if (num > N) {
			return;
		}
		max = Math.max(max, num);
		for (int i = 0; i < count; i++) {
			num = num * 10 + K[i];
			findMostBigNumber();
			num /= 10;
		}
	}

	public static void main(String[] args) {
		input();
		findMostBigNumber();
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
