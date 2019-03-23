package assignment_8;

import java.util.ArrayList;

public class ass8b_ques10 {

	public static int count = 0;

	public static void main(String[] args) {
		// ques10(0, 0, 3, 3, "[0,0]");
		// System.out.println(count);
		ques10(0, 0, 3, 3, "[0,0]", 1);
		System.out.println(count);

	}

	public static void ques10(int cr, int cc, int er, int ec, String ans, int val) {
		int total = (er + 1) * (ec + 1);
		if (cr == er && cc == ec) {
			System.out.println(ans);
			count++;
			return;
		}
		if (cr > er || cc > ec) {
			return;
		}

		if (helper2(val, total)[1] == 1) {
			ques10(er, ec, er, ec, ans + " p[" + er + "," + ec + "] ", val);
		}
		// wall
		if (cr == er || cr == 0 || cc == ec || cc == 0) {
			if (cr == cc || cr + cc == er) {
				// bishop
				for (int move = 1; move <= er; move++) {
					if (helper2(helper1(cr + move, cc + move, er, ec), total)[0] != 1) {
						ques10(cr + move, cc + move, er, ec, ans + " b[" + (cr + move) + "," + (cc + move) + "] ",
								helper1(cr + move, cc + move, er, ec));
					}
				}

				// knights
				if (helper2(helper1(cr + 1, cc + 2, er, ec), total)[0] != 1) {
					ques10(cr + 1, cc + 2, er, ec, ans + " k[" + (cr + 1) + "," + (cc + 2) + "] ",
							helper1(cr + 1, cc + 2, er, ec));
				}
				if (helper2(helper1(cr + 2, cc + 1, er, ec), total)[0] != 1) {
					ques10(cr + 2, cc + 1, er, ec, ans + " k[" + (cr + 2) + "," + (cc + 1) + "] ",
							helper1(cr + 2, cc + 1, er, ec));
				}

				// rooks vertical
				for (int move = 1; move <= er; move++) {
					if (helper2(helper1(cr + move, cc, er, ec), total)[0] != 1) {
						ques10(cr + move, cc, er, ec, ans + " r[" + (cr + move) + "," + cc + "] ",
								helper1(cr + move, cc, er, ec));
					}
				}

				// rooks horizontal
				for (int move = 1; move <= ec; move++) {
					if (helper2(helper1(cr, cc + move, er, ec), total)[0] != 1) {
						ques10(cr, cc + move, er, ec, ans + " r[" + cr + "," + (cc + move) + "] ",
								helper1(cr, cc + move, er, ec));
					}
				}

			} else {

				// knights
				if (helper2(helper1(cr + 1, cc + 2, er, ec), total)[0] != 1) {
					ques10(cr + 1, cc + 2, er, ec, ans + " k[" + (cr + 1) + "," + (cc + 2) + "] ",
							helper1(cr + 1, cc + 2, er, ec));
				}
				if (helper2(helper1(cr + 2, cc + 1, er, ec), total)[0] != 1) {
					ques10(cr + 2, cc + 1, er, ec, ans + " k[" + (cr + 2) + "," + (cc + 1) + "] ",
							helper1(cr + 2, cc + 1, er, ec));
				}
				// rooks vertical
				for (int move = 1; move <= er; move++) {
					if (helper2(helper1(cr + move, cc, er, ec), total)[0] != 1) {
						ques10(cr + move, cc, er, ec, ans + " r[" + (cr + move) + "," + cc + "] ",
								helper1(cr + move, cc, er, ec));
					}
				}

				// rooks horizontal
				for (int move = 1; move <= ec; move++) {
					if (helper2(helper1(cr, cc + move, er, ec), total)[0] != 1) {
						ques10(cr, cc + move, er, ec, ans + " r[" + cr + "," + (cc + move) + "] ",
								helper1(cr, cc + move, er, ec));
					}
				}
			}
		} else if (cr == cc || cr + cc == er) {

			// bishop
			for (int move = 1; move <= er; move++) {
				if (helper2(helper1(cr + move, cc + move, er, ec), total)[0] != 1) {
					ques10(cr + move, cc + move, er, ec, ans + " b[" + (cr + move) + "," + (cc + move) + "] ",
							helper1(cr + move, cc + move, er, ec));
				}
			}

			// knights
			if (helper2(helper1(cr + 1, cc + 2, er, ec), total)[0] != 1) {
				ques10(cr + 1, cc + 2, er, ec, ans + " k[" + (cr + 1) + "," + (cc + 2) + "] ",
						helper1(cr + 1, cc + 2, er, ec));
			}
			if (helper2(helper1(cr + 2, cc + 1, er, ec), total)[0] != 1) {
				ques10(cr + 2, cc + 1, er, ec, ans + " k[" + (cr + 2) + "," + (cc + 1) + "] ",
						helper1(cr + 2, cc + 1, er, ec));
			}

		} else {
			// knights
			if (helper2(helper1(cr + 1, cc + 2, er, ec), total)[0] != 1) {
				ques10(cr + 1, cc + 2, er, ec, ans + " k[" + (cr + 1) + "," + (cc + 2) + "] ",
						helper1(cr + 1, cc + 2, er, ec));
			}
			if (helper2(helper1(cr + 2, cc + 1, er, ec), total)[0] != 1) {
				ques10(cr + 2, cc + 1, er, ec, ans + " k[" + (cr + 2) + "," + (cc + 1) + "] ",
						helper1(cr + 2, cc + 1, er, ec));
			}
		}

	}

	public static int helper1(int cr, int cc, int er, int ec) {
		int val = 0;
		int rv = 0;
		for (int r = 0; r <= er; r++) {
			for (int c = 0; c <= ec; c++) {
				val++;
				if (r == cr && c == cc) {
					rv = val;
					break;
				}
			}
		}
		return rv;
	}

	public static int[] helper2(int val, int n) {
		ArrayList<Integer> prime = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			if (june_7.prime.isprime(i)) {
				prime.add(i);
			}
		}
		ArrayList<Integer> mines = new ArrayList<>();
		ArrayList<Integer> ports = new ArrayList<>();

		for (int i = 0; i < prime.size(); i++) {
			mines.add(prime.get(i));
			i++;
			if (i < prime.size()) {
				ports.add(prime.get(i));
			}
		}

		Integer[] mr1 = mines.toArray(new Integer[mines.size()]);
		Integer[] mr2 = ports.toArray(new Integer[ports.size()]);
		int rv1 = june_14.binarysearch.binarysearch(mr1, val);
		int rv2 = june_14.binarysearch.binarysearch(mr2, val);
		int[] ra = new int[2];

		if (rv1 != -1) {
			ra[0] = 1;
		}

		if (rv2 != -1) {
			ra[1] = 1;
		}
		return ra;
	}

}
