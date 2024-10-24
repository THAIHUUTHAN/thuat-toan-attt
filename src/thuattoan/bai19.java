package thuattoan;

import java.util.Scanner;

public class bai19 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập hệ số A: ");
		int a = sc.nextInt();
		System.out.print("Nhập hệ số B: ");
		int b = sc.nextInt();
		System.out.print("Nhập hệ số C: ");
		int c = sc.nextInt();
		System.out.print("Nhập giới hạn dưới m: ");
		int m = sc.nextInt();
		System.out.print("Nhập giới hạn trên l: ");
		int l = sc.nextInt();

		// Kiểm tra ràng buộc m < l
		if (m >= l) {
			System.out.println("Giới hạn dưới m phải nhỏ hơn giới hạn trên l.");
			return;
		}

		// In ra các số nguyên dương trong khoảng [m, l] thỏa mãn yêu cầu
		for (int x = m; x <= l; x++) {
			int value = a * x * x + b * x + c;

			if (isPrime(value)) {
				System.out.print(x + " ");
			}
		}
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
