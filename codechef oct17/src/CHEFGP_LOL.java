import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFGP_LOL {

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			String s = fr.nextLine();
			int a = 0;
			int b = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'a') {
					a++;
				} else {
					b++;
				}
			}

			int x = fr.nextInt();
			int y = fr.nextInt();

			boolean flag = true;
			int ta = 0;
			int tb = 0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'a') {ta++;tb = 0;}
				if(s.charAt(i) == 'b') {tb++;ta = 0;}
				if(ta > x) {flag = false;break;}
				if(tb > y) {flag = false;break;}
			}

			if (flag) {
				System.out.println(s);
			} else {
				String ans = solver1(a, b, x, y);
				System.out.println(ans);
			}

		}
	}

	private static String solver1(int a, int b, int x, int y) {
		int temp = 0;
		if (a > b) {
			temp = b;
		} else {
			temp = a;
		}
		StringBuilder sb = new StringBuilder();
		if (a >= b) {
			while (a > 0 && b > 0) {
				sb.append('a');
				a--;
				sb.append('b');
				b--;
			}
			if (a > 0) {
				sb.append('a');
				a--;
			}
		} else {
			while (a > 0 && b > 0) {
				sb.append('b');
				b--;
				sb.append('a');
				a--;
			}
			if (b > 0) {
				sb.append('b');
				b--;
			}

		}
		if (a == 0 && b == 0) {
			return sb.toString();
		}

		char c = 'c';
		int k = 0;
		int no = 0;
		if (a > 0) {
			c = 'a';
			k = x;
			no = a;
		} else {
			c = 'b';
			k = y;
			no = b;
		}

		if (no < k - 1) {
			k = no + 1;
		}
		StringBuilder sap = new StringBuilder();
		for (int i = 0; i < k - 1; i++) {
			sap.append(c);
		}
		String stoap = sap.toString();
		int idx = sb.length();
		for (int i = 0; i <= temp; i++) {
			if (i == 0) {
				sb.append(stoap);
			} else {
				sb.insert(idx, stoap);
			}
			idx -= 2;
			no -= (k - 1);
			if (no <= 0) {
				break;
			}
		}

		if (no > 0) {
			sb.append('*');
		}
		int m = 0;
		while (no > 0) {
			if (m >= k) {
				m = 0;
				sb.append('*');
			}
			sb.append(c);
			no--;
			m++;
		}

		return sb.toString();

	}

}
