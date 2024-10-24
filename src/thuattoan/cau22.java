package thuattoan;

import java.util.Scanner;

public class cau22 {

	// Kiểm tra số nguyên tố
	public static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}

	// Hàm F(N) theo đề bài
	public static int F(int n) {
		return isPrime(n) ? n : 0;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Đọc giá trị L và R từ bàn phím
		System.out.print("Nhập L: ");
		int L = scanner.nextInt();
		System.out.print("Nhập R: ");
		int R = scanner.nextInt();

		long totalSum = 0;

		// Tính tổng F(i) * F(j) với j > i
		for (int i = L; i <= R; i++) {
			for (int j = i + 1; j <= R; j++) {
				totalSum += F(i) * F(j);
			}
		}

		// In kết quả ra màn hình
		System.out.println("Tổng F(i) * F(j) với j > i là: " + totalSum);

		scanner.close();
	}
}
