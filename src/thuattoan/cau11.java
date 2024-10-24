package thuattoan;

import java.util.Scanner;

public class cau11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số nguyên dương N: ");
		int n = sc.nextInt();

		int sum = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}

		System.out.println("Tổng các số nguyên tố nhỏ hơn hoặc bằng N là: " + sum);
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
