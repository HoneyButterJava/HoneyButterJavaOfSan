package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2839 {

	static int N;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
	}

	public static void main(String[] args) {
		input();
		//		int count = 0;
		//		count = N / 5;
		//		N = N % 5;
		//		count = count + (N / 3);
		//		if (N % 3 == 0) {
		//			System.out.println(count);
		//		} else {
		//			System.out.println(-1);
		//		}

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
