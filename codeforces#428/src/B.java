import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B {
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
		int k = fr.nextInt();
		int[] sol = new int[k];

		for (int i = 0; i < k; i++) {
			sol[i] = fr.nextInt();
		}

		Arrays.sort(sol);
		int l = 0;
		int r = sol.length - 1;
		while (l < r) {
			int temp = sol[l];
			sol[l] = sol[r];
			sol[r] = temp;
			l++;
			r--;
		}
		int totals = 8 * n;

		for (int i = 0; i < k; i++) {
			int nosol = sol[i];

			if (nosol % 2 == 0) {
				if (totals == 2 && nosol == 2) {
					totals = 0;
				}
				totals -= nosol;
			} else {
				totals -= (nosol + 1);
			}
		}

		if (totals < 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

}
