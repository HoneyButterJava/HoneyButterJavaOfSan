package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1931 {

	static int N;
	static int[][] time;
	static FastReader scan = new FastReader();
	static int end = 0;
	static int begin = 0;
	static int max = Integer.MIN_VALUE;

	static void input() {
		N = scan.nextInt();
		time = new int[N][2];
		for (int i = 0; i < N - 1; i++) {
			time[i][0] = scan.nextInt();
			time[i][1] = scan.nextInt();
		}
	}

	public static void rec(int start, int count) {
		if (start == N) {
			if (count > max) {
				max = count;
			}
		} else {
			if (begin == time[start][0] && begin == time[start][1]) {
				count++;
			} else if (end <= time[start][0]) {
				begin = time[start][0];
				end = time[start][1];
				count++;
			}
			rec(start + 1, count);
		}

	}

	public static void main(String[] args) {
		input();

		Arrays.sort(time, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			}
			return a[1] - b[1];
		});

		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int cnt = 0;
		int end = 0;

		for (int i = 0; i < N; i++) {
			if (end <= time[i][0]) {
				end = time[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);

		rec(0, 0);
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
