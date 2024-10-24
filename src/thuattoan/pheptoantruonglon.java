package thuattoan;

import java.util.ArrayList;
import java.util.Scanner;

public class pheptoantruonglon {
	public static ArrayList<Integer> biendoi(int a, int W, int p) {
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

	public static ArrayList<Integer> phepcong(ArrayList A, ArrayList B, int W, int p) {
		ArrayList<Integer> result = new ArrayList<>();
		int epsilon = 0;
		int e = (int) Math.pow(2, 8);

		for (int i = A.size() - 1; i >= 0; i--) {
			int s = (int) A.get(i) + (int) B.get(i) + epsilon;
			int x = s % e;
			if (s > e)
				epsilon = 1;
			else
				epsilon = 0;
			result.add(0, x);

		}
		result.add(0, epsilon);
		return result;
	}

	public static ArrayList<Integer> pheptru(ArrayList A, ArrayList B, int W, int p) {
		ArrayList<Integer> result = new ArrayList<>();
		int epsilon = 0;
		int e = (int) Math.pow(2, 8);
		for (int i = A.size() - 1; i >= 0; i--) {
			int s = (int) A.get(i) - (int) B.get(i) - epsilon;
			int x = s % e;
			if (s > e)
				epsilon = 1;
			else
				epsilon = 0;
			result.add(0, x);

		}
		result.add(0, epsilon);
		return result;
	}

	public static ArrayList<Integer> phepcongtrenp(ArrayList A, ArrayList P, ArrayList B, int W, int p) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> C = phepcong(A, B, W, p);
		int epsilon = C.get(0);
		C.remove(0);
		if (epsilon == 1) {
			result = pheptru(C, P, W, p);
			result.remove(0);
		} else
			result = C;
		return result;
	}

	public static ArrayList<Integer> pheptrutrenp(ArrayList A, ArrayList P, ArrayList B, int W, int p) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> C = pheptru(A, B, W, p);
		int epsilon = C.get(0);
		C.remove(0);
		if (epsilon == 1) {
			result = phepcong(C, P, W, p);
			result.remove(0);
		} else
			result = C;
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int W = 8;
		int p = 2147483647;
		ArrayList<Integer> P = new ArrayList<Integer>();
		P = biendoi(p, W, p);
		ArrayList<Integer> A = biendoi(a, W, p);
		ArrayList<Integer> B = biendoi(b, W, p);
		System.out.println(A);
		System.out.println(B);
		ArrayList<Integer> C = phepcong(A, B, W, p);
		System.out.println(C);
		ArrayList<Integer> D = pheptru(A, B, W, p);
		System.out.println(D);
		ArrayList<Integer> E = phepcongtrenp(A, P, B, W, p);
		System.out.println(E);
		ArrayList<Integer> F = pheptrutrenp(A, P, B, W, p);
		System.out.println(F);

	}

}
