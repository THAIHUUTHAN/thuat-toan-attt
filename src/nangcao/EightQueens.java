package nangcao;

public class EightQueens {
	private int[] result;
	private int N = 8;

	public EightQueens() {
		result = new int[N];
	}

	public void solve() {
		solve(0);
	}

	private boolean isSafe(int row, int col) {
		// Kiểm tra hàng và các đường chéo
		for (int i = 0; i < row; i++) {
			if (result[i] == col || Math.abs(result[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}
		return true;
	}

	private void solve(int row) {
		if (row == N) {
			printSolution();
			return;
		}

		for (int col = 0; col < N; col++) {
			if (isSafe(row, col)) {
				result[row] = col;
				solve(row + 1);
			}
		}
	}

	private void printSolution() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (result[i] == j) {
					System.out.print("Q ");
				} else {
					System.out.print(". ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		EightQueens queens = new EightQueens();
		queens.solve();
	}
}