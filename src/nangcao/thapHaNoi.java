package nangcao;

import java.util.Scanner;

public class thapHaNoi {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập số lượng đĩa: ");
		int n = scanner.nextInt();

		hanoi(n, 'A', 'C', 'B');
	}

	// Hàm đệ quy để giải bài toán Tháp Hà Nội
	public static void hanoi(int n, char cot_di, char cot_dich, char cot_trunggian) {
		if (n == 1) {
			System.out.println("Chuyển đĩa 1 từ cột " + cot_di + " sang cột " + cot_dich);
			return;
		}
		hanoi(n - 1, cot_di, cot_trunggian, cot_dich);
		System.out.println("Chuyển đĩa " + n + " từ cột " + cot_di + " sang cột " + cot_dich);
		hanoi(n - 1, cot_trunggian, cot_dich, cot_di);
	}
}
