package nangcao;

import java.util.Arrays;
import java.util.Scanner;

public class cau33 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập đa thức a(x) từ bàn phím
		System.out.println(
				"Nhập đa thức a(x) (nhập các hệ số từ bậc cao nhất đến bậc thấp nhất, cách nhau bằng dấu cách): ");
		int[] a = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Đa thức bất khả quy g(x) = x^3 + x + 1
		int[] g = { 1, 0, 1, 1 }; // g(x) = x^3 + x + 1

		try {
			int[] inverse = extendedEuclidean(a, g, 2);
			System.out.println("Nghịch đảo của a(x) là: " + polynomialToString(inverse));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		scanner.close();
	}

	public static int[] extendedEuclidean(int[] a, int[] g, int p) {
		int[][] r = { g, a };
		int[][] s = { { 1 }, { 0 } };
		int[][] t = { { 0 }, { 1 } };

		while (!isZero(r[1])) {
			int[] q = polynomialDivide(r[0], r[1], p);
			int[] tempR = r[0];
			r[0] = r[1];
			r[1] = polynomialSubtract(tempR, polynomialMultiply(q, r[1], p), p);

			int[] tempS = s[0];
			s[0] = s[1];
			s[1] = polynomialSubtract(tempS, polynomialMultiply(q, s[1], p), p);

			int[] tempT = t[0];
			t[0] = t[1];
			t[1] = polynomialSubtract(tempT, polynomialMultiply(q, t[1], p), p);
		}

		if (!Arrays.equals(r[0], new int[] { 1 })) {
			throw new IllegalArgumentException("Không có nghịch đảo cho đa thức này.");
		}

		return t[0];
	}

	public static int[] polynomialDivide(int[] dividend, int[] divisor, int p) {
		int[] quotient = new int[dividend.length];
		int[] remainder = Arrays.copyOf(dividend, dividend.length);

		while (degree(remainder) >= degree(divisor)) {
			int coef = remainder[degree(remainder)];
			int deg = degree(remainder) - degree(divisor);
			int[] term = new int[deg + 1];
			term[deg] = coef;
			quotient = polynomialAdd(quotient, term, p);
			remainder = polynomialSubtract(remainder, polynomialMultiply(term, divisor, p), p);
		}

		return quotient;
	}

	public static int[] polynomialMod(int[] dividend, int[] divisor, int p) {
		int[] remainder = Arrays.copyOf(dividend, dividend.length);

		while (degree(remainder) >= degree(divisor)) {
			int coef = remainder[degree(remainder)];
			int deg = degree(remainder) - degree(divisor);
			int[] term = new int[deg + 1];
			term[deg] = coef;
			remainder = polynomialSubtract(remainder, polynomialMultiply(term, divisor, p), p);
		}

		return remainder;
	}

	public static int degree(int[] poly) {
		for (int i = poly.length - 1; i >= 0; i--) {
			if (poly[i] != 0) {
				return i;
			}
		}
		return -1;
	}

	public static int[] polynomialAdd(int[] a, int[] b, int p) {
		int[] result = new int[Math.max(a.length, b.length)];
		for (int i = 0; i < result.length; i++) {
			int ai = i < a.length ? a[i] : 0;
			int bi = i < b.length ? b[i] : 0;
			result[i] = (ai + bi) % p;
		}
		return result;
	}

	public static int[] polynomialSubtract(int[] a, int[] b, int p) {
		// Trên trường GF(2), phép trừ tương đương với phép cộng
		return polynomialAdd(a, b, p);
	}

	public static int[] polynomialMultiply(int[] a, int[] b, int p) {
		int[] result = new int[a.length + b.length - 1];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				result[i + j] = (result[i + j] + a[i] * b[j]) % p;
			}
		}
		return result;
	}

	public static boolean isZero(int[] poly) {
		for (int coef : poly) {
			if (coef != 0)
				return false;
		}
		return true;
	}

	public static String polynomialToString(int[] poly) {
		StringBuilder sb = new StringBuilder();
		boolean isFirst = true;
		for (int i = poly.length - 1; i >= 0; i--) {
			if (poly[i] != 0) {
				if (!isFirst) {
					sb.append(" + ");
				}
				if (i == 0) {
					sb.append(poly[i]);
				} else if (i == 1) {
					sb.append("x");
				} else {
					sb.append("x^").append(i);
				}
				isFirst = false;
			}
		}
		return sb.toString();
	}
}
