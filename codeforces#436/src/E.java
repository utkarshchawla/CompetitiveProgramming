import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class E {

	static class pair implements Comparable<pair> {
		int t;
		int d;
		int p;
		int idx;

		public pair(int t, int d, int p, int idx) {
			this.t = t;
			this.d = d;
			this.p = p;
			this.idx = idx;
		}

		@Override
		public int compareTo(pair o) {
			if (this.d == o.d) {
				return this.t - o.t;
			} else {
				return this.d - o.d;
			}
		}
	}

	static class out {
		int val;
		int n;
		String s;

		public out(int val, int n, String s) {
			this.val = val;
			this.n = n;
			this.s = s;

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
		PriorityQueue<pair> p = new PriorityQueue<>();
		pair[] arr = new pair[n];
		for (int i = 0; i < n; i++) {
			p.add(new pair(fr.nextInt(), fr.nextInt(), fr.nextInt(), i));
		}
		int cnt = 0;
		while (!p.isEmpty()) {
			arr[cnt] = p.poll();
			cnt++;
		}

		out[][] strg = new out[101][2001];
		out v = solver(0, arr, 0, strg);
		System.out.println(v.val);
		System.out.println(v.n);
		for (int i = v.s.length() - 1; i >= 0; i--) {
			System.out.print(Integer.parseInt(v.s.charAt(i) + "") + " ");
		}

	}

	public static out solver(int vidx, pair[] arr, int time, out[][] strg) {
		if (vidx >= arr.length) {
			return new out(0, 0, "");
		}

		if (strg[vidx][time] != null) {
			System.out.println("hi");
			return strg[vidx][time];
		}
		out v1 = new out(0, 0, "");
		out v2 = new out(0, 0, "");
		if (time + arr[vidx].t < arr[vidx].d) {
			v1 = solver(vidx + 1, arr, time + arr[vidx].t, strg);
			v1.val += arr[vidx].p;
			v1.n++;
			v1.s = v1.s + (arr[vidx].idx + 1);
		}
		v2 = solver(vidx + 1, arr, time, strg);
		out rv = new out(0, 0, "");

		if (v1.val > v2.val) {
			strg[vidx][time] = v1;
			rv = v1;
		} else if (v2.val > v1.val) {
			strg[vidx][time] = v2;
			rv = v2;
		} else {
			rv = v2;
		}
		return rv;
	}

}
