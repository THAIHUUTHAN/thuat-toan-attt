package thuattoan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class biendoiso {

	public static ArrayList<Integer> solve(int a, int W, int p) {
		ArrayList<Integer> result = new ArrayList<>();
		int m = (int) Math.round(Math.log(p) / Math.log(2));
		int t = (int) Math.round((double) m / W);
		ArrayList<Integer> n = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			n.add((int) Math.pow(2, i * W));
		}

		for (int i = n.size() - 1; i >= 0; i--) {
			int value = n.get(i);
			result.add(a / value);
			a = a % value;
		}

		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap so can bien doi: ");
		int a = sc.nextInt();
		int W = 8;
		int p = 2147483647;

		List<Integer> result = solve(a, W, p);

		System.out.println(result);
	}

}