package thuattoan;

import java.util.Scanner;

public class PollardRho {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int a = 2;
		int b = 2;
		for (int i = 1;; i++) {
			a = (a * a + 1) % n;
			b = (b * b + 1) % n;
			b = (b * b + 1) % n;
			int d = gcd(a - b, n);
			if (d > 1 && d < n) {
				System.out.print(d + "*");
				System.out.println(n / d);
				break;
			}
		}
	}

	public static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		while (b > 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
