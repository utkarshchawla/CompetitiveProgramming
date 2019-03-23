import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CHEFCCYL {
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

	static class pair {
		int v1;
		int v2;
		int total;
		int[] arr;
	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt();
			int q = fr.nextInt();
			pair[] inner = new pair[n + 1];
			for (int i = 1; i <= n; i++) {
				int l = fr.nextInt();
				pair mp = new pair();
				mp.arr = new int[l + 1];
				for (int j = 1; j <= l; j++) {
					mp.arr[j] = fr.nextInt();
					mp.arr[j] += mp.arr[j - 1];
				}
				mp.total = mp.arr[mp.arr.length - 1];
				inner[i] = mp;
			}
			int[] outer = new int[n + 1];
			int total = 0;
			for (int i = 1; i <= n; i++) {
				inner[i].v1 = fr.nextInt();
				inner[i % n + 1].v2 = fr.nextInt();
				outer[i] = fr.nextInt();
				total += outer[i];
				outer[i] += outer[i - 1];
			}
			while (q-- > 0) {
				int v1 = fr.nextInt();
				int c1 = fr.nextInt();
				int v2 = fr.nextInt();
				int c2 = fr.nextInt();
				int d1 = Math.abs(outer[c2 - 1] - outer[c1 - 1]);
				int d2 = Math.min(Math.abs(inner[c1].arr[v1 - 1] - inner[c1].arr[inner[c1].v1 - 1]),
						Math.abs(inner[c1].total - (inner[c1].arr[v1 - 1] - inner[c1].arr[inner[c1].v1 - 1])));
				int d3 = Math.min(Math.abs(inner[c2].arr[v2 - 1] - inner[c2].arr[inner[c2].v2 - 1]),
						Math.abs(inner[c2].total - (inner[c2].arr[v2 - 1] - inner[c2].arr[inner[c2].v2 - 1])));
				int[] sum = new int[n + 1];
				for (int i = 1; i <= n; i++) {
					sum[i] = Math.min(Math.abs(inner[i].arr[inner[i].v1 - 1] - inner[i].arr[inner[i].v2 - 1]),
							Math.abs(inner[i].total - (inner[i].arr[inner[i].v1 - 1] - inner[i].arr[inner[i].v2 - 1])));
					sum[i] += sum[i - 1];
				}
				int d4 = sum[c2 - 1] - sum[c1];
				int val1 = d1 + d2 + d3 + d4;
				d1 = Math.abs(total - (outer[c2 - 1] - outer[c1 - 1]));
				d2 = Math.min(Math.abs(inner[c1].arr[v2 - 1] - inner[c1].arr[inner[c1].v2 - 1]),
						Math.abs(inner[c1].total - (inner[c1].arr[v2 - 1] - inner[c1].arr[inner[c1].v2 - 1])));
				d3 = Math.min(Math.abs(inner[c2].arr[v1 - 1] - inner[c2].arr[inner[c2].v1 - 1]),
						Math.abs(inner[c2].total - (inner[c2].arr[v1 - 1] - inner[c2].arr[inner[c2].v1 - 1])));
				d4 = sum[n] - sum[c2] + sum[c1 - 1];
				int val2 = d1 + d2 + d3 + d4;
				System.out.println(Math.min(val1, val2));
			}
		}
	}
}
