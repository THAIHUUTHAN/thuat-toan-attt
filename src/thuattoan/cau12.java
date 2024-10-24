package thuattoan;

import java.util.Scanner;

public class cau12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số nguyên dương N: ");
		int n = sc.nextInt();

		for (int i = 3; i <= n - 3; i++) {
			if (isPrime(i) && isPrime(i + 1) && isPrime(i + 2) && isPrime(i + 3)) {
				System.out.println(
						"Bốn số nguyên tố liên tiếp là: " + i + ", " + (i + 1) + ", " + (i + 2) + ", " + (i + 3));
				return;
			}
		}

		System.out.println("Không tìm thấy bốn số nguyên tố liên tiếp nào thỏa mãn yêu cầu.");
	}

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
}
