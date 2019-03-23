package cookoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OBTTRNGL {
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
			int k = fr.nextInt();
			int a = fr.nextInt();
			int b = fr.nextInt();

			if (a > b) {
				int temp = a;
				a = b;
				b = temp;
			}

			long d1 = b - a;
			long d2 = (k + a) - b;

			long count = 0;

			if (d1 < d2) {
				count = d1 - 1;
			} else if (d1 > d2) {
				count = d2 - 1;
			}

			System.out.println(count);
			tc--;
		}
	}

}
