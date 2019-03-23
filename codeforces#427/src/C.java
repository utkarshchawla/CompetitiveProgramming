import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class C {

	// public static class star {
	// int x;
	// int y;
	// int s;
	//
	// star(int x, int y, int s) {
	// this.x = x;
	// this.y = y;
	// this.s = s;
	// }
	// }

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
		int q = fr.nextInt();
		int c = fr.nextInt();

		// int[][] matrix = new int[201][201];
		ArrayList[][] matrix = new ArrayList[200][200];
		// ArrayList<star> stars = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = fr.nextInt();
			int y = fr.nextInt();
			int s = fr.nextInt();
			// star st = new star(fr.nextInt(), fr.nextInt(), fr.nextInt());
			if (matrix[x][y] == null) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(s);
				matrix[x][y] = list;
			} else {
				matrix[x][y].add(s);
			}
			// stars.add(st);
		}

		while (q-- > 0) {
			int t = fr.nextInt();
			int x1 = fr.nextInt();
			int y1 = fr.nextInt();
			int x2 = fr.nextInt();
			int y2 = fr.nextInt();

			int total = 0;
			// for (int i = 0; i < stars.size(); i++) {
			// star ms = stars.get(i);
			// if (ms.x >= x1 && ms.x <= x2 && ms.y >= y1 && ms.y <= y2) {
			// total += (ms.s + t) % (c + 1);
			// }

			for (int i = x1; i <= x2; i++) {
				for (int j = y1; j <= y2; j++) {
					if (matrix[i][j] != null) {
						for (int k = 0; k < matrix[i][j].size(); k++) {
							int val = (int) matrix[i][j].get(k);
							total += (val + t) % (c + 1);
						}
					}
				}
			}

			System.out.println(total);
		}

	}

}
