package nangcao;

import java.util.Scanner;

public class cau38 {
	// Hàm tính GCD và sử dụng để tìm nghịch đảo
	public static int gcdExtended(int a, int b, int[] x) {
		if (a == 0) {
			x[0] = 0;
			x[1] = 1;
			return b;
		}

		int[] x1 = new int[2]; // Lưu kết quả của gọi đệ quy
		int gcd = gcdExtended(b % a, a, x1);

		// Cập nhật kết quả
		x[0] = x1[1] - (b / a) * x1[0];
		x[1] = x1[0];

		return gcd;
	}

	// Hàm tìm nghịch đảo modulo
	public static int modInverse(int a, int p) {
		int[] x = new int[2];
		int gcd = gcdExtended(a, p, x);

		if (gcd != 1) {
			// Nếu GCD không phải là 1, không có nghịch đảo
			System.out.println("Nghịch đảo không tồn tại.");
			return -1;
		} else {
			// Đảm bảo kết quả dương
			int res = (x[0] % p + p) % p;
			return res;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số a: ");
		int a = scanner.nextInt();
		System.out.print("Nhập số nguyên tố p: ");
		int p = scanner.nextInt();

		int inverse = modInverse(a, p);
		if (inverse != -1) {
			System.out.println("Nghịch đảo của " + a + " trong trường Fp là: " + inverse);
		}
	}
}
