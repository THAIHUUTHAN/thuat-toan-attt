package nangcao;

import java.util.Scanner;

public class cau44 {

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
			throw new ArithmeticException("Nghịch đảo không tồn tại.");
		} else {
			// Đảm bảo kết quả dương
			int res = (x[0] % p + p) % p;
			return res;
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập số phần tử của mảng A: ");
		int n = scanner.nextInt();
		int[] A = new int[n];

		System.out.println("Nhập các phần tử của mảng A:");
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}

		System.out.print("Nhập số nguyên tố p (trường 𝐹𝑝): ");
		int p = scanner.nextInt();

		int[] B = new int[n];

		for (int i = 0; i < n; i++) {
			try {
				B[i] = modInverse(A[i], p);
			} catch (ArithmeticException e) {
				System.out.println("Phần tử " + A[i] + " không có nghịch đảo trong trường 𝐹𝑝.");
				return;
			}
		}

		System.out.println("Mảng B có các phần tử là nghịch đảo của các phần tử tương ứng trong A:");
		for (int i = 0; i < n; i++) {
			System.out.print(B[i] + " ");
		}
	}
}
