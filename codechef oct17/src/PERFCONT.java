import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PERFCONT {

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
			int p = fr.nextInt();
			int[] arr = new int[n];
			int cake = 0;
			int hard = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = fr.nextInt();
				if (arr[i] >= p / 2) {
					cake++;
				} else if (arr[i] <= p / 10) {
					hard++;
				}
			}

			if (cake == 1 && hard == 2) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}

	}

}
