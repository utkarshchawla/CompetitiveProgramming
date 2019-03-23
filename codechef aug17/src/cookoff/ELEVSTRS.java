package cookoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ELEVSTRS {

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
			double n = fr.nextInt();
			double v1 = fr.nextInt();
			double v2 = fr.nextInt();

			double ts = (Math.sqrt(2) * n) / v1;
			double tl = (2 * n) / v2;

			if (ts < tl) {
				System.out.println("Stairs");
			} else if(ts > tl) {
				System.out.println("Elevator");
			}

			tc--;
		}
	}

}
