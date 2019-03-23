package long_sep17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SEACO5 {

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

	static class IntegerPair {
		int l;
		int r;

		public IntegerPair(int l, int r) {
			this.r = r;
			this.l = l;
		}
	}

	static class Command {
		int idx;
		int l;
		int r;

		Command(int idx, int l, int r) {
			this.idx = idx;
			this.l = l;
			this.r = r;
		}
	}

	static class Dynamic {
		HashMap<Integer, HashMap<IntegerPair, Long>> dp = new HashMap<>();
		HashMap<IntegerPair, Long> freq = new HashMap<>();
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt();
			int m = fr.nextInt();
			Dynamic mover = new Dynamic();
			long[] arr = new long[n];

			for (int i = 0; i < m; i++) {

				int type = fr.nextInt();
				int l = fr.nextInt();
				int r = fr.nextInt();
				int idx = i + 1;

				if (type == 1) {
					IntegerPair ip = new IntegerPair(l, r);
					mover.freq.put(ip, 1L);
					HashMap<IntegerPair, Long> map = new HashMap<>();

					if (idx != 1) {
						map.putAll(mover.dp.get(idx - 1));
					}

					map.put(ip, 1L);
					mover.dp.put(idx, map);

				} else {
					HashMap<IntegerPair, Long> map = new HashMap<>();
					HashMap<IntegerPair, Long> oldRight = mover.dp.get(r);

					if (l == 1) {
						for (IntegerPair ip : oldRight.keySet()) {
							mover.freq.put(ip, mover.freq.get(ip) + oldRight.get(ip));
							map.put(ip, 2 * oldRight.get(ip));
						}

					} else {
						HashMap<IntegerPair, Long> oldLeft = mover.dp.get(l - 1);
						oldRight.forEach((k, v) -> map.merge(k, v, Long::sum));
						oldLeft.forEach((k, v) -> map.merge(k, v, (a, b) -> Math.abs(a - b)));
						for (IntegerPair ip : map.keySet()) {
							mover.freq.put(ip, mover.freq.get(ip) + map.get(ip));
							map.put(ip, 2 * map.get(ip));
						}
					}

					mover.dp.put(idx, map);
				}
			}

			for (IntegerPair ip : mover.freq.keySet()) {
				cal(arr, ip, mover.freq.get(ip));
			}

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}

	}

	public static void cal(long[] arr, IntegerPair ip, long add) {
		int l = ip.l;
		int r = ip.r;
		l--;
		r--;
		for (int i = l; i <= r; i++) {
			arr[i] = (arr[i] + add) % 1000000007;
		}
	}

}
