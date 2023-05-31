package string;

import java.util.Scanner;

public class boj_1543 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String want = sc.nextLine();

		int count = 0;
		for (int i = 0; i < str.length() - want.length() + 1; i++) {
			if (str.charAt(i) != want.charAt(0)) {
				continue;
			}
			if (want.equals(str.substring(i, i + want.length()))) {
				count++;
				i += want.length() - 1;
			}
		}
		System.out.println(count);
	}
}
