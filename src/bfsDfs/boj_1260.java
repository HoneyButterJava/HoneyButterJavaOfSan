package bfsDfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj_1260 {

	static StringBuilder sb = new StringBuilder();

	static int N, M, V;
	static ArrayList<Integer>[] adj;
	static boolean[] visit;

	static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		V = scan.nextInt();
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			adj[x].add(y);
			adj[y].add(x);
		}
		for (int i = 1; i <= N; i++) {
			// 작은 번호부터 가야하므로
			Collections.sort(adj[i]);
		}
	}

	static void dfs(int x) {
		visit[x] = true;
		sb.append(x).append(' ');

		for (int y : adj[x]) {
			if (visit[y]) {
				continue;
			}
			dfs(y);
		}
	}

	static void bfs(int start) {
		Queue<Integer> que = new LinkedList<>();

		que.add(start);
		visit[start] = true;

		while (!que.isEmpty()) {
			int x = que.poll();
			sb.append(x).append(' ');
			for (int y : adj[x]) {
				if (visit[y]) {
					continue;
				}
				que.add(y);
				visit[y] = true;
			}
		}
	}

	public static void main(String[] args) {
		input();

		visit = new boolean[N + 1];
		dfs(V);
		sb.append('\n');
		for (int i = 1; i <= N; i++) {
			visit[i] = false;
		}
		bfs(V);
		System.out.println(sb);
	}
}
