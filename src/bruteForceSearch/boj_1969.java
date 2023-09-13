package bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class boj_1969 {

	static int N, M;
	static String[] DNA;
	static StringBuilder nowDNA = new StringBuilder();
	static int sum;

	static void input() {
		FastReader scan = new FastReader();
		N = scan.nextInt();
		M = scan.nextInt();
		DNA = new String[N];
		for (int i = 0; i < N; i++) {
			DNA[i] = scan.next();
		}
	}

	static void findMostNucleo(int index) {
		HashMap<Character, Integer> nucleo = new LinkedHashMap<>(4);
		nucleo.put('A', 0);
		nucleo.put('C', 0);
		nucleo.put('G', 0);
		nucleo.put('T', 0);

		for (int i = 0; i < N; i++) {
			char now = DNA[i].charAt(index);
			nucleo.put(now, nucleo.get(now) + 1);
		}

		char mostNucleo = 'A';
		int max = 0;
		for (Character key : nucleo.keySet()) {
			if (max < nucleo.get(key)) {
				sum += max;
				max = nucleo.get(key);
				mostNucleo = key;
			} else {
				sum += nucleo.get(key);
			}
		}
		nowDNA.append(mostNucleo);
	}

	public static void main(String[] args) {
		input();
		for (int i = 0; i < M; i++) {
			findMostNucleo(i);
		}

		System.out.println(nowDNA);
		System.out.println(sum);
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
