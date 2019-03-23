package long_sep17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FILLMTR3 {

	static class IntegerPair implements Comparable<IntegerPair> {
		int x;
		int y;
		int val;

		public IntegerPair(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}

		@Override
		public int compareTo(IntegerPair o) {
			int val = (this.x + this.y) - (o.x + o.y);
			if (val == 0) {
				val = this.x - this.y;
			}

			return val;
		}

	}

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
			int q = fr.nextInt();
			int[] arr = new int[n + 1];
			Arrays.fill(arr, -1);
			PriorityQueue<IntegerPair> pq = new PriorityQueue<>();

			while (q-- > 0) {
				int a = fr.nextInt();
				int b = fr.nextInt();
				int val = fr.nextInt();

				IntegerPair one = new IntegerPair(a, b, val);
				IntegerPair two = new IntegerPair(b, a, val);
				pq.add(one);
				pq.add(two);
			}

			boolean flag = true;
			while (!pq.isEmpty()) {
				IntegerPair mp = pq.poll();
				int i = mp.x;
				int j = mp.y;
				int diff = Math.abs(arr[i] - arr[j]);
				if (diff != mp.val || (arr[i] == -1 || arr[j] == -1)) {
					if (arr[i] != -1 && arr[j] != -1) {
						flag = false;
						break;
					} else if (arr[i] != -1 && arr[j] == -1) {
						arr[j] = Math.abs(arr[i] - mp.val);
					} else if (arr[i] == -1 && arr[j] != -1) {
						arr[i] = Math.abs(arr[j] - mp.val);
					} else {
						if (mp.val == 0) {
							arr[i] = 0;
							arr[j] = 0;
						} else {
							arr[i] = 0;
							arr[j] = 1;
						}
					}
				}
			}

			if (!flag) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}

		}
	}

}
