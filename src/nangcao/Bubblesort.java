package nangcao;

import java.util.Scanner;

public class Bubblesort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số phần tử cần sắp xếp n: ");
		int n = sc.nextInt();
		int[] K = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
			K[i] = sc.nextInt();
		}

		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (K[j] < K[j - 1]) {
					int x = K[j];
					K[j] = K[j - 1];
					K[j - 1] = x;
				}
			}
		}
		System.out.println("Chuỗi sau khi sắp xếp là: ");
		for (int i = 0; i < n; i++) {
			System.out.print(K[i] + " ");
		}
		// Độ phức tạp O(n^2)

	}
}
