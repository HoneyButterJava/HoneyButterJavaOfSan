package bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14888 {

	static int N;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[] numbers;
	static int[] operators;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		numbers = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			numbers[i] = scan.nextInt();
		}
		operators = new int[5];
		for (int i = 1; i <= 4; i++) {
			operators[i] = scan.nextInt();
		}
	}

	static int calc(int num1, int num2, int operator) {
		if (operator == 1) {
			return num1 + num2;
		} else if (operator == 2) {
			return num1 - num2;
		} else if (operator == 3) {
			return num1 * num2;
		} else {
			return num1 / num2;
		}
	}

	static void rec_func(int k, int sum) {
		if (k == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		} else {
			for (int i = 1; i <= 4; i++) {
				if (operators[i] > 0) {
					operators[i]--;
					rec_func(k + 1, calc(sum, numbers[k + 1], i));
					operators[i]++;
				}
			}
		}
	}

	public static void main(String[] args) {
		input();
		rec_func(1, numbers[1]);
		System.out.println(max);
		System.out.println(min);
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
