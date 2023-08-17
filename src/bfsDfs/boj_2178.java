package bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2178 {

	static FastReader scan = new FastReader();

	static int N, M;
	static int[][] A;
	static String[] a;
	static boolean[][] visit;
	static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

	static void input() {
		N = scan.nextInt();
		M = scan.nextInt();
		a = new String[N];
		for (int i = 0; i < N; i++) {
			a[i] = scan.nextLine();
		}
		visit = new boolean[N][M];
		A = new int[N][M];
	}

	static void bfs(int x, int y) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = -1;
			}
		}

		Queue<Integer> Q = new LinkedList<>();
		Q.add(x); // 행
		Q.add(y); // 열
		A[x][y] = 1; // 시작점 거리 기록
		visit[x][y] = true;

		// BFS 과정 시작
		while (!Q.isEmpty()) {
			x = Q.poll();
			y = Q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = x + dir[k][0];
				int ny = y + dir[k][1];

				// 유효성 검사
				if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
					continue;  // 지도를 벗어나는 곳으로 가는지 확인
				}
				if (a[nx].charAt(ny) == '0') {
					continue;  // 갈 수 있는 칸인지 확인
				}
				if (visit[nx][ny]) {
					continue;  // 이미 방문한 적이 있는지
				}

				Q.add(nx);
				Q.add(ny);
				visit[nx][ny] = true;
				A[nx][ny] = A[x][y] + 1;
			}
		}
	}

	public static void main(String[] args) {
		input();
		bfs(0, 0);
		System.out.println(A[N - 1][M - 1]);
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

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
