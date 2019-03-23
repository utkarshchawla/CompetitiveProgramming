package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class HILLJUMP2 {
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
		int[] height = new int[n];

		for (int i = 0; i < n; i++) {
			height[i] = fr.nextInt();
		}

		solver(n, q, height, fr);

	}

	public static void solver(int n, int q, int height[], FastReader fr) {
		if(q == 0) {
			return;
		}

		int[] sorted = new int[n];
		HashMap<Integer, ArrayList<Integer>> preidx = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> newidx = new HashMap<>();

		for (int i = 0; i < n; i++) {
			sorted[i] = height[i];
			if (!preidx.containsKey(height[i])) {
				ArrayList<Integer> put = new ArrayList<>();
				put.add(i);
				preidx.put(height[i], put);
			} else {
				preidx.get(height[i]).add(i);
			}
		}

		Arrays.sort(sorted);

		for (int i = 0; i < n; i++) {

			if (!newidx.containsKey(sorted[i])) {
				ArrayList<Integer> put = new ArrayList<>();
				put.add(i);
				newidx.put(sorted[i], put);
			} else {
				newidx.get(sorted[i]).add(i);
			}
		}

		while (q > 0) {
			int type = fr.nextInt();
			if (type == 1) {
				int i = fr.nextInt();
				int k = fr.nextInt();

				int h = height[i - 1];
				int pi = preidx.get(h).indexOf(i - 1);
				int ni = newidx.get(h).get(pi);
				while (k > 0) {

					if (ni + 1 < sorted.length && sorted[ni + 1] > sorted[ni]) {
						ni++;
						k--;
					} else if (ni >= sorted.length - 1) {
						k = 0;
					} else if (sorted[ni + 1] == sorted[ni]) {
						ni++;
					}
				}

				int a = sorted[ni];
				int nv = newidx.get(a).indexOf(ni);
				int fi = preidx.get(a).get(nv);

				System.out.println(fi + 1);
				q--;

			} else if (type == 2) {
				int l = fr.nextInt();
				int r = fr.nextInt();
				int x = fr.nextInt();
				l--;
				r--;
				while (l <= r) {
					height[l] += x;
					height[r] += x;
					l++;
					r--;
				}
				
				solver(n, q - 1, height, fr);
				q = 0;;
			}	
		}

	}

}
