import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

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
		int s = fr.nextInt();
		int v1 = fr.nextInt();
		int v2 = fr.nextInt();
		int t1 = fr.nextInt();
		int t2 = fr.nextInt();

		int time1 = 2 * t1 + s * v1;
		int time2 = 2 * t2 + s * v2;

		if (time1 < time2) {
			System.out.println("First");
		} else if (time1 > time2) {
			System.out.println("Second");
		} else {
			System.out.println("Friendship");
		}

	}

}
