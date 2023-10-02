package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1913 {

	static int N, wanted;
	static int[][] table;
	static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		wanted = scan.nextInt();
		table = new int[N][N];
	}

	static void direction(int dirIndex, int x, int y) {
		if (dirIndex == 0) {
			if (x <= 0) {
				dirIndex = 1;
			}
		} else if (dirIndex == 1) {
			if (x >= N - 1) {
				dirIndex = 2;
			}
		} else if (dirIndex == 2) {
			if (x >= N - 1) {
				dirIndex = 3;
			}
		} else if (dirIndex == 3) {
			if (x >= N - 1) {
				dirIndex = 0;
			}
		} else {
			System.out.println("not");
		}
	}

	public static void main(String[] args) {
		input();
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
