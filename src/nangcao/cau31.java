package nangcao;

import java.util.Scanner;

public class cau31 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Nhập mã số sinh viên
		System.out.print("Nhập mã số sinh viên: ");
		String maSoSinhVien = sc.nextLine();

		// Tìm phần số của mã số sinh viên
		int phanSo = 0;
		for (int i = 0; i < maSoSinhVien.length(); i++) {
			if (maSoSinhVien.charAt(i) >= '0' && maSoSinhVien.charAt(i) <= '9') {
				phanSo = phanSo * 10 + (maSoSinhVien.charAt(i) - '0');
			}
		}

		// Tìm số nguyên tố k gần nhất với phần số
		int k = timSoNguyenToGanNhat(phanSo);

		// Nhập a và n
		System.out.print("Nhập a: ");
		int a = sc.nextInt();
		System.out.print("Nhập n: ");
		int n = sc.nextInt();

		// Tính a^k mod n
		int akModN = tinhAkModN(a, k, n);

		// Hiển thị kết quả
		System.out.println("Số nguyên tố k gần nhất với phần số: " + k);
		System.out.println("Kết quả: " + akModN);
	}

	// Hàm tìm số nguyên tố k gần nhất với số nguyên dương n
	private static int timSoNguyenToGanNhat(int n) {
		// Sử dụng thuật toán sàng nguyên thủy
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= n; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= n; j += i) {
					isPrime[j] = false;
				}
			}
		}

		// Tìm số nguyên tố gần nhất với n
		int k = n;
		for (int i = n - 1; i >= 2; i--) {
			if (isPrime[i]) {
				k = i;
				break;
			}
		}

		return k;
	}

	// Hàm tính a^k mod n
	private static int tinhAkModN(int a, int k, int n) {
		long result = 1;
		for (int i = 0; i < k; i++) {
			result *= a;
			result %= n;
		}

		return (int) result;
	}
}
