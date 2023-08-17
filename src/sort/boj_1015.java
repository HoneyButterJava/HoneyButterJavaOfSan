package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1015 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] P;
	static Element[] element;

	static void input() {
		N = scan.nextInt();
		element = new Element[N];
		P = new int[N];
		for (int i = 0; i < N; i++) {
			element[i] = new Element();
			element[i].num = scan.nextInt();
			element[i].idx = i;
		}
	}

	public static void main(String[] args) {
		input();

		Arrays.sort(element);
		for (int i = 0; i < N; i++) {
			P[element[i].idx] = i;
		}
		for (int i = 0; i < N; i++) {
			sb.append(P[i]).append(' ');
		}
		System.out.println(sb.toString());
	}

	static class Element implements Comparable<Element> {

		public int num, idx;

		@Override
		public int compareTo(Element other) {
			return num - other.num;
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


