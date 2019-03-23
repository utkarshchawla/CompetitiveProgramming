package long_sep17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SEACO4 {

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
			this.l = l;
			this.r = r;
		}
	}

	static class command {
		int l;
		int r;
		int idx;
		int type;
		ArrayList<IntegerPair> pair;

		command(int l, int r, int idx, int type, ArrayList<IntegerPair> pair) {
			this.idx = idx;
			this.type = type;
			this.pair = pair;
			this.l = l;
			this.r = r;

		}

	}

	static class heapmover {
		HashMap<IntegerPair, Long> freq = new HashMap<>();
		HashMap<Integer, HashMap<IntegerPair, Long>> dp = new HashMap<>();

	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t = fr.nextInt();

		while (t-- > 0) {
			int n = fr.nextInt();
			int m = fr.nextInt();
			long[] arr = new long[n];
			heapmover mover = new heapmover();

			for (int i = 0; i < m; i++) {

				int type = fr.nextInt();
				int l = fr.nextInt();
				int r = fr.nextInt();
				int idx = i + 1;
				IntegerPair ip = new IntegerPair(l, r);

				if (type == 1) {
					HashMap<IntegerPair, Long> map = new HashMap<>();
					map.put(ip, 1L);
					mover.dp.put(idx, map);

					if (mover.freq.containsKey(ip)) {
						mover.freq.put(ip, mover.freq.get(ip) + 1);
					} else {
						mover.freq.put(ip, 1L);
					}

				} else {
					type2(mover, ip, idx);

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

	public static void type2(heapmover mover, IntegerPair ip, int idx) {
		HashMap<IntegerPair, Long> map = new HashMap<>();
		for (int i = ip.l; i <= ip.r; i++) {
			for (IntegerPair mp : mover.dp.get(i).keySet()) {
				if (mover.freq.containsKey(mp)) {
					mover.freq.put(mp, mover.freq.get(mp) + mover.dp.get(i).get(mp));
				} else {
					mover.freq.put(mp, 1l);
				}

				if (map.containsKey(mp)) {
					map.put(mp, map.get(mp) + mover.dp.get(i).get(mp));

				} else {
					map.put(mp, mover.dp.get(i).get(mp));
				}
			}
		}
		mover.dp.put(idx, map);
	}
}
