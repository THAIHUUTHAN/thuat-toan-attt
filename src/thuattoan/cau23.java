package thuattoan;

import java.util.Scanner;

public class cau23 {

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

		// Tính tổng các số nguyên tố trong khoảng [A, B]
		int sum = 0;
		for (int i = a; i <= b; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}

		// Kiểm tra tổng có phải là số nguyên tố hay không
		if (isPrime(sum)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
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
