package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1010_array {

	static int testCase;
	static int testCases[][];
	static int dp[][] = new int[31][31];

	static void input() {
		FastReader scan = new FastReader();
		testCase = scan.nextInt();
		testCases = new int[testCase][2];
		for (int i = 0; i < testCase; i++) {
			testCases[i][0] = scan.nextInt();
			testCases[i][1] = scan.nextInt();
		}
	}

	static void calcNumberOfCases() {
		for (int j = 1; j < 31; j++) {
			dp[1][j] = j;
		}
		for (int i = 2; i < 31; i++) {
			for (int j = i; j < 31; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
			}
		}
	}

	public static void main(String[] args) {
		input();

		calcNumberOfCases();
		for (int i = 0; i < testCase; i++) {
			System.out.println(dp[testCases[i][0]][testCases[i][1]]);
		}
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
