package nangcao;

import java.util.Scanner;

public class Quicksort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số phần tử cần sắp xếp n: ");
		int n = sc.nextInt();
		int[] K = new int[n];

		for (int i = 0; i < n; i++) {
			System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
			K[i] = sc.nextInt();
		}

		quicksort(K, 0, n - 1); // Sắp xếp mảng từ chỉ số 0 đến n-1

		System.out.print("Mảng sau khi sắp xếp: ");
		for (int num : K) {
			System.out.print(num + " ");
		}
	}

	public static int partition(int[] K, int l, int r) {
		int pivot = K[r]; // Chọn giá trị chốt là phần tử cuối
		int i = l - 1; // Chỉ số của phần tử nhỏ hơn pivot

		for (int j = l; j < r; j++) {
			if (K[j] < pivot) {
				i++;
				int temp = K[i];
				K[i] = K[j];
				K[j] = temp;
			}
		}

		// Đổi chỗ pivot về đúng vị trí
		int temp = K[i + 1];
		K[i + 1] = K[r];
		K[r] = temp;

		return i + 1; // Trả về vị trí của pivot
	}

	public static void quicksort(int[] K, int l, int r) {
		if (l < r) {
			// Phân hoạch mảng và lấy vị trí của chốt
			int pivotIndex = partition(K, l, r);

			// Đệ quy sắp xếp mảng bên trái và mảng bên phải
			quicksort(K, l, pivotIndex - 1); // Mảng trái
			quicksort(K, pivotIndex + 1, r); // Mảng phải
		}
	}
}
