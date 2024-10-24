package thuattoan;

import java.util.Scanner;

public class cau20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập giới hạn dưới M: ");
		int m = sc.nextInt();
		System.out.print("Nhập giới hạn trên N: ");
		int n = sc.nextInt();
		System.out.print("Nhập giá trị D: ");
		int d = sc.nextInt();

		// Kiểm tra ràng buộc
		if (m < 0 || n < 0 || d < 0 || m > n || d > 1000) {
			System.out.println("Giá trị nhập vào không hợp lệ. Vui lòng nhập lại!");
			return;
		}

		// In ra các cặp số (A, B) thỏa mãn
		for (int a = m; a <= n; a++) {
			for (int b = a + 1; b <= n; b++) {
				if (gcd(a, b) == d) {
					System.out.println("(" + a + ", " + b + ")");
				}
			}
		}
	}

	// Hàm tính toán ước số chung lớn nhất (GCD)
	static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
