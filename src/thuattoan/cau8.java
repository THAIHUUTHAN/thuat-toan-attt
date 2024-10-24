package thuattoan;

import java.util.Scanner;

public class cau8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập N: ");
		int n = sc.nextInt();

		int count = 0;
		for (int i = 2; i <= n; i++) {
			if (countNumberOfFactors(i) == 3) {
				count++;
				System.out.print(i + " ");
			}
		}
		System.out.println("\nCó " + count + " số T-prime nhỏ hơn hoặc bằng " + n);
	}

	private static int countNumberOfFactors(int n) {
		int count = 0;
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (n / i == i) {
					count++;
				} else {
					count += 2;
				}
			}
		}
		return count;
	}
}
