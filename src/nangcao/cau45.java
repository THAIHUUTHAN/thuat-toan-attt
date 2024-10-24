package nangcao;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class cau45 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập số lượng phần tử N
		System.out.print("Nhập số lượng phần tử N: ");
		int n = scanner.nextInt();

		// Kiểm tra N hợp lệ (N > 0)
		if (n <= 0) {
			System.out.println("Số lượng phần tử N phải lớn hơn 0!");
			return;
		}

		// Sinh mảng số nguyên tố A
		int[] A = generatePrimes(n);

		// In ra mảng A
		System.out.println("Mảng số nguyên tố A:");
		for (int element : A) {
			System.out.print(element + " ");
		}

		// Tính khoảng cách nhỏ nhất giữa 2 số bất kỳ
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int distance = Math.abs(A[i] - A[j]);
				if (distance < minDistance) {
					minDistance = distance;
				}
			}
		}

		// In ra khoảng cách nhỏ nhất
		System.out.println("\nKhoảng cách nhỏ nhất giữa 2 số bất kỳ trong mảng: " + minDistance);
	}

	// Hàm sinh mảng số nguyên tố sử dụng kiểm tra Miller-Rabin
	private static int[] generatePrimes(int n) {
		int[] A = new int[n];
		int count = 0; // Đếm số phần tử đã sinh
		int num = 2; // Ứng cử viên số nguyên tố tiếp theo

		while (count < n) {
			if (isPrimeMillerRabin(num)) {
				A[count++] = num;
			}
			num++;
		}

		return A;
	}

	// Hàm kiểm tra số nguyên tố sử dụng Miller-Rabin (đã sửa lỗi)
	private static boolean isPrimeMillerRabin(int n) {
		if (n <= 1)
			return false;
		if (n <= 3)
			return true; // 2, 3 là số nguyên tố

		// Viết n - 1 dưới dạng 2^s * d với d lẻ
		int d = n - 1;
		int s = 0;
		while (d % 2 == 0) {
			d /= 2;
			s++;
		}

		// Lặp k lần (k thường lấy 2, 4, 8)
		int k = 2;
		for (int i = 0; i < k; i++) {
			// Chọn a ngẫu nhiên trong khoảng [2, n - 1]
			int a = new Random().nextInt(n - 1) + 2; // Tạo đối tượng Random mới

			// Tính x = a^d mod n
			int x = BigInteger.valueOf(a).pow(d).mod(BigInteger.valueOf(n)).intValue();

			if (x == 1 || x == n - 1) {
				continue;
			}

			// Lặp s - 1 lần
			for (int j = 0; j < s - 1; j++) {
				x = BigInteger.valueOf(x).pow(2).mod(BigInteger.valueOf(n)).intValue();
				if (x == 1) {
					return false;
				}
				if (x == n - 1) {
					break;
				}
			}

			return false;
		}

		return true;
	}
}
