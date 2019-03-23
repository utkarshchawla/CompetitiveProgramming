import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B_2 {

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
		ArrayList<Integer> list = new ArrayList<>();
		int four = 4 * n;
		int two = 4 * n;

		for (int i = 0; i < k; i++) {
			int val = fr.nextInt();
			if (val % 2 == 0) {
				list.add(val);
			} else {
				list.add(0, val);
			}
		}

		list.sort(null);
		int count1 = 0;
		while (!list.isEmpty()) {
			int nosol = list.remove(list.size() - 1);
			int takenfour = nosol - nosol % 4;

			if (four >= takenfour) {
				four -= takenfour;
			} else if (two >= takenfour) {
				two -= takenfour;
			} else {
				two = -1;
				four = -1;
				break;
			}

			int rem = nosol % 4;
			if (rem == 3) {
				if (two >= 4) {
					two -= 4;
				} else if (four >= 4) {
					four -= 4;
				} else {
					four = -1;
					two = -1;
				}
			} else if (rem == 2) {
				if (two >= 2) {
					two -= 2;
				} else if (four >= 2) {
					four -= 2;
				} else if (four == 1 && two == 1) {
					count1++;
					two -= 2;
				} else {
					four = -1;
					two = -1;
				}
			} else if (rem == 1) {
				if (two >= 1) {
					two -= 2;
				} else if (four >= 1) {
					count1++;
				} else {
					four = -1;
					two = -1;
				}
			}
		}
	
		
		four -= count1*2;
		int total = four + two;

		if (total < 0) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}

}
