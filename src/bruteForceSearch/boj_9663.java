package bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//public class boj_9663 {
//
//	static int N;
//	static int ans;
//	static int[] col;
//
//	static void input() {
//		FastReader scan = new FastReader();
//		N = scan.nextInt();
//		col = new int[N + 1];
//	}
//
//	static boolean attackable(int r1, int c1, int r2, int c2) {
//		if (c1 == c2) {
//			return true;
//		}
//		if (r1 - c1 == r2 - c2) {
//			return true;
//		}
//		if (r1 + c1 == r2 + c2) {
//			return true;
//		}
//		return false;
//	}
//
//	static void rec_func(int row) {
//		if (row == N + 1) {
//			ans++;
//		} else {
//			for (int c = 1; c <= N; c++) {
//				boolean possible = true;
//				for (int i = 1; i <= row - 1; i++) {
//					if (attackable(row, c, i, col[i])) {
//						possible = false;
//						break;
//					}
//				}
//				if (possible) {
//					col[row] = c;
//					rec_func(row + 1);
//					col[row] = 0;
//				}
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		input();
//		rec_func(1);
//		System.out.println(ans);
//	}
//
//	static class FastReader {
//
//		BufferedReader br;
//		StringTokenizer st;
//
//		public FastReader() {
//			br = new BufferedReader(new InputStreamReader(System.in));
//		}
//
//		String next() {
//			while (st == null || !st.hasMoreElements()) {
//				try {
//					st = new StringTokenizer(br.readLine());
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			return st.nextToken();
//		}
//
//		int nextInt() {
//			return Integer.parseInt(next());
//		}
//	}
//}

public class boj_9663 {

	static int[] g_a = new int[15];
	static int[] g_slash = new int[32];
	static int[] g_bslash = new int[32];
	static int g_num = 0;        //경우의 수
	static int N;

	static int set(int i, int num) {
		for (int j = 0; j < num; j++) {
			if (g_a[j] == 0 && g_slash[j + i] == 0 && g_bslash[i + (num - 1) - j] == 0) {
				if (i == (num - 1)) {
					g_num++;
				} else {
					g_a[j] = g_slash[j + i] = g_bslash[i + (num - 1) - j] = 1;
					set(i + 1, num);
					g_a[j] = g_slash[j + i] = g_bslash[i + (num - 1) - j] = 0;
				}
			}
		}
		return (g_num);
	}

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
	}

	public static void main(String[] args) {
		input();

		System.out.println(set(0, N));
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