package thuattoan;

import java.util.Scanner;

public class cau17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập hệ số A: ");
		int a = sc.nextInt();
		System.out.print("Nhập hệ số B: ");
		int b = sc.nextInt();
		System.out.print("Nhập hệ số C: ");
		int c = sc.nextInt();

		// Tìm giá trị x nhỏ nhất
		int xMin = Integer.MAX_VALUE; // Khởi tạo xMin với giá trị lớn nhất
		for (int x = 1; x <= Integer.MAX_VALUE; x++) {
			int value = a * x * x + b * x + c; // Tính giá trị biểu thức

			// Kiểm tra xem giá trị có phải là số nguyên tố hay không
			if (isPrime(value)) {
				xMin = Math.min(xMin, x); // Cập nhật xMin nếu tìm thấy giá trị nhỏ hơn
				break; // Thoát khỏi vòng lặp nếu tìm thấy giá trị nhỏ nhất
			}
		}

		if (xMin != Integer.MAX_VALUE) {
			System.out.println("Số nguyên dương x nhỏ nhất là: " + xMin);
		} else {
			System.out.println("Không tìm thấy giá trị x nào thỏa mãn yêu cầu.");
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
