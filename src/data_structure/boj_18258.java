package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_18258 {

	static LinkedList<Integer> queue = new LinkedList<>();
	static StringBuilder sb = new StringBuilder();

	static void instruction(String ins) {
		Integer number = null;
		switch (ins) {
			case "pop":
				number = queue.poll();
				break;
			case "size":
				number = queue.size();
				break;
			case "empty":
				if (queue.isEmpty()) {
					number = 1;
				} else {
					number = 0;
				}
				break;
			case "front":
				number = queue.peek();
				break;
			case "back":
				number = queue.peekLast();
				break;
		}

		if (number == null) {
			sb.append(-1).append("\n");
		} else {
			sb.append(number).append("\n");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer ins = new StringTokenizer(br.readLine(), " ");
			String command = ins.nextToken();
			if (command.equals("push")) {
				Integer number = Integer.parseInt(ins.nextToken());
				queue.add(number);
			} else {
				instruction(command);
			}
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
