package thuattoan;

import java.util.Scanner;

public class cau21 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập giới hạn dưới A: ");
		int a = sc.nextInt();
		System.out.print("Nhập giới hạn trên B: ");
		int b = sc.nextInt();

		// Kiểm tra ràng buộc
		if (a > b) {
			System.out.println("Giới hạn dưới A phải nhỏ hơn hoặc bằng giới hạn trên B.");
			return;
		}

		// Đếm số lượng siêu số nguyên tố
		int count = 0;
		for (int i = a + 1; i <= b; i++) {
			if (isPrime(countOfPrimeNumbers(1, i - 1))) {
				count++;
			}
		}

		System.out.println("Số lượng siêu số nguyên tố trong khoảng [" + a + ", " + b + "] là: " + count);
	}

	// Hàm đếm số lượng số nguyên tố trong khoảng [1, n]
	static int countOfPrimeNumbers(int start, int end) {
		int count = 0;
		for (int num = start; num <= end; num++) {
			if (isPrime(num)) {
				count++;
			}
		}
		return count;
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
}
