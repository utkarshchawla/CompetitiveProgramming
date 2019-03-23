import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class E_2 {

	public static int max = 0;
	public static int nout = 0;
	public static String sout = "";

	static class pair {
		int t;
		int d;
		int p;

		public pair(int t, int d, int p) {
			this.t = t;
			this.d = d;
			this.p = p;
		}
	}

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
		pair[] arr = new pair[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new pair(fr.nextInt(), fr.nextInt(), fr.nextInt());
		}

		solver(0, arr, 0, 0, "", 0);
		System.out.println(max);
		System.out.println(nout);
		for (int i = 0; i < sout.length(); i++) {
			System.out.print(Integer.parseInt(sout.charAt(i) + "") + " ");
		}

	}

	public static void solver(int vidx, pair[] arr, int time, int n, String s, int val) {
		if (vidx == arr.length) {
			if (val > max) {
				max = val;
				nout = n;
				sout = s;
			}
			return;
		}

		if (time + arr[vidx].t < arr[vidx].d) {
			solver(vidx + 1, arr, time + arr[vidx].t, n + 1, s + (vidx + 1), val + arr[vidx].p);
		}
		solver(vidx + 1, arr, time, n, s, val);
	}

}
