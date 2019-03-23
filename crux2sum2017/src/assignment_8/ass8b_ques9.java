package assignment_8;

public class ass8b_ques9 {

	public static int count = 0;

	public static void main(String[] args) {
		ques9(0, 0, 3, 3, "[0,0]");
		System.out.println(count);

	}

	public static void ques9(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			count++;
			return;
		}
		if (cr > er || cc > ec) {
			return;
		}
		// wall
		if (cr == er || cr == 0 || cc == ec || cc == 0) {
			if (cr == cc || cr + cc == er) {
				// bishop
				for (int move = 1; move <= er; move++) {
					ques9(cr + move, cc + move, er, ec, ans + " b[" + (cr + move) + "," + (cc + move) + "] ");
				}

				// knights
				ques9(cr + 1, cc + 2, er, ec, ans + " k[" + (cr + 1) + "," + (cc + 2) + "] ");
				ques9(cr + 2, cc + 1, er, ec, ans + " k[" + (cr + 2) + "," + (cc + 1) + "] ");

				// rooks vertical
				for (int move = 1; move <= er; move++) {
					ques9(cr + move, cc, er, ec, ans + " r[" + (cr + move) + "," + cc + "] ");
				}

				// rooks horizontal
				for (int move = 1; move <= ec; move++) {
					ques9(cr, cc + move, er, ec, ans + " r[" + cr + "," + (cc + move) + "] ");
				}

			} else {

				// knights
				ques9(cr + 1, cc + 2, er, ec, ans + " k[" + (cr + 1) + "," + (cc + 2) + "] ");
				ques9(cr + 2, cc + 1, er, ec, ans + " k[" + (cr + 2) + "," + (cc + 1) + "] ");

				// rooks vertical
				for (int move = 1; move <= er; move++) {
					ques9(cr + move, cc, er, ec, ans + " r[" + (cr + move) + "," + cc + "] ");
				}

				// rooks horizontal
				for (int move = 1; move <= ec; move++) {
					ques9(cr, cc + move, er, ec, ans + " r[" + cr + "," + (cc + move) + "] ");
				}
			}
		} else if (cr == cc || cr + cc == er) {

			// bishop
			for (int move = 1; move <= er; move++) {
				ques9(cr + move, cc + move, er, ec, ans + " b[" + (cr + move) + "," + (cc + move) + "] ");
			}

			// knights
			ques9(cr + 1, cc + 2, er, ec, ans + " k[" + (cr + 1) + "," + (cc + 2) + "] ");
			ques9(cr + 2, cc + 1, er, ec, ans + " k[" + (cr + 2) + "," + (cc + 1) + "] ");

		} else {
			// knights
			ques9(cr + 1, cc + 2, er, ec, ans + " k[" + (cr + 1) + "," + (cc + 2) + "] ");
			ques9(cr + 2, cc + 1, er, ec, ans + " k[" + (cr + 2) + "," + (cc + 1) + "] ");

		}

	}

}
