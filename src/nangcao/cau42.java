package nangcao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class cau42 {

	// Hàm kiểm tra số nguyên tố
	public static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		if (num <= 3)
			return true;
		if (num % 2 == 0 || num % 3 == 0)
			return false;
		for (int i = 5; i * i <= num; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0)
				return false;
		}
		return true;
	}

	// Hàm sinh ra số nguyên tố ngẫu nhiên nhỏ hơn max
	public static int generateRandomPrime(int max) {
		Random rand = new Random();
		int prime;
		do {
			prime = rand.nextInt(max);
		} while (!isPrime(prime) || prime == 0);
		return prime;
	}

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

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Sinh ra hai số nguyên tố p và q nhỏ hơn 1000
		int p = generateRandomPrime(1000);
		int q = generateRandomPrime(1000);

		System.out.println("Số nguyên tố p: " + p);
		System.out.println("Số nguyên tố q: " + q);

		// Kiểm tra với các số a từ 1 đến 99
		List<Integer> validAValues = new ArrayList<>();
		for (int a = 1; a < 100; a++) {
			long result = powerMod(a, p, q);
			if (isPrime((int) result)) {
				validAValues.add(a);
			}
		}

		// In ra các số a thỏa mãn điều kiện
		System.out.println("Các số a thỏa mãn điều kiện a^p mod q là số nguyên tố:");
		for (int a : validAValues) {
			System.out.println(a);
		}
	}
}
