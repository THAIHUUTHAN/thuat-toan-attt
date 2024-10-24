package nangcao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class cau28_29_30 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số nguyên dương N (0 <= N <= 10000): ");
		int n = sc.nextInt();

		// Kiểm tra ràng buộc
		if (n < 0 || n > 10000) {
			System.out.println("N phải là số nguyên dương trong khoảng từ 0 đến 10000.");
			return;
		}

		// Tìm các số Carmichael nhỏ hơn N
		List<Integer> carmichaels = findCarmichaels(n);

		// In ra kết quả
		int count = carmichaels.size();
		int sum = 0;
		if (count == 0) {
			System.out.println("Không tìm thấy số Carmichael nào nhỏ hơn " + n + ".");
		} else {
			System.out.println("Tìm thấy " + count + " số Carmichael nhỏ hơn " + n + ":");
			for (int num : carmichaels) {
				System.out.print(num + " ");
				sum += num;
			}
			System.out.println("\nTổng các số Carmichael là :  " + sum);
		}
	}

	// Hàm tìm các số Carmichael nhỏ hơn N
	static List<Integer> findCarmichaels(int n) {
		List<Integer> carmichaels = new ArrayList<>();

		// Duyệt qua các số nguyên dương từ 2 đến N
		for (int num = 2; num <= n; num++) {
			// Kiểm tra xem num có phải là hợp số hay không
			if (!isPrime(num)) {
				// Kiểm tra xem num có phải là số Carmichael hay không
				if (isCarmichael(num)) {
					carmichaels.add(num);
				}
			}
		}

		return carmichaels;
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

	// Hàm kiểm tra số Carmichael
	static boolean isCarmichael(int n) {
		// Tìm λ là bội số nhỏ nhất của phi(n) sao cho λ ≡ 1 (mod n)
		int phiN = totient(n);
		int lambda = 1;
		while (lambda % n != 1) {
			lambda *= phiN;
		}

		// Kiểm tra điều kiện Carmichael với các số nguyên tố b nguyên tố cùng nhau với
		// n
		for (int b = 2; b * b <= n; b++) {
			if (isPrime(b) && gcd(b, n) == 1 && modPow(b, lambda - 1, n) != 1) {
				return false;
			}
		}

		return true;
	}

	// Hàm tính giá trị lũy thừa modulo
	static int modPow(int base, int exponent, int mod) {
		if (exponent == 0) {
			return 1;
		} else if (exponent % 2 == 1) {
			return (base * modPow(base, exponent - 1, mod)) % mod;
		} else {
			int temp = modPow(base, exponent / 2, mod);
			return (temp * temp) % mod;
		}
	}

	// Hàm tính bội số Euler (phi) của số nguyên dương n
	static int totient(int n) {
		if (n <= 1) {
			return 1;
		}

		int phi = n;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				phi *= (1 - (1.0 / i));
				while (n % i == 0) {
					n /= i;
				}
			}
		}

		if (n > 1) {
			phi *= (1 - (1.0 / n));
		}

		return phi;
	}

// Hàm tính ước chung lớn nhất (GCD) của hai số

	static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}