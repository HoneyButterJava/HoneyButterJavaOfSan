package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_25305 {

	public static void main(String[] args) {
		FastReader scan = new FastReader();

		int N = scan.nextInt();
		int k = scan.nextInt();

		Integer[] score = new Integer[N];
		for (int i = 0; i < N; i++) {
			score[i] = scan.nextInt();
		}

		Arrays.sort(score, Collections.reverseOrder());

		System.out.println(score[k - 1]);

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
