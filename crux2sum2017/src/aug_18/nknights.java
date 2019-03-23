package aug_18;

public class nknights {
	public static int count = 0;

	public static void main(String[] args) {
		int n = 3;
		boolean[][] board = new boolean[n][n];
		printNKnights(1, board, 0, "");
		System.out.println(count);

	}

	public static void printNKnights(int cell, boolean[][] board, int kpsf, String ans) {
		if (kpsf == board.length) {
			System.out.println(ans);
			count++;
			return;
		}

		for (int i = cell; i <= board.length * board.length; i++) {

			int cr = (i - 1) / board.length;
			int cc = (i - 1) % board.length;
			if (isitsafe(cr, cc, board)) {
				board[cr][cc] = true;
				printNKnights(i + 1, board, kpsf + 1, ans + "[" + cr + "," + cc + "]");
				board[cr][cc] = false;
			}
		}

	}

	private static boolean isitsafe(int cr, int cc, boolean[][] board) {
		if (cr - 1 >= 0 && cc - 2 >= 0 && board[cr - 1][cc - 2] == true) {
			return false;
		}

		if (cr - 1 >= 0 && cc + 2 <= board.length - 1 && board[cr - 1][cc + 2] == true) {
			return false;
		}

		if (cr - 2 >= 0 && cc - 1 >= 0 && board[cr - 2][cc - 1] == true) {
			return false;
		}

		if (cr - 2 >= 0 && cc + 1 <= board.length - 1 && board[cr - 2][cc + 1] == true) {
			return false;
		}

		return true;

	}

}
