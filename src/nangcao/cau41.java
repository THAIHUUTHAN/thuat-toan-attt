package nangcao;

import java.util.Scanner;

public class cau41 {
	// Hàm tính (a^k) % n sử dụng thuật toán bình phương và nhân có lặp
	public static long powerMod(int a, int k, int n) {
		long result = 1;
		long base = a % n;
		while (k > 0) {
			if (k % 2 == 1) {
				result = (result * base) % n;
			}
			base = (base * base) % n;
			k /= 2;
		}
		return result;
	}

	// Hàm kiểm tra số nguyên tố
	public static boolean isPrime(long num) {
		if (num <= 1)
			return false;
		if (num <= 3)
			return true;
		if (num % 2 == 0 || num % 3 == 0)
			return false;
		for (long i = 5; i * i <= num; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số nguyên dương a: ");
		int a = scanner.nextInt();

		System.out.print("Nhập số nguyên dương k: ");
		int k = scanner.nextInt();

		System.out.print("Nhập số nguyên dương n: ");
		int n = scanner.nextInt();

		// Tính a^k % n
		long result = powerMod(a, k, n);
		System.out.println("a^k % n = " + result);

		// Kiểm tra kết quả có phải số nguyên tố không
		if (isPrime(result)) {
			System.out.println(result + " là số nguyên tố.");
		} else {
			System.out.println(result + " không phải là số nguyên tố.");
		}
	}
}
