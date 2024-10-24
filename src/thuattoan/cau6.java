package thuattoan;

import java.util.Scanner;

public class cau6 {
	// Hàm tính tổng các ước của một số trừ chính số đó
	public static int sumOfDivisors(int num) {
		int sum = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập N: ");
		int N = scanner.nextInt();

		System.out.println("Các cặp số thân thiết nhỏ hơn " + N + " là:");
		for (int i = 1; i < N; i++) {
			int sum1 = sumOfDivisors(i);
			if (sum1 > i && sum1 < N) { // Tránh việc kiểm tra lại cặp đã tìm thấy
				int sum2 = sumOfDivisors(sum1);
				if (sum2 == i) {
					System.out.println("(" + i + ", " + sum1 + ")");
				}
			}
		}
		scanner.close();
	}
}
