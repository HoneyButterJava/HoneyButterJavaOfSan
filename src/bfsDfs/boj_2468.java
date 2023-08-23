package bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2468 {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	static int maxRain = Integer.MIN_VALUE;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = scan.nextInt();
				if (map[i][j] > maxRain) {
					maxRain = map[i][j];
				}
			}
		}
	}

	static int dfs(int x, int y, int rain) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];

			if (nx < 1 || ny < 1 || nx > N || ny > N) {
				continue;
			}
			if (visited[nx][ny]) {
				continue;
			}
			if (map[nx][ny] > rain) {
				dfs(nx, ny, rain);
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		input();
		int max = 0;
		for (int rain = 0; rain <= maxRain; rain++) {
			visited = new boolean[N + 1][N + 1];

			int count = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!visited[i][j] && map[i][j] > rain) {
						count += dfs(i, j, rain);
					}
				}
			}
			max = Math.max(max, count);
		}
		System.out.println(max);
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
