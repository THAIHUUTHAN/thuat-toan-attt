package thuattoan;

import java.util.Scanner;

public class cau9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập N: ");
		int n = sc.nextInt();

		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				count++;
			}
		}

		System.out.println("Có " + count + " số nguyên tố nhỏ hơn hoặc bằng " + n);
	}

	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
