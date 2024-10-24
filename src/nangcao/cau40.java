package nangcao;

import java.util.Scanner;

public class cau40 {

	// Hàm tính GCD của hai số
	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	// Hàm kiểm tra số nguyên tố
	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}

	// Hàm đếm các cặp số thỏa mãn điều kiện
	public static int countPrimeGCDPairs(int[] A) {
		int count = 0;
		int n = A.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int gcdValue = gcd(A[i], A[j]);
				if (isPrime(gcdValue)) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số phần tử của mảng A: ");
		int n = scanner.nextInt();
		int[] A = new int[n];

		System.out.println("Nhập các phần tử của mảng A:");
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}

		int result = countPrimeGCDPairs(A);
		System.out.println("Số cặp (i, j) có GCD là số nguyên tố: " + result);
	}
}
