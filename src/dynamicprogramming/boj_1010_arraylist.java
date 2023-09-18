package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1010_arraylist {

	static int testCase;
	static int testCases[][];
	static ArrayList<Integer>[] dp = new ArrayList[31];

	static void input() {
		FastReader scan = new FastReader();
		testCase = scan.nextInt();
		for (int i = 0; i < 31; i++) {
			dp[i] = new ArrayList<>();
		}
		testCases = new int[testCase][2];
		for (int i = 0; i < testCase; i++) {
			testCases[i][0] = scan.nextInt();
			testCases[i][1] = scan.nextInt();
		}
	}

	static void calcNumberOfCases() {
		dp[0].add(0);
		for (int j = 0; j < 31; j++) {
			dp[1].add(j);
		}
		for (int i = 2; i < 31; i++) {
			dp[i].add(0);
			for (int j = 1; j < 31 - i; j++) {
				dp[i].add(dp[i].get(j - 1) + dp[i - 1].get(j));
			}
		}
	}

	public static void main(String[] args) {
		input();

		calcNumberOfCases();
		for (int i = 0; i < testCase; i++) {
			System.out.println(dp[testCases[i][0]].get(testCases[i][1] - testCases[i][0] + 1));
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
