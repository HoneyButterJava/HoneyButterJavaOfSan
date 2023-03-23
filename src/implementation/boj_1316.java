package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class boj_1316 {

	public static void main(String[] args) throws IOException {
		ArrayList<String> arr = new ArrayList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		for (int i = 0; i < count; i++) {
			String str = br.readLine();
			arr.add(str);
		}

		int answer = 0;
		for (int i = 0; i < count; i++) {
			String str = arr.get(i);
			if (findGroupWord(str)) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	private static boolean findGroupWord(String str) {
		boolean[] alphabet = new boolean[26];
		Arrays.fill(alphabet, false);

		//		System.out.println((int)str.charAt(0));
		alphabet[(int) str.charAt(0) - 'a'] = true;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) != str.charAt(i) && alphabet[(int) str.charAt(i) - 'a'] == true) {
				return false;
			} else {
				alphabet[(int) str.charAt(i) - 'a'] = true;
			}
		}
		return true;
	}

}
