package thuattoan;

import java.util.Scanner;

public class cau10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập N: ");
		int n = sc.nextInt();

		int countFactors = 0;
		int countPrimeFactors = 0;

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				countFactors++;

				if (isPrime(i)) {
					countPrimeFactors++;
				}
			}
		}

		System.out.println("Số ước của " + n + " là: " + countFactors);
		System.out.println("Số ước nguyên tố của " + n + " là: " + countPrimeFactors);
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
