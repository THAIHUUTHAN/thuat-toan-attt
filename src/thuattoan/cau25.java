package thuattoan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cau25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số N: ");
		int n = sc.nextInt();
		System.out.print("Nhập số M: ");
		int m = sc.nextInt();

		// Kiểm tra ràng buộc
		if (n < 1 || n > 10000 || m < 2 || m > 100) {
			System.out.println("Giá trị M và N không hợp lệ.");
			return;
		}

		// Tìm các số nguyên tố nhỏ hơn hoặc bằng n
		List<Integer> primes = new ArrayList<>();
		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}

		// Phân tích số N thành tổng của M số nguyên tố
		List<Integer> result = new ArrayList<>();
		if (backtrack(primes, 0, n, m, result)) {
			System.out.println("Có thể phân tích " + n + " thành tổng của " + m + " số nguyên tố:");
			for (int num : result) {
				System.out.print(num + " ");
			}
		} else {
			System.out.println("Không thể phân tích " + n + " thành tổng của " + m + " số nguyên tố.");
		}
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

	// Hàm đệ quy để phân tích số N thành tổng của M số nguyên tố
	static boolean backtrack(List<Integer> primes, int index, int remaining, int m, List<Integer> result) {
		if (m == 0 && remaining == 0) {
			return true;
		}

		if (index >= primes.size() || m < 0 || remaining < 0) {
			return false;
		}

		int currentPrime = primes.get(index);

		// Thử thêm số nguyên tố hiện tại vào kết quả
		result.add(currentPrime);
		boolean success = backtrack(primes, index + 1, remaining - currentPrime, m - 1, result);

		// Nếu không thành công, thử bỏ số nguyên tố hiện tại
		if (!success) {
			result.remove(result.size() - 1);
		}

		return success;
	}
}
