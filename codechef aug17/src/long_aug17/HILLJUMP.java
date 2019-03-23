package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HILLJUMP {
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
		int n = fr.nextInt();
		int q = fr.nextInt();

		long[] hh = new long[n];
		for (int i = 0; i < n; i++) {
			hh[i] = fr.nextInt();
		}

		while (q > 0) {
			int type = fr.nextInt();
			if (type == 1) {
				int i = fr.nextInt();
				int k = fr.nextInt();
				i--;
				while (k > 0) {
					for (int j = i + 1; j < hh.length; j++) {
						if (hh[j] > hh[i] && j - i <= 100) {
							i = j;
							k--;
						}
						if (k == 0) {
							break;
						}
					}
					if (k > 0) {
						// k = 0;
						break;
					}
				}
				System.out.println(i + 1);

			} else if (type == 2) {
				int l = fr.nextInt();
				int r = fr.nextInt();
				int x = fr.nextInt();
				l--;
				r--;
				while (l <= r) {
					hh[l] += x;
					hh[r] += x;
					l++;
					r--;
				}
			}
			q--;
		}
	}

}
