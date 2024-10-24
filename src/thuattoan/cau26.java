package thuattoan;

import java.util.Scanner;

public class cau26 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số nguyên dương N: ");
		int n = sc.nextInt();

		// Kiểm tra ràng buộc
		if (n <= 0 || n >= 10000) {
			System.out.println("N phải là số nguyên dương nhỏ hơn 10000.");
			return;
		}

		// Tìm các số mạnh mẽ nhỏ hơn N
		for (int i = 2; i <= n; i++) {
			if (isManhMe(i)) {
				System.out.println(i + " là số mạnh mẽ.");
			}
		}
	}

	// Hàm kiểm tra số mạnh mẽ
	static boolean isManhMe(int n) {
		if (n % 2 != 0) {
			return false; // N chẵn mới có thể là số mạnh mẽ
		}

		// Tìm số nguyên tố p nhỏ nhất sao cho n chia hết cho p
		int p = 2;
		while (p * p <= n) {
			if (n % p == 0) {
				// Kiểm tra xem n có chia hết cho p^2 hay không
				if (n % (p * p) == 0) {
					return true;
				}
			}
			p++;
		}

		return false;
	}
}
