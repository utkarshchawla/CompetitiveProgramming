package assignment_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class assignment_8b {

	public static int count = 0;

	public static void main(String[] args) {
		int n = 15;
		// Integer[] il = primeArrHelper(n);
		boolean[][] board = new boolean[5][5];
		// System.out.println(ques2list(2, 2));
		// ques2(2, 2, "");
		// System.out.println(ques5List(board, 0));
		ques7(0, "", n, new HashMap<>());
		// System.out.println(primeArrHelper(15));
		// primeArrHelper(15);
		// ques8(0, "1121", n, il);
		System.out.println(count);

	}

	public static ArrayList<String> ques1list(int n, int m) {
		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (n < 0) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		for (int dice = 1; dice <= m; dice++) {
			ArrayList<String> rr = ques1list(n - dice, m);
			for (String rs : rr) {
				mr.add(rs + dice);
			}
		}
		return mr;
	}

	public static void ques1(int n, String ans, int m) {
		if (n == 0) {
			System.out.println(ans);
			count++;
			return;
		}
		if (n < 0) {
			return;
		}

		for (int dice = 1; dice <= m; dice++) {
			ques1(n - dice, ans + dice, m);
		}
	}

	public static ArrayList<String> ques2list(int r, int c) {
		if (c == 0 && r == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if (r < 0 || c < 0) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr1 = ques2list(r, c - 1);
		for (String rs : rr1) {
			mr.add(rs + "H");
		}

		ArrayList<String> rr2 = ques2list(r - 1, c);
		for (String rs : rr2) {
			mr.add(rs + "V");
		}
		return mr;
	}

	public static void ques2(int r, int c, String ans) {

		if (r == 0 && c == 0) {
			System.out.println(ans);
			count++;
			return;
		}

		if (r < 0 || c < 0) {
			return;
		}
		ques2(r, c - 1, ans + "H");
		ques2(r - 1, c, ans + "V");
	}

	public static ArrayList<String> ques3list(int r, int c) {
		if (c == 0 && r == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		if (c > 0) {
			ArrayList<String> rr = ques3list(r, c - 1);
			for (String rs : rr) {
				mr.add(rs + "H");
			}
		}
		if (r > 0) {
			ArrayList<String> rr = ques3list(r - 1, c);
			for (String rs : rr) {
				mr.add(rs + "V");
			}
		}
		if (r > 0 && c > 0) {
			ArrayList<String> rr = ques3list(r - 1, c - 1);
			for (String rs : rr) {
				mr.add(rs + "D");
			}
		}
		return mr;
	}

	public static void ques3(int r, int c, String ans) {
		if (r == 0 && c == 0) {
			System.out.print(ans + ", ");
			count++;
			return;
		}

		if (r < 0 || c < 0) {
			return;
		}
		ques3(r, c - 1, ans + "H");
		ques3(r - 1, c, ans + "V");
		ques3(r - 1, c - 1, ans + "D");
	}

	public static ArrayList<String> ques4list(int r, int c) {
		if (c == 0 && r == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		if (c > 0) {
			ArrayList<String> rr = ques4list(r, c - 1);
			for (String rs : rr) {
				mr.add(rs + "H");
			}
		}
		if (r > 0) {
			ArrayList<String> rr = ques4list(r - 1, c);
			for (String rs : rr) {
				mr.add(rs + "V");
			}
		}
		if (r > 0 && r == c) {
			ArrayList<String> rr = ques4list(r - 1, c - 1);
			for (String rs : rr) {
				mr.add(rs + "D");
			}
		}
		return mr;
	}

	public static void ques4(int r, int c, String ans) {
		if (r == 0 && c == 0) {
			System.out.print(ans + ", ");
			count++;
			return;
		}

		if (r < 0 || c < 0) {
			return;
		}
		ques4(r, c - 1, ans + "H");
		ques4(r - 1, c, ans + "V");
		if (r == c) {
			ques4(r - 1, c - 1, ans + "D");
		}
	}

	public static void ques5(boolean[][] board, int qpsf, String ans) {
		if (qpsf == board.length) {
			System.out.println(ans);
			count++;
			return;
		}

		int row = qpsf;
		for (int col = 0; col < board.length; col++) {
			board[row][col] = true;
			if (ques5helper(board, row, col)) {
				ques5(board, qpsf + 1, ans + "[" + row + ", " + col + "]");
			}
			board[row][col] = false;
		}
	}

	public static ArrayList<String> ques5List(boolean[][] board, int qpsf) {
		if (qpsf == board.length) {
			ArrayList<String> br = new ArrayList<>();
			br.add(" ");
			return br;
		}

		int row = qpsf;
		ArrayList<String> mr = new ArrayList<>();
		for (int col = 0; col < board.length; col++) {
			board[row][col] = true;
			if (ques5helper(board, row, col)) {
				ArrayList<String> rr = ques5List(board, qpsf + 1);
				for (String rs : rr) {
					mr.add(rs + "[" + row + ", " + col + "]");
				}
			}
			board[row][col] = false;
		}
		return mr;
	}

	public static boolean ques5helper(boolean board[][], int row, int col) {
		int r = row - 1;
		int c = col;
		while (r >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
		}

		r = row - 1;
		c = col - 1;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}

		r = row - 1;
		c = col + 1;
		while (r >= 0 && c < board.length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}

		return true;
	}

	public static HashMap<Integer, Integer> primeArrHelper(int n) {
		ArrayList<Integer> ra = new ArrayList<>();

		boolean[] arr = new boolean[n + 1];
		Arrays.fill(arr, true);
		arr[0] = arr[1] = false;

		for (int i = 2; i * i <= n; i++) {
			if (arr[i] == false) {
				continue;
			}

			for (int j = 2; i * j <= n; j++) {
				arr[i * j] = false;
			}

		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true) {
				ra.add(i);
			}
		}

		HashMap<Integer, Integer> ladder = new HashMap<>();
		int left = 0;
		int right = ra.size() - 1;

		while (left < right) {
			ladder.put(ra.get(left), ra.get(right));
			left++;
			right--;
		}

		return ladder;

	}

	public static void ques7(int c, String ans, int n, HashMap<Integer, Integer> ladder) {
		ladder = primeArrHelper(n);
		if (c == n) {
			System.out.println(ans);
			count++;
			return;
		}
		if (c > n) {
			return;
		}

		if (ladder.containsKey(c)) {
			ques7(ladder.get(c), ans + " [" + c + " to " + ladder.get(c) + "] ", n, ladder);
		} else {
			for (int dice = 1; dice <= 6; dice++) {
				ques7(c + dice, ans + dice, n, ladder);
			}
		}

	}

	public static void ques8(int c, String ans, int n, Integer[] il) {
		if (c == n) {
			if (ans.length() == 0) {
				System.out.println("true");
				System.exit(0);
				return;
			}
		} else if (ans.length() == 0) {
			System.out.println("false");
			System.exit(0);
			return;
		}
		if (c > n) {
			System.out.println("false");
			System.exit(0);
			return;
		}

		int dice = ans.charAt(0) - '0';
		String roa = ans.substring(1);

		// ladder
		if (june_7.prime.isprime(c) && c < n / 2) {
			int ladder = ques8helper(il, c)[0];
			if (ladder != -1) {
				ques8(ladder, ans, n, il);
			} else {
				ques8(c + dice, roa, n, il);
			}

		}
		// snake
		else if (june_7.prime.isprime(c) && c >= n / 2) {
			int snake = ques8helper(il, c)[1];
			if (snake != -1) {
				ques8(snake, ans, n, il);
			} else {
				ques8(c + dice, roa, n, il);
			}
		}
		// normal
		else {

			ques8(c + dice, roa, n, il);
		}

	}

	public static int[] ques8helper(Integer[] mr, int m) {
		ArrayList<Integer> il = new ArrayList<>();
		for (int i = 0; i < mr.length; i++) {
			il.add(mr[i]);
		}
		ArrayList<Integer> ladder = new ArrayList<>();
		ArrayList<Integer> snake = new ArrayList<>();
		if (il.size() % 2 == 0) {
			il.add(il.size() / 2, il.get(il.size() / 2) + 1);
		}

		for (int i = 0; i < il.size(); i++) {
			ladder.add(il.get(i));
			i++;
			if (i < il.size()) {
				snake.add(il.get(i));
			}
		}

		int[] ra = new int[2];
		Integer[] mr1 = ladder.toArray(new Integer[ladder.size()]);
		Integer[] mr2 = snake.toArray(new Integer[snake.size()]);
		int rv1 = june_14.binarysearch.binarysearch(mr1, m);
		int rv2 = june_14.binarysearch.binarysearch(mr2, m);

		if (rv1 == -1) {
			ra[0] = -1;
		} else {
			ra[0] = ladder.get(ladder.size() - rv1 - 1);

		}

		if (rv2 == -1) {
			ra[1] = -1;
		} else {
			ra[1] = snake.get(snake.size() - rv2 - 1);
		}
		return ra;
	}

}
