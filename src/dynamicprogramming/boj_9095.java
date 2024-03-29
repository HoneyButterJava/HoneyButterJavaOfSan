package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9095 {

	static int[] Dy;
	static StringBuilder sb = new StringBuilder();

	static void preprocess() {
		Dy = new int[15];
		// 초기값 구하기
		Dy[1] = 1;
		Dy[2] = 2;
		Dy[3] = 4;
		// 점화식을 토대로 Dy 배열 채우기
		for (int i = 4; i <= 11; i++) {
			Dy[i] = Dy[i - 1] + Dy[i - 2] + Dy[i - 3];
		}
	}

	static void pro() {
		FastReader scan = new FastReader();
		int T = scan.nextInt();
		for (int tt = 1; tt <= T; tt++) {
			int N = scan.nextInt();
			sb.append(Dy[N]).append('\n');
		}
		System.out.print(sb);
	}

	public static void main(String[] args) {
		preprocess();
		pro();
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
