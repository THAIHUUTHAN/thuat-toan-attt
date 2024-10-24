package thuattoan;

import java.util.ArrayList;
import java.util.Scanner;

public class euclidemorong {

	public static ArrayList<Integer> Euclide(int a, int b) {
		ArrayList<Integer> result = new ArrayList<>();
		int x1 = 0, x2 = 1, y1 = 1, y2 = 0;
		int x, y;
		if (b == 0) {
			result.add(0, 0);
			result.add(0, 1);
			result.add(0, a);
		} else {
			while (b > 0) {
				int q = a / b;
				int r = a - q * b;
				x = x2 - q * x1;
				y = y2 - q * y1;

				a = b;
				b = r;
				x2 = x1;
				x1 = x;
				y2 = y1;
				y1 = y;
			}
			result.add(0, y2);
			result.add(0, x2);
			result.add(0, a);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap vao 2 so a va b (a>=b) : ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		ArrayList c = Euclide(a, b);
		System.out.println(c);

	}

}
