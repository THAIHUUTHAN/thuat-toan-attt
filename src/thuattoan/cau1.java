package thuattoan;

import java.util.Scanner;

public class cau1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số N: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			if (isQPrime(i)) {
				System.out.print(i + " ");
			}
		}
	}

	private static boolean isQPrime(int i) {

		int count = 0;
		for (int j = 1; j <= Math.sqrt(i); j++) {
			if (i % j == 0) {
				if (i / j == j) {
					count++;
				} else {
					count += 2;
				}
			}
		}

		return count == 4;
	}
}
