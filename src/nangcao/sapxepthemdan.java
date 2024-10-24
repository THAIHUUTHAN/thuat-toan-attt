package nangcao;

import java.util.Scanner;

public class sapxepthemdan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số phần tử cần sắp xếp n: ");
		int n = sc.nextInt();
		int[] K = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
			K[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) { // Bắt đầu từ 1
			int x = K[i];
			int j = i - 1;
			// Kiểm tra điều kiện của j trước khi truy cập K[j]
			while (j >= 0 && K[j] > x) {
				K[j + 1] = K[j];
				j--;
			}
			K[j + 1] = x;
		}

		System.out.println("Chuỗi sau khi sắp xếp là: ");
		for (int i = 0; i < n; i++) {
			System.out.print(K[i] + " ");
		}
		// Độ phức tạp O(n^2)
	}
}
