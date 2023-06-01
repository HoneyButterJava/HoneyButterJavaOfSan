//package implementation;
//
//import java.util.Scanner;
//
//public class boj_10158 {
//
//	public static int gcd(int a, int b) {
//		if (a < b) {
//			int temp = a;
//			a = b;
//			b = temp;
//		}
//		while (b != 0) {
//			int r = a % b;
//			a = b;
//			b = r;
//		}
//		return a;
//	}
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int width = sc.nextInt();
//		int height = sc.nextInt();
//		sc.nextLine();
//		int p = sc.nextInt();
//		int q = sc.nextInt();
//		sc.nextLine();
//		int times = sc.nextInt();
//		int directionX = 1;
//		int directionY = 1;
//		times = times % ((width * height) / gcd(width, height));
//
//		for (int i = 0; i < times; i++) {
//			if (p <= 0 || p >= width) {
//				directionX *= -1;
//			}
//			if (q <= 0 || q >= height) {
//				directionY *= -1;
//			}
//			p += directionX;
//			q += directionY;
//			//			System.out.println("p is " + p + ", q is " + q);
//		}
//		System.out.println(p + " " + q);
//	}
//
//}

package implementation;

import java.util.Scanner;

public class boj_10158 {

	//	public static int gcd(int a, int b) {
	//		if (a < b) {
	//			int temp = a;
	//			a = b;
	//			b = temp;
	//		}
	//		while (b != 0) {
	//			int r = a % b;
	//			a = b;
	//			b = r;
	//		}
	//		return a;
	//	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int width = sc.nextInt();
		int height = sc.nextInt();
		sc.nextLine();
		int p = sc.nextInt();
		int q = sc.nextInt();
		sc.nextLine();
		int times = sc.nextInt();

		p = (p + times) % (2 * width);
		q = (q + times) % (2 * height);
		if (p > width) {
			p = 2 * width - p;
		}
		if (q > height) {
			q = 2 * height - q;
		}

		System.out.println(p + " " + q);
	}

}

