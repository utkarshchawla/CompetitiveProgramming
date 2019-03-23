package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WALKBT {

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
			int n = fr.nextInt();
			int q = fr.nextInt();
			HashMap<Integer, Boolean> map = new HashMap<>();
			int x = 0;
			int n2 = (int) Math.pow(2, n);
			int nn = (int) (Math.pow(2, n + 1) - 1);
			while (q > 0) {
				int val = 0;
				char ch = fr.next().charAt(0);
				if (ch == '!') {
					int c = fr.nextInt();
					x = (x + (int) (Math.pow(2, c))) % n2;
					// String s = String.format("%0" + n + "d", dtb(x));
					String s = dtb(x, n);
					for (int i = 0; i < s.length(); i++) {
						int a = s.charAt(i) - 48;
						if (a == 0) {
							val = 2 * val + 1;
							if (val < nn) {
								map.put(val, true);
							}
						} else if (a == 1) {
							val = 2 * val + 2;
							if (val < nn) {
								map.put(val, true);
							}
						}
					}
				} else if (ch == '?') {
					System.out.println(map.size() + 1);
				}
				q--;
			}
			t--;
		}
	}

	public static String dtb(int d, int n) {
		StringBuilder sb = new StringBuilder();
		int temp = d;
		if (temp == 0) {
			sb.append(0);
		}
		while (temp != 0) {
			sb.append(temp % 2);
			temp = temp / 2;
		}
		sb = sb.reverse();
		String rs = sb.toString();
		String lz = "";
		for (int i = 0; i < n - rs.length(); i++) {
			lz += "0";
		}

		rs = lz + rs;
		return rs;
	}
}
