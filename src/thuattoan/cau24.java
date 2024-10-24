package thuattoan;

import java.util.Arrays;
import java.util.Scanner;

public class cau24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập giới hạn dưới a: ");
		int a = sc.nextInt();
		System.out.print("Nhập giới hạn trên b: ");
		int b = sc.nextInt();

		// Kiểm tra ràng buộc
		if (a > b) {
			System.out.println("Giới hạn dưới a phải nhỏ hơn hoặc bằng giới hạn trên b.");
			return;
		}

		// Tạo mảng S1 và S2 chứa giá trị bình phương của các số nguyên
		int[] s1 = new int[(int) Math.sqrt(b) + 1];
		for (int i = 0; i <= Math.sqrt(b); i++) {
			s1[i] = i * i;
		}

		int[] s2 = new int[(int) Math.sqrt(b) + 1];
		for (int i = 0; i <= Math.sqrt(b); i++) {
			s2[i] = i * i;
		}

		// Đếm số lượng số nguyên tố trong khoảng [a, b]
		int count = 0;
		for (int num = a; num <= b; num++) {
			if (isPrime(num)) {
				// Kiểm tra xem num có thể biểu diễn bằng tổng hai số từ S1 và S2 hay không
				boolean found = false;
				for (int x : s1) {
					if (Arrays.binarySearch(s2, num - x) >= 0) {
						found = true;
						break;
					}
				}

				if (found) {
					count++;
				}
			}
		}

		// In ra kết quả
		System.out.println("Số lượng số nguyên tố trong khoảng [" + a + ", " + b + "] là: " + count);
	}

	// Hàm kiểm tra số nguyên tố
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
