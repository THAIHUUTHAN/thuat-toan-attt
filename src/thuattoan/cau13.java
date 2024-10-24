package thuattoan;

import java.util.Scanner;

public class cau13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số nguyên dương N: ");
		int n = sc.nextInt();

		for (int i = 2; i <= n - 2; i++) {
			for (int j = i + 2; j <= n; j++) {
				if (isPrime(i) && isPrime(j) && isPrime(i + j) && isPrime(j - i)) {
					System.out.println("Hai số nguyên tố là: " + i + ", " + j);
					return;
				}
			}
		}

		System.out.println("Không tìm thấy hai số nguyên tố nào thỏa mãn yêu cầu.");
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
