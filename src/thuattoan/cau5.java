package thuattoan;

import java.util.Scanner;

public class cau5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhập số A: ");
		int a = sc.nextInt();

		System.out.print("Nhập số B: ");
		int b = sc.nextInt();

		// Kiểm tra xem A và B có hợp lệ hay không
		if (a > b) {
			System.out.println("Số A phải nhỏ hơn hoặc bằng số B!");
			return;
		}

		// Tính tổng các số nguyên tố trong khoảng [A, B]
		int sum = 0;
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}

		// In kết quả
		System.out.println("Tổng các số nguyên tố trong khoảng [" + a + ", " + b + "]: " + sum);
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
