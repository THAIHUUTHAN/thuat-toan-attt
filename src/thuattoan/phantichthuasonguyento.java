package thuattoan;

import java.util.Scanner;

public class phantichthuasonguyento {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int i = 2;
		while (n > 1) {
			if (n % i == 0) {
				System.out.print(i + "*");
				n = n / i;
			} else {
				i++;
				n = n;
			}
		}

	}
}
