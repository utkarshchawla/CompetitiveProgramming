package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PALINGAM {

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
		int tc = fr.nextInt();
		while (tc > 0) {

			String s = fr.next();
			String t = fr.next();
			String dup = "";
			

			boolean flag = false;
			for (int i = 0; i < s.length(); i++) {
				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(i) == s.charAt(j)) {
						dup += s.charAt(i);
						flag = true;
//						break;
					}
				}
			}

			if (flag) {
				flag = false;
				for (int i = 0; i < dup.length(); i++) {
					boolean b = containsChar(t, dup.charAt(i));
					if (b == false) {
						flag = true;
					}
				}
			}

			if (flag) {
				System.out.println("A");
			} else {
				System.out.println("B");
			}

			tc--;
		}
	}

	public static boolean containsChar(String s, char c) {
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				return true;
			}
		}

		return false;
	}

}
