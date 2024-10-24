package nangcao;

import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class cau32 {

	public static void main(String[] args) {
		Random rnd = new Random();

		// Tìm số nguyên tố p, q
		int p = 0, q = 0;
		while (p == q || p < 100 || p > 500 || !isPrime(p)) {
			p = rnd.nextInt(500) + 100;
		}
		while (q == p || q < 100 || q > 500 || !isPrime(q)) {
			q = rnd.nextInt(500) + 100;
		}

		// Tính n và pi(n)
		int n = p * q;
		int phiN = (p - 1) * (q - 1);

		// Chọn e và tính d
		int e = 0;
		while (e == 0 || gcd(e, phiN) != 1) {
			e = rnd.nextInt(phiN) + 1;
		}
		int d = modInverse(e, phiN);

		// Nhập thông điệp
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập thông điệp: ");
		String message = sc.nextLine();

		// Chuyển đổi thông điệp thành số
		int m = Integer.parseInt(message) + 123;

		// Mã hóa thông điệp
		BigInteger c = BigInteger.valueOf(m).pow(e).mod(BigInteger.valueOf(n));

		// Hiển thị bản mã
		System.out.println("Bản mã: " + c);

		// Giải mã thông điệp
		BigInteger mDec = c.pow(d).mod(BigInteger.valueOf(n));
		int messageDec = mDec.intValue() - 123;

		// Hiển thị thông điệp giải mã
		System.out.println("Thông điệp giải mã: " + messageDec);
	}

	// Hàm kiểm tra số nguyên tố
	private static boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	// Hàm tính nghịch đảo modulo
	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	private static int modInverse(int a, int m) {
		int x = 0, y = 1;

		for (int i = 1; i <= m; i++) {
			if (((a * x) % m) == 1) {
				return x;
			}

			int temp = x;
			x = y;
			y = temp - ((a * y) % m);
		}

		return -1;
	}
}
