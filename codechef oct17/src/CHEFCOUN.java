import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.nio.charset.Charset;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class CHEFCOUN {

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
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt();
			long x = Math.round((4294966296L - 2000) / (n - 2)) - 1;
			// String s = 1000 + " ";
			System.out.print(1000 + " ");
			long sub = (n - 2) * x;
			long val = (4294966296L - sub) / 2;
			long sp = 2 * val + 1000 + (n - 2) * x;
			long diff = sp - 4294967296L;
			val -= diff;
			if (val < 1000) {
				val += (1000 - val) + 1;
			}
			// s += val + " ";
			System.out.print(val + " ");
			for (int i = 0; i < n - 2; i++) {
				// s += x + " ";
				System.out.print(x + " ");
			}
			// System.out.println(s);
			// ArrayList<String> line = new ArrayList<>(Arrays.asList(s));
			// Path file = Paths.get("lol.txt");
			// Files.write(file, line, Charset.forName("UTF-8"));
		}

	}

}
