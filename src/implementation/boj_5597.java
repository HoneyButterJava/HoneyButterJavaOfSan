package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5597 {

	static boolean[] student = new boolean[30];

	static void input() {
		FastReader scan = new FastReader();
		for (int i = 0; i < 30; i++) {
			int number = scan.nextInt();
			student[number - 1] = true;
		}
	}

	public static void main(String[] args) {
		input();
		for (int i = 0; i < 30; i++) {
			if (student[i] == false) {
				System.out.println(i + 1);
			}
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
