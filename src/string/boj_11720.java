package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11720 {

	static int count;
	static String str;

	static void input() {
		FastReader scan = new FastReader();
		count = scan.nextInt();
		str = scan.next();
	}

	public static void main(String[] args) {
		input();

		int sum = 0;
		for (int i = 0; i < count; i++) {
			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		System.out.println(sum);
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
