package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10825 {

	static FastReader scan = new FastReader();
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Score[] score;

	static void input() {
		N = scan.nextInt();
		score = new Score[N];
		for (int i = 0; i < N; i++) {
			score[i] = new Score();
			score[i].name = scan.next();
			score[i].korean = scan.nextInt();
			score[i].english = scan.nextInt();
			score[i].math = scan.nextInt();
		}
	}

	public static void main(String[] args) {
		input();

		Arrays.sort(score);
		for (int i = 0; i < N; i++) {
			sb.append(score[i].name).append('\n');
		}
		System.out.println(sb.toString());
	}

	static class Score implements Comparable<Score> {

		public String name;
		public int korean, english, math;

		@Override
		public int compareTo(Score other) {
			if (korean != other.korean) {
				return other.korean - korean;
			}
			if (english != other.english) {
				return english - other.english;
			}
			if (math != other.math) {
				return other.math - math;
			}
			return name.compareTo(other.name);
		}
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
