package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CHEFMOVR2 {
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
		long tc = fr.nextLong();
		while (tc > 0) {
			long n = fr.nextLong();
			long d = fr.nextLong();
			long total = 0;

			ArrayList<Long> list = new ArrayList<>();
			for (long i = 0; i < n; i++) {
				list.add(fr.nextLong());
				total += list.get(list.size() - 1);
			}

			long cv = (total / list.size());
			long count = 0;
			for (long i = 0; i < list.size() - d; i++) {
				if (list.get((int) i) != cv) {
					long diff = list.get((int) i) - cv;
					list.set((int) i, cv);
					list.set((int) (i + d), list.get((int) (i + d)) + diff);
					count += Math.abs(diff);
				}
			}

			for (long i = 0; i < list.size(); i++) {
				if (list.get((int) i) != cv) {
					count = -1;
					break;
				}
			}

			if (total % list.size() != 0) {
				count = -1;
			}

			System.out.println(count);

			tc--;
		}
	}

}
