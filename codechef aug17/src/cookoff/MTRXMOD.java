package cookoff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MTRXMOD {
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
		int[][] arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = fr.nextInt();
			}
		}

		solver(arr);

		while (q > 0) {
			int p = fr.nextInt();
			p--;
			for (int i = 0; i < n; i++) {
				int nv = fr.nextInt();
				arr[i][p] = nv;
				arr[p][i] = nv;
			}
			solver(arr);
			q--;
		}

	}

	public static void solver(int[][] arr) {
		HashSet<Integer> set = new HashSet<>();
		HashSet<String> dp = new HashSet<>();
		set.add(0);
		int[] ra = new int[arr.length];
		ra[0] = 0;

		for (int i = 1; i < arr.length; i++) {
			ra[i] = -arr[0][i];
			set.add(arr[0][i]);
			for (int j = 0; j < arr[0][i]; j++) {
				set.add(j);
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (!dp.contains(i + " " + j)) {
					dp.add(i + " " + j);
					dp.add(j + " " + i);
					if (!set.contains(arr[i][j])) {
						set.add(arr[i][j]);
						int a = ra[i];
						int b = ra[j];
						int max = Math.max(a, b);
						if (a == max) {
							ra[i] = -ra[i];
						} else {
							ra[j] = -ra[j];
						}
					}
				}
			}
		}

		for (int i = 0; i < ra.length; i++) {
			System.out.print(ra[i] + " ");
		}
		System.out.println();
	}

}
