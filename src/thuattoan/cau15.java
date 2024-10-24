package thuattoan;

import java.util.Scanner;

public class cau15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số nguyên dương N: ");
		int n = sc.nextInt();

		for (int i = 3; i <= n - 2; i += 2) {
			if (isPrime(i) && isPrime(i + 2)) {
				System.out.println("Hai số nguyên tố sinh đôi là: " + i + ", " + (i + 2));
				return;
			}
		}

		System.out.println("Không tìm thấy hai số nguyên tố sinh đôi nào nhỏ hơn hoặc bằng N.");
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
