import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(fr.nextInt());
		}

		while (true) {
			long total = 0;
			for (Integer i : list) {
				total += i;
			}
			if (total % 2 == 1) {
				System.out.println("First");
				System.exit(0);
			}
			int left = 0;
			int right = list.size() - 1;
			while (total % 2 == 1) {
				if (left % 2 == 1) {
					total -= list.get(left);
					list.remove(left);
				} else if (right % 2 == 1) {
					total -= list.get(right);
					list.remove(right);
				} else {
					total -= (list.get(right) + list.get(left));
					list.remove(left);
					list.remove(right);
				}

				if (total == 0 || list.size() == 0) {
					System.out.println("Second");
					System.exit(0);
				}
			}

			total = 0;
			for (Integer i : list) {
				total += i;
			}
			if (total % 2 == 0) {
				System.out.println("Second");
				System.exit(0);
			}

			left = 0;
			right = list.size() - 1;
			while (total % 2 == 0) {

				if (left % 2 == 1) {
					total -= list.get(left);
					list.remove(left);
				} else if (right % 2 == 1) {
					total -= list.get(right);
					list.remove(right);
				} else {
					total -= (list.get(right) + list.get(left));
					list.remove(left);
					list.remove(right);
				}

				if (total == 0 || list.size() == 0) {
					System.out.println("First");
					System.exit(0);
				}
			}
		}

	}

}
