import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class MEX {

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
			int k = fr.nextInt();
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < n; i++) {
				set.add(fr.nextInt());
			}

			int val = 0;
			while (k-- > 0) {
				while (set.contains(val)) {
					val++;
				}
				set.add(val);
			}

			boolean flag = false;
			int mex = -1;
			for (int i = 0; i < set.size(); i++) {
				if (!set.contains(i)) {
					flag = true;
					mex = i;
					break;
				}
			}

			if (!flag) {
				mex = set.size();
			}
			System.out.println(mex);
		}

	}

}
