package bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11403 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] adj;
	static boolean[] visit;

	static void input() {
		N = scan.nextInt();
		adj = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				adj[i][j] = scan.nextInt();
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			visit[i] = false;
		}

		que.add(start);
		visit[start] = false;  // 자기 자신을 돌아올 수 있는 지를 판단해야 하므로, false로 초기화

		while (!que.isEmpty()) {
			int x = que.poll();

			for (int y = 1; y <= N; y++) {
				if (adj[x][y] == 0) {
					continue;
				}
				if (visit[y]) {
					continue;
				}
				que.add(y);
				visit[y] = true;
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(visit[i] ? 1 : 0).append(' ');
		}
		sb.append('\n');
	}

	public static void main(String[] args) {
		input();
		visit = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			bfs(i);
		}
		System.out.println(sb);
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
