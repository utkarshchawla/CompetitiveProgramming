import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFGPR {

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
			solver(a, b, x, y, "",0);
			System.out.println("-----------");

		}
	}

	private static void solver(int a, int b, int x, int y, String ans,int c) {
		if (a == 0 && b == 0) {
			System.out.println(ans + " " + c);
			return;
		}

		boolean fa = isok(ans, 'a', x) && a > 0;
		boolean fb = isok(ans, 'b', y) && b > 0;
		if (fa) {
			solver(a - 1, b, x, y, ans + 'a',c);
		}

		if (fb) {
			solver(a, b - 1, x, y, ans + 'b',c);
		}

		if (fa == false && fb == false) {
			solver(a, b, x, y, ans + '*',c + 1);
		}

	}

	public static boolean isok(String s, char c, int k) {
		if (s.length() < k) {
			return true;
		}
		for (int i = 0; i < k; i++) {
			if (s.charAt(s.length() - 1 - i) != c) {
				return true;
			}
		}

		return false;
	}

}
