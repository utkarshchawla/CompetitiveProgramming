package july_5;

public class july_5 {

	public static void main(String[] args) {
		int n = 20;
		int[] strg = new int[11];
		// System.out.println(cbp(0, 10, strg));
		// System.out.println(cmp(0, 0, n, n, new int[n + 1][n + 1]));
		// System.out.println(cbpitr(10));
		// System.out.println(cbpsw(10));
		System.out.println(cmpi(3, 3));
		System.out.println(cmpsw(3, 3));
	}

	public static int cbp(int cur, int end, int[] strg) {
		if (cur == end) {
			return 1;
		}

		if (cur > end) {
			return 0;
		}

		if (strg[cur] != 0) {
			return strg[cur];
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += cbp(cur + dice, end, strg);
		}
		strg[cur] = count;

		return count;
	}

	public static int cmp(int cr, int cc, int er, int ec, int strg[][]) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}
		int ch = cmp(cr, cc + 1, er, ec, strg);
		int cv = cmp(cr + 1, cc, er, ec, strg);
		int count = ch + cv;
		strg[cr][cc] = count;

		return count;
	}

	public static int cbpitr(int n) {

		int[] strg = new int[n + 6];
		strg[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= 6; j++) {
				strg[i] += strg[j + i];
			}
		}

		return strg[0];

	}

	public static int cbpsw(int n) {
		int[] strg = new int[6];
		strg[0] = 1;
		for (int i = 0; i < n; i++) {
			int nv = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = nv;

		}
		return strg[0];
	}

	public static int cmpi(int er, int ec) {
		int strg[][] = new int[er + 1][ec + 1];
		strg[er][ec] = 1;
		for (int r = er; r >= 0; r--) {
			for (int c = ec; c >= 0; c--) {
				if (r == er && c == ec) {

				} else if (r == er) {
					strg[r][c] = strg[r][c + 1];
				} else if (c == ec) {
					strg[r][c] = strg[r + 1][c];
				} else {
					strg[r][c] = strg[r + 1][c] + strg[r][c + 1];
				}
			}
		}
		return strg[0][0];
	}

	public static int cmpsw(int er, int ec) {
		int strg[] = new int[ec + 1];
		for (int i = 0; i < strg.length; i++) {
			strg[i] = 1;
		}

		for (int r = 0; r < er; r++) {
			for (int c = strg.length - 1; c >= 0; c--) {
				if (c != strg.length - 1) {
					strg[c] += strg[c + 1];
				}
			}
		}

		return strg[0];

	}

	public static int cmpdi(int er, int ec) {
		int strg[][] = new int[er + 1][ec + 1];
		strg[er][ec] = 1;
		for (int r = er; r >= 0; r--) {
			for (int c = ec; c >= 0; c--) {
				if (r == er && c == ec) {

				} else if (r == er) {
					strg[r][c] = strg[r][c + 1];
				} else if (c == ec) {
					strg[r][c] = strg[r + 1][c];
				} else {
					strg[r][c] = strg[r + 1][c] + strg[r][c + 1];
				}
			}
		}
		return strg[0][0];
	}

	
}
