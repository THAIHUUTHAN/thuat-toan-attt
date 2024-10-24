package nangcao;

import java.util.Random;
import java.util.Scanner;

public class cau34 {

	// Hàm để tính (a^b) % mod
	public static long powerMod(long a, long b, long mod) {
		long result = 1;
		a = a % mod;
		while (b > 0) {
			if ((b & 1) == 1) {
				result = (result * a) % mod;
			}
			b = b >> 1;
			a = (a * a) % mod;
		}
		return result;
	}

	// Hàm kiểm tra tính nguyên tố theo Fermat
	public static boolean isPrimeFermat(long n, int k) {
		if (n <= 1 || n == 4)
			return false;
		if (n <= 3)
			return true;

		Random rand = new Random();

		// Lặp k lần
		for (int i = 0; i < k; i++) {
			// Chọn ngẫu nhiên số a trong khoảng [2, n-2]
			long a = 2 + (long) (rand.nextDouble() * (n - 4));

			// Kiểm tra nếu a^(n-1) % n != 1
			if (powerMod(a, n - 1, n) != 1) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhập số cần kiểm tra: ");
		long n = scanner.nextLong();
		System.out.println("Nhập số lần kiểm tra: ");
		int k = scanner.nextInt();

		if (isPrimeFermat(n, k)) {
			System.out.println(n + " là số nguyên tố.");
		} else {
			System.out.println(n + " không phải là số nguyên tố.");
		}

		scanner.close();
	}
}
