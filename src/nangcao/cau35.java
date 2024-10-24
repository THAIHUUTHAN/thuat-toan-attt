package nangcao;

import java.util.Scanner;

public class cau35 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số nguyên dương N: ");
		int n = scanner.nextInt();
		System.out.print("Nhập số lần lặp k: ");
		int k = scanner.nextInt();

		boolean isPrime = isMillerRabinPrime(n, k);
		System.out.println(n + " " + (isPrime ? "là số nguyên tố" : "không phải là số nguyên tố"));
	}

	private static boolean isMillerRabinPrime(int n, int k) {
		if (n <= 2) {
			return false;
		}

		if (n % 2 == 0) {
			return false;
		}

		int d = n - 1;
		int s = 0;
		while (d % 2 == 0) {
			d /= 2;
			s++;
		}

		for (int i = 0; i < k; i++) {
			int a = 2 + (int) (Math.random() * (n - 2));
			int x = modPow(a, d, n);

			if (x == 1 || x == n - 1) {
				continue;
			}

			for (int j = 0; j < s - 1; j++) {
				x = modPow(x, 2, n);
				if (x == 1) {
					return false;
				}

				if (x == n - 1) {
					break;
				}
			}

			if (x != n - 1) {
				return false;
			}
		}

		return true;
	}

	private static int modPow(int base, int exponent, int mod) {
		int result = 1;
		while (exponent > 0) {
			if (exponent % 2 == 1) {
				result = (result * base) % mod;
			}

			base = (base * base) % mod;
			exponent /= 2;
		}

		return result;
	}
}
