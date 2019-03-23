import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B {

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

	public static void main(String[] args) throws Exception {

		FastReader fr = new FastReader();
		int k = fr.nextInt();
		String n = fr.br.readLine();
		int son = sod(n);
		int count = 0;
		StringBuilder s = new StringBuilder(n);
		if (son < k) {
			outer: while (son < k) {
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) < 57) {
						count++;
						son += (57 - Integer.parseInt(s.charAt(i) + ""));
						if (son >= k) {
							break outer;
						}
					}

					if (son >= k) {
						break outer;
					}
				}
			}
		}

		System.out.println(count);

	}

	public static int sod(String n) {
		int total = 0;
		for (int i = 0; i < n.length(); i++) {
			total += Integer.parseInt(n.charAt(i) + "");
		}
		return total;

	}
}