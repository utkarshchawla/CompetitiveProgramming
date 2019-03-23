import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MARRAYS {

	static class pair {
		int val;
		int idx;

		public pair(int val, int idx) {
			this.val = val;
			this.idx = idx;
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
			pair[] maxa = new pair[n];
			pair[] mina = new pair[n];
			int[][] arr = new int[n][];
			for (int i = 0; i < n; i++) {
				int l = fr.nextInt();
				int max = Integer.MIN_VALUE;
				int maxi = -1;
				int min = Integer.MAX_VALUE;
				int mini = -1;
				int[] col = new int[l];
				for (int j = 0; j < l; j++) {
					col[j] = fr.nextInt();
					if (col[j] > max) {
						max = col[j];
						maxi = j;
					}
					if (col[j] < min) {
						min = col[j];
						mini = j;
					}
				}
				arr[i] = col;
				maxa[i] = new pair(max, maxi);
				mina[i] = new pair(min, mini);
			}

			int val = 0;
			int first = -1;
			if (Math.abs(maxa[n - 1].val - mina[n - 2].val) > Math.abs(maxa[n - 2].val - mina[n - 1].val)) {
				val += Math.abs(maxa[n - 1].val - mina[n - 2].val) * (n - 1);
				first = arr[n - 2][(mina[n - 2].idx + 1) % arr[n - 2].length];
			} else {
				val += Math.abs(maxa[n - 2].val - mina[n - 1].val) * (n - 1);
				first = arr[n - 2][(maxa[n - 2].idx + 1) % arr[n - 2].length];
			}

			for (int i = n - 3; i >= 0; i--) {
				if (Math.abs(maxa[i].val - first) > Math.abs(mina[i].val - first)) {
					val += Math.abs(maxa[i].val - first) * (i + 1);
					first = arr[i][(maxa[i].idx + 1) % arr[i].length];
				} else {
					val += Math.abs(mina[i].val - first) * (i + 1);
					first = arr[i][(mina[i].idx + 1) % arr[i].length];
				}
			}

			System.out.println(val);
		}
	}

}
