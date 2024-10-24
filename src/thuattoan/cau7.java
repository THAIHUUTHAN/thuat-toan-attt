package thuattoan;

import java.util.Scanner;

public class cau7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập N: ");
		int n = sc.nextInt();

		for (int i = 2; i <= n; i++) {
			if (isPrime(i) && isPrime(reverse(i))) {
				System.out.print(i + " ");
			}
		}
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

	private static int reverse(int num) {
		int reversed = 0;
		while (num > 0) {
			int digit = num % 10;
			reversed = reversed * 10 + digit;
			num /= 10;
		}

		return reversed;
	}
}
