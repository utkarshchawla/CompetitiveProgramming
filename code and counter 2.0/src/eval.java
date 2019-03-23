package codeAndCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class eval {
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
		while (t > 0) {
			String s = fr.nextLine();
			StringBuilder sb = new StringBuilder(s);

			int d = sb.indexOf("/");
			while (d != -1) {
				if (sb.charAt(d + 2) == '-') {
					int division = div(sb.charAt(d - 2), sb.charAt(d + 3));
					sb.delete(d - 2, d + 4);
					division = -division;
					sb.insert(d - 2, division);
					d = sb.indexOf("/");

				} else {
					if (sb.charAt(d + 2) == '0') {
						sb.delete(0, sb.length());
						sb.append("Division by zero encountered");
						break;
					} else {
						int division = div(sb.charAt(d - 2), sb.charAt(d + 2));
						sb.delete(d - 2, d + 3);
						sb.insert(d - 2, division);
					}
					d = sb.indexOf("/");
				}
			}

			int m = sb.indexOf("*");
			while (m != -1) {
				if (sb.charAt(m + 2) == '-') {
					int product = multi(sb.charAt(m - 2), sb.charAt(m + 3));
					sb.delete(m - 2, m + 4);
					product = -product;
					sb.insert(m - 2, product);
				} else {
					int product = multi(sb.charAt(m - 2), sb.charAt(m + 2));
					sb.delete(m - 2, m + 3);
					sb.insert(m - 2, product);
				}
				m = sb.indexOf("*");
			}

			int a = sb.indexOf("+");
			while (a != -1) {
				if (sb.charAt(a + 2) == '-') {
					int addition = sub(sb.charAt(a - 2), sb.charAt(a + 3));
					sb.delete(a - 2, a + 4);
					sb.insert(a - 2, addition);
				} else {
					int addition = add(sb.charAt(a - 2), sb.charAt(a + 2));
					sb.delete(a - 2, a + 3);
					sb.insert(a - 2, addition);
				}
				a = sb.indexOf("+");
			}

			int su = sb.indexOf("-");
			while (su != -1 && sb.charAt(su + 1) == ' ' && sb.charAt(su - 1) == ' ') {
				if (sb.charAt(su + 2) == '-') {
					int sub = add(sb.charAt(su - 2), sb.charAt(su + 3));
					sb.delete(su - 2, su + 4);
					sb.insert(su - 2, sub);
				} else {
					int sub = sub(sb.charAt(su - 2), sb.charAt(su + 2));
					sb.delete(su - 2, su + 3);
					sb.insert(su - 2, sub);
				}

				su = sb.indexOf("-");
			}

			System.out.println(sb.toString());

			t--;
		}

	}

	public static int add(int a, int b) {
		a -= 48;
		b -= 48;
		return a + b;
	}

	public static int sub(int a, int b) {
		a -= 48;
		b -= 48;
		return a - b;
	}

	public static int multi(int a, int b) {
		a -= 48;
		b -= 48;
		return a * b;
	}

	public static int div(int a, int b) {
		a -= 48;
		b -= 48;
		return a / b;
	}

}
