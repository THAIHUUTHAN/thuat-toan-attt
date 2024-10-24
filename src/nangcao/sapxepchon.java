package nangcao;

import java.util.Scanner;

public class sapxepchon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập so phan tu can sap xep n: ");
		int n = sc.nextInt();
		int[] K = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Nhap phan tu thu " + (i + 1) + " :");
			K[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			int m = i;
			for (int j = i + 1; j < n; j++) {
				if (K[j] < K[m])
					m = j;
				if (i < m) {
					int x = K[i];
					K[i] = K[m];
					K[m] = x;
				}
			}
		}
		System.out.println("Chuỗi sau khi sắp xếp là: ");
		for (int i = 0; i < n; i++) {
			System.out.print(K[i] + " ");
		}
		// độ phức tạp O(n^2)
	}
}
