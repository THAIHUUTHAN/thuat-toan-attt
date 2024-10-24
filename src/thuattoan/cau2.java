package thuattoan;

import java.util.Scanner;

public class cau2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng chữ số N (2 <= N <= 10): ");
		int n = sc.nextInt();

		if (n < 2 || n > 10) {
			System.out.println("Số lượng chữ số N không hợp lệ!");
			return;
		}

		// Tạo giới hạn dưới và trên cho các số có N chữ số
		int lower = (int) Math.pow(10, n - 1);
		int upper = (int) Math.pow(10, n) - 1;

		// Duyệt qua các số từ lower đến upper
		for (int i = lower; i <= upper; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
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
