package implementation;

import java.util.Scanner;

public class boj_1236 {

	public static boolean checkRow(char[] mapRow) {
		int size = mapRow.length;
		for (int i = 0; i < size; i++) {
			if (mapRow[i] == 'X') {
				return true;
			}
		}
		return false;
	}

	public static boolean checkColumn(char[][] map, int x) {
		int size = map.length;
		for (int i = 0; i < size; i++) {
			if (map[i][x] == 'X') {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int height = sc.nextInt();
		int width = sc.nextInt();
		char map[][] = new char[height][width];
		for (int i = 0; i < height; i++) {
			String str = sc.next();
			for (int j = 0; j < width; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int count = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!checkRow(map[i]) && !checkColumn(map, j)) {
					map[i][j] = 'X';
					count++;
				}
			}
		}

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!checkRow(map[i]) || !checkColumn(map, j)) {
					map[i][j] = 'X';
					count++;
				}
			}
		}
		System.out.println(count);

		//////////////////선생님 코드//////////////////////////////////////
		Scanner scT = new Scanner(System.in);
		int N = scT.nextInt();
		int M = scT.nextInt();
		char[][] mapT = new char[N][M];
		for (int i = 0; i < N; i++) {
			mapT[i] = scT.next().toCharArray();
		}

		boolean[] rowExist = new boolean[N];
		boolean[] colExist = new boolean[M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (mapT[i][j] == 'X') {
					rowExist[i] = true;
					colExist[j] = true;
				}
			}
		}

		int rowNeedCount = N;
		int colNeedCount = M;
		for (int i = 0; i < N; i++) {
			if (rowExist[i]) {
				rowNeedCount--;
			}
		}
		for (int i = 0; i < M; i++) {
			if (colExist[i]) {
				colNeedCount--;
			}
		}

		System.out.println(Math.max(rowNeedCount, colNeedCount));
	}
}
