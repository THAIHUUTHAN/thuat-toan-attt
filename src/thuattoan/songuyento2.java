package thuattoan;

import java.util.Scanner;

public class songuyento2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		sangnguyenthuy(n);
	}

	public static void sangnguyenthuy(int n) {
		// Tạo mảng boolean để đánh dấu các số nguyên tố
		boolean[] a = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			a[i] = true;
		}

		for (int p = 2; p * p <= n; p++) {
			// Nếu prime[p] chưa bị đánh dấu là false thì nó là số nguyên tố
			if (a[p]) {
				// Đánh dấu tất cả các bội số của p là không phải số nguyên tố
				for (int i = p * p; i <= n; i += p) {
					a[i] = false;
				}
			}
		}
		// In các số nguyên tố
		for (int i = 2; i <= n; i++) {
			if (a[i]) {
				System.out.print(i + " ");
			}
		}
	}

}
