package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2750 {

	public static void main(String[] args) {
		FastReader scan = new FastReader();

		int N = scan.nextInt();
		int[] number = new int[N];
		for (int i = 0; i < N; i++) {
			number[i] = scan.nextInt();
		}

		Arrays.sort(number);

		for (int i = 0; i < N; i++) {
			System.out.println(number[i]);
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
