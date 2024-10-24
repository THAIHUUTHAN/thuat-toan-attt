package thuattoan;

import java.util.Scanner;

public class cau3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số nguyên dương N: ");
		int n = sc.nextInt();

		// Kiểm tra xem N có phải là số nguyên dương hay không
		if (n <= 0) {
			System.out.println("N must be a positive integer!");
			return;
		}

		// Tìm các ước số và tính toán các giá trị
		int p = 0; // Tổng các ước số
		int s = 0; // Số lượng ước số
		int q = 0; // Tổng các ước nguyên tố
		int k = 0; // Số lượng ước nguyên tố

		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				// Tìm ước số và tổng các ước số
				p += i;
				s++;

				// Kiểm tra xem i có phải là số nguyên tố hay không
				if (isPrime(i)) {
					q += i;
					k++;
				}

				// Tìm ước số bổ sung (n/i) nếu cần thiết
				int j = n / i;
				if (i != j) {
					p += j;
					s++;

					if (isPrime(j)) {
						q += j;
						k++;
					}
				}
			}
		}

		// Tính toán giá trị cuối cùng
		int result = n + p + s - q - k;
		System.out.println("Giá trị N + p + s - q - k: " + result);
	}

	// Hàm kiểm tra số nguyên tố
	private static boolean isPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
