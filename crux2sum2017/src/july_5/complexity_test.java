package july_5;

import java.util.Arrays;

public class complexity_test {

	public static void main(String[] args) {
		// System.out.println(cbp(new int[11], 0, 10));
		// System.out.println(cmp(0, 0, 2, 2, new int[3][3]));
		// System.out.println(cbpi(5));
		// System.out.println(cbpsw(5));
		// System.out.println(cmpi(3, 3));
		// System.out.println(cmpsw(3, 3));
		// System.out.println(cmpdsw(3, 3));
		System.out.println(lsc("abdf", "adfb"));

	}

	public static int cbp(int[] strg, int curr, int end) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;
		for (int i = 1; i <= 6; i++) {
			count += cbp(strg, curr + i, end);
		}

		strg[curr] = count;
		return count;
	}

	public static int cmp(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}
		if (cr > er || cc > ec) {
			return 0;
		}
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = 0;
		int cv = 0;
		ch = cmp(cr, cc + 1, er, ec, strg);
		cv = cmp(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;

		return ch + cv;
	}

	public static int cbpi(int n) {
		int strg[] = new int[n + 6];
		strg[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= 6; j++) {
				strg[i] += strg[i + j];
			}
		}
		return strg[0];
	}

	public static int cbpsw(int n) {
		int strg[] = new int[6];
		strg[0] = 1;
		for (int i = 1; i <= n; i++) {
			int nv = 0;
			for (int j = 0; j < 6; j++) {
				nv += strg[j];
			}
			for (int k = 5; k >= 1; k--) {
				strg[k] = strg[k - 1];
			}
			strg[0] = nv;
		}
		return strg[0];

	}

	public static int cmpi(int er, int ec) {
		int arr[][] = new int[er + 2][ec + 2];

		arr[er + 1][ec] = 1;
		for (int r = er; r >= 0; r--) {
			for (int c = ec; c >= 0; c--) {
				arr[r][c] = arr[r + 1][c] + arr[r][c + 1];
			}
		}
		return arr[0][0];
	}

	public static int cmpsw(int er, int ec) {
		int arr[] = new int[ec + 1];
		Arrays.fill(arr, 1);
		for (int i = er - 1; i >= 0; i--) {
			for (int j = ec - 1; j >= 0; j--) {
				arr[j] += arr[j + 1];
			}
		}
		return arr[0];
	}

	public static int cmpdsw(int er, int ec) {
		int arr[] = new int[ec + 1];
		Arrays.fill(arr, 1);
		for (int i = er - 1; i >= 0; i--) {
			int temp = 1;
			for (int j = ec - 1; j >= 0; j--) {
				int nv = arr[j] + arr[j + 1] + temp;
				temp = arr[j];
				arr[j] = nv;
			}
		}
		return arr[0];
	}

	public static int lsc(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			return lsc(ros1, ros2) + 1;
		} else {
			int a = lsc(ros1, s2);
			int b = lsc(s1, ros2);
			return Math.max(a, b);
		}
	}
}
