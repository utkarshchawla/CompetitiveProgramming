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
		int n = fr.nextInt();
		int k = fr.nextInt();
		int noOfCandies[] = new int[n];
		for (int i = 0; i < n; i++) {
			noOfCandies[i] = fr.nextInt();
		}

		int totalA = 0;
		int totalB = 0;
		int day = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			day++;
			totalA += noOfCandies[i];
			if (totalA <= 8) {
				totalB += totalA;
				totalA = 0;
			} else {
				totalB += 8;
				totalA -= 8;
			}

			if (totalB >= k) {
				flag = true;
				break;
			}

		}

		if (flag) {
			System.out.println(day);
		} else {
			System.out.println("-1");
		}

	}

}
