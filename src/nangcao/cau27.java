package nangcao;

import java.util.ArrayList;
import java.util.List;

public class cau27 {

	public static void main(String[] args) {
		List<Pair> pairs = new ArrayList<>();

		// Tìm các ước chung lớn nhất nguyên tố
		for (int a = 1; a < 1000; a++) {
			for (int b = a + 1; b < 1000; b++) {
				int gcd = findGCD(a, b);
				if (isPrime(gcd)) {
					pairs.add(new Pair(a, b));
				}
			}
		}

		// In ra các cặp số
		System.out.println("Các cặp số (a, b) thoả mãn điều kiện:");
		for (Pair pair : pairs) {
			System.out.println("(" + pair.a + ", " + pair.b + ")");
		}
	}

	// Hàm tìm ước chung lớn nhất (GCD) của hai số
	static int findGCD(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	// Hàm kiểm tra số nguyên tố
	static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	// Lớp Pair để lưu trữ cặp số
	static class Pair {
		int a;
		int b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}
