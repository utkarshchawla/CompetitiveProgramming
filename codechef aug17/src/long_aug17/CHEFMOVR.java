package competitive.long_aug17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class CHEFMOVR {

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
			int n = fr.nextInt();
			int d = fr.nextInt();
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				list.add(fr.nextInt());
			}

			long count = 0;
			while (true) {
				int max = Collections.max(list);
				int maxi = list.indexOf(max);

				int pi = maxi - d;
				int ni = maxi + d;
				int mini = 0;
				if (pi >= 0 && ni < list.size()) {
					mini = list.indexOf(Math.min(list.get(ni), list.get(pi)));
				} else if (pi >= 0) {
					mini = pi;
				} else {
					mini = ni;
				}

				if (list.get(mini) == list.get(maxi)) {
					break;
				}

				if ((list.get(mini) + list.get(maxi)) % 2 == 1) {
					int sum = list.get(mini) + list.get(maxi);
					int diff = list.get(maxi) - list.get(mini);
					if (diff == 1) {
						count = -1;
						break;
					}
					list.set(mini, sum / 2);
					list.set(maxi, sum / 2 + 1);
					count += diff / 2;

				} else {
					int sum = list.get(mini) + list.get(maxi);
					int diff = list.get(maxi) - list.get(mini);
					if (diff == 1) {
						count = -1;
						break;
					}
					list.set(mini, sum / 2);
					list.set(maxi, sum / 2);
					count += diff / 2;
				}

			}

			System.out.println(count);
			tc--;
		}
	}

}
