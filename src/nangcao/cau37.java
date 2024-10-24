package nangcao;

import java.util.Scanner;

public class cau37 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập chuỗi văn bản S2
		System.out.print("Nhập chuỗi văn bản S2: ");
		String text = scanner.nextLine();

		// Nhập chuỗi cần tìm S1
		System.out.print("Nhập chuỗi cần tìm S1: ");
		String pattern = scanner.nextLine();

		// Tìm kiếm chuỗi S1 trong chuỗi S2
		int index = find(text, pattern);

		// In kết quả tìm kiếm
		if (index != -1) {
			System.out.println("Tìm thấy \"" + pattern + "\" tại vị trí: " + index);
		} else {
			System.out.println("Không tìm thấy \"" + pattern + "\"");
		}
	}

	// Hàm tìm kiếm chuỗi S1 trong chuỗi S2
	private static int find(String text, String pattern) {
		int[] lps = computeLPSArray(pattern); // Tính bảng LPS
		int i = 0; // Chỉ số vị trí hiện tại trong chuỗi văn bản
		int j = 0; // Chỉ số vị trí hiện tại trong chuỗi cần tìm

		while (i < text.length()) {
			if (text.charAt(i) == pattern.charAt(j)) {
				i++;
				j++;

				if (j == pattern.length()) {
					return i - j; // Tìm thấy chuỗi
				}
			} else {
				if (j == 0) {
					i++; // Di chuyển vị trí trong chuỗi văn bản
				} else {
					j = lps[j - 1]; // Quay lại vị trí trước trong chuỗi cần tìm
				}
			}
		}

		return -1; // Không tìm thấy chuỗi
	}

	// Hàm tính toán bảng LPS (Longest Proper Prefix Suffix)
	private static int[] computeLPSArray(String pattern) {
		int[] lps = new int[pattern.length()];
		int i = 0;
		int j = 1;

		while (j < pattern.length()) {
			if (pattern.charAt(i) == pattern.charAt(j)) {
				lps[j] = i + 1;
				i++;
				j++;
			} else {
				if (i == 0) {
					lps[j] = 0;
					j++;
				} else {
					i = lps[i - 1];
				}
			}
		}

		return lps;
	}
}
