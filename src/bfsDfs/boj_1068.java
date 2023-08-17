package bfsDfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1068 {

	static FastReader scan = new FastReader();

	static int n, root, erased;
	static ArrayList<Integer>[] child;
	static int[] leaf;

	static void input() {
		n = scan.nextInt();
		child = new ArrayList[n];
		leaf = new int[n];
		for (int i = 0; i < n; i++) {
			child[i] = new ArrayList<>();
		}
		for (int i = 0; i < n; i++) {
			int parent = scan.nextInt();
			if (parent == -1) {
				root = i;
				continue;
			}
			child[parent].add(i);
		}
		erased = scan.nextInt();
	}

	//정점 x의 부모가 parent일 때, Subtree(x) 의 leaf 개수를 세주는 함수
	static void dfs(int x, int parent) {
		if (child[x].isEmpty()) {
			leaf[x]++;
		}
		for (int y : child[x]) {
			if (y == parent) {
				continue;
			}
			dfs(y, x);
			leaf[x] += leaf[y];
		}
	}

	public static void main(String[] args) {
		input();

		for (int i = 0; i < n; i++) {
			if (child[i].contains(erased)) {
				child[i].remove(child[i].indexOf(erased));
			}
		}
		if (root != erased) {
			dfs(root, -1);
		}
		System.out.println(leaf[root]);
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

