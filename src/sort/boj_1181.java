package sort;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class boj_1181 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N;
	static String[] a;

	static void input() {
		N = scan.nextInt();
		a = new String[N];
		for (int i = 0; i < N; i++) {
			a[i] = scan.next();
		}
	}

	public static void main(String[] args) {
		input();

		Arrays.sort(a, new MyComparator());
		for (int i = 0; i < N; i++) {
			if (i == 0 || a[i].compareTo(a[i - 1]) != 0) {
				sb.append(a[i]).append('\n');
			}
		}
		System.out.println(sb.toString());
	}

	static class MyComparator implements Comparator<String> {

		@Override
		public int compare(String lhs, String rhs) {
			if (lhs.length() != rhs.length()) {
				return lhs.length() - rhs.length();
			}
			return lhs.compareTo(rhs);
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
