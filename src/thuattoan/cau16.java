package thuattoan;

import java.util.Random;
import java.util.Scanner;

public class cau16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập kích thước mảng N: ");
		int n = sc.nextInt();

		int[] arr = new int[n]; // Tạo mảng kích thước N
		Random random = new Random(); // Tạo đối tượng Random

		// Tạo mảng số ngẫu nhiên
		for (int i = 0; i < n; i++) {
			arr[i] = random.nextInt();
		}

		System.out.println("Các số nguyên tố trong mảng:");
		for (int num : arr) {
			if (isPrime(num)) {
				System.out.print(num + " ");
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
