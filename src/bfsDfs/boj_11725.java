package bfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11725 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[] parent;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	static void input() {
		N = scan.nextInt();
		adj = new ArrayList[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < N - 1; i++) {
			int x = scan.nextInt(), y = scan.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}
	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();

		que.add(start);
		visit[start] = true;

		while (!que.isEmpty()) {
			int x = que.poll();

			for (int y : adj[x]) {
				if (visit[y]) {
					continue;
				}
				que.add(y);
				parent[y] = x;
				visit[y] = true;
			}
		}
	}

	public static void main(String[] args) {
		input();
		visit = new boolean[N + 1];
		bfs(1);
		int ans = 0;
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append('\n');
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