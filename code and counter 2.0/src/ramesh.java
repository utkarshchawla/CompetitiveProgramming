package codeAndCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ramesh {

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
		int total = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(fr.nextInt());
		}

		Collections.sort(list, Collections.reverseOrder());

		outer: while (list.size() != 0) {
			int min = list.get(list.size() - 1);

			while (list.get(list.size() - 1) == min) {
				total += list.remove(list.size() - 1);
				if (list.size() == 0) {
					break outer;
				}

			}

			int nm = list.get(list.size() - 1);
			if (nm == min + 1) {
				while (list.get(list.size() - 1) == nm) {
					list.remove(list.size() - 1);
					if (list.size() == 0) {
						break outer;
					}

				}
			}
		}

		System.out.println(total);

	}

}
