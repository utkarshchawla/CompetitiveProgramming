package long_sep17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFSUM {
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
			int n = fr.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = fr.nextInt();
			}

			long[] pre = prefix(arr);
			long[] suff = suffix(arr);

			long min = Long.MAX_VALUE;
			long ridx = -1;

			for (int i = 0; i < arr.length; i++) {
//				 long sum = pre[i] + suff[i];
				long sum = (long) ((pre[i] + suff[i]) % (Math.pow(2, 32)));
				if (sum < min) {
					min = sum;
					ridx = i;
				}
			}

			System.out.println(ridx + 1);

		}
	}

	private static long[] suffix(long[] arr) {
		long[] ra = new long[arr.length];
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			ra[i] = sum;
		}
		return ra;
	}

	private static long[] prefix(long[] arr) {
		long[] ra = new long[arr.length];
		long sum = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			sum += arr[i];
			ra[i] = sum;
		}
		return ra;
	}

}
