package nangcao;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class cau39 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập số lượng phần tử trong mảng
		System.out.print("Nhập số lượng phần tử: ");
		int n = scanner.nextInt();

		// Nhập các phần tử của mảng
		int[] A = new int[n];
		System.out.println("Nhập các phần tử của mảng:");
		for (int i = 0; i < n; i++) {
			A[i] = scanner.nextInt();
		}

		// Tìm các cặp số (i, j) có GCD là số nguyên tố
		findPairs(A, n);
	}

	private static void findPairs(int[] A, int n) {
		// Lưu trữ các cặp số (i, j) đã tìm thấy
		Set<String> pairs = new HashSet<>();

		// Duyệt qua tất cả các cặp phần tử (i, j)
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// Tính GCD của A[i] và A[j]
				int gcd = BigInteger.valueOf(A[i]).gcd(BigInteger.valueOf(A[j])).intValue();

				// Kiểm tra xem GCD có phải là số nguyên tố hay không
				if (isPrime(gcd)) {
					// Lưu trữ cặp số (i, j)
					String pair = "(" + i + ", " + j + ")";
					pairs.add(pair);

					// In ra cặp số đã tìm thấy
					System.out.println("Cặp số (" + i + ", " + j + ") có GCD là số nguyên tố " + gcd);
				}
			}
		}

		// In thông báo nếu không tìm thấy cặp nào
		if (pairs.isEmpty()) {
			System.out.println("Không tìm thấy cặp nào có GCD là số nguyên tố!");
		}
	}

	// Hàm kiểm tra số nguyên tố
	private static boolean isPrime(int n) {
		if (n <= 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
