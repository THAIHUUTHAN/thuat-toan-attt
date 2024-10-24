package nangcao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class cau36 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		// Nhập chuỗi văn bản S2
		System.out.print("Nhập chuỗi văn bản S2: ");
		String text = scanner.nextLine();

		// Nhập chuỗi cần tìm S1
		System.out.print("Nhập chuỗi cần tìm S1: ");
		String pattern = scanner.nextLine();

		// Tạo bảng last và skip
		Map<Character, Integer> last = buildLastTable(pattern);
		Map<Character, Integer> skip = buildSkipTable(pattern);

		// Tìm kiếm chuỗi S1 trong chuỗi S2
		int index = find(text, pattern, last, skip);

		// In kết quả tìm kiếm
		if (index != -1) {
			System.out.println("Tìm thấy \"" + pattern + "\" tại vị trí: " + index);
		} else {
			System.out.println("Không tìm thấy \"" + pattern + "\"");
		}

		// In giá trị của bảng last và skip
		printTables(last, skip);
	}

	// Hàm tạo bảng last
	private static Map<Character, Integer> buildLastTable(String pattern) {
		Map<Character, Integer> last = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			last.put(pattern.charAt(i), i);
		}
		return last;
	}

	// Hàm tạo bảng skip (sửa lỗi)
	private static Map<Character, Integer> buildSkipTable(String pattern) {
		// Tạo HashMap để lưu giá trị skip
		Map<Character, Integer> skip = new HashMap<>();

		// Khởi tạo giá trị mặc định cho skip
		for (int i = 0; i < 256; i++) {
			skip.put((char) i, pattern.length());
		}

		// Cập nhật giá trị skip cho các ký tự trong mẫu
		for (int i = 0; i < pattern.length() - 1; i++) {
			skip.put(pattern.charAt(i), pattern.length() - i - 1);
		}

		return skip;
	}

	private static int find(String text, String pattern, Map<Character, Integer> last, Map<Character, Integer> skip) {
		int n = text.length();
		int m = pattern.length();

		int i = n - m; // Bắt đầu tìm kiếm từ cuối chuỗi văn bản

		while (i >= 0) {
			for (int j = m - 1; j >= 0; j--) {
				if (text.charAt(i + j) != pattern.charAt(j)) {
					i -= skip.getOrDefault(text.charAt(i + j), m); // Bỏ qua dựa vào bảng skip
					break;
				}

				if (j == 0) {
					return i; // Tìm thấy
				}
			}
		}

		return -1; // Không tìm thấy

	}

	// Hàm in giá trị của bảng last và skip
	private static void printTables(Map<Character, Integer> last, Map<Character, Integer> skip) {
		System.out.println("\nBảng last:");
		for (Map.Entry<Character, Integer> entry : last.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		System.out.println("\nBảng skip:");
		for (Map.Entry<Character, Integer> entry : skip.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
}
