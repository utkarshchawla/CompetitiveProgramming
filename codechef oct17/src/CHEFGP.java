import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFGP {

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

			String ans = solver(x, y, a, b);
			System.out.println(ans);

		}

	}

	private static String solver(int x, int y, int a, int b) {
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
			sb.append('b');
			b--;
		}
		int k = 0;
		char c = ' ';
		int n = 0;
		if (a > 0) {
			k = x;
			c = 'a';
			n = a;
		} else if (b > 0) {
			k = y;
			c = 'b';
			n = b;
		} else {
			// System.out.print(sb.toString());
			return sb.toString();
			// return;
		}
		String s = sb.toString();
		sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			// System.out.print(s.charAt(i));
			sb.append(s.charAt(i));
			if (s.charAt(i) == c) {
				for (int j = 0; j < k - 1; j++) {
					if (n == 0) {
						break;
					}
					// System.out.print(c);
					sb.append(c);
					n--;
				}
			}
		}
		if (n != 0) {
			// System.out.print('*');
			sb.append('*');
			int count = 0;
			while (n != 0) {
				// System.out.print(c);
				sb.append(c);
				n--;
				count++;
				if (count == k && n != 0) {
					// System.out.print('*');
					sb.append('*');
					count = 0;
				}
			}
		}
		return sb.toString();
	}
}
