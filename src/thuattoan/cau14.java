package thuattoan;

import java.util.Scanner;

public class cau14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int a = 5; a <= 9; a++) {
			for (int b = 0; b <= 9; b++) {
				for (int c = 0; c <= 9; c++) {
					int num = a * 100 + b * 10 + c; // Tạo số nguyên tố có 3 chữ số
					int reverseNum = c * 100 + b * 10 + a; // Số đảo ngược

					// Kiểm tra xem số đảo ngược có phải là lập phương của một số tự nhiên hay không
					int cubeRoot = (int) Math.cbrt(reverseNum);
					if (cubeRoot * cubeRoot * cubeRoot == reverseNum) {
						if (isPrime(num)) { // Kiểm tra xem số nguyên tố hay không
							System.out.println("Số nguyên tố cần tìm là: " + num);
							return;
						}
					}
				}
			}
		}

		System.out.println("Không tìm thấy số nguyên tố nào thỏa mãn yêu cầu.");
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
