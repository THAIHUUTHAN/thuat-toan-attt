package thuattoan;

import java.util.Scanner;

public class decimaltobinary {
	public static void main(String[] args) {
		System.out.println("Nhập số thập phân cần chuyển đổi: ");
		Scanner scanner = new Scanner(System.in);
		int decimalNumber = scanner.nextInt(); // Số thập phân cần chuyển đổi
		StringBuilder binaryString = new StringBuilder();

		while (decimalNumber > 0) {
			int remainder = decimalNumber % 2;
			binaryString.insert(0, remainder); // Thêm số dư vào đầu chuỗi
			decimalNumber /= 2;
		}
		while (binaryString.length() < 16) { // Bổ sung 0 vào bên trái
			binaryString.insert(0, "0");
		}

		System.out.println("Số nhị phân 16 bit của " + decimalNumber + " là: " + binaryString);
	}
}
