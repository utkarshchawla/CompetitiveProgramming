import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class C {

	public static class pair implements Comparable<pair> {
		int val;
		int idx;

		@Override
		public int compareTo(pair o) {
			int rv = this.val - o.val;
			if (rv == 0) {
				rv = o.idx - this.idx;
			}
			return rv;
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
		int m = fr.nextInt();
		PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < m; i++) {
			a.add(fr.nextInt());
		}
		PriorityQueue<pair> b = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			pair p = new pair();
			p.val = fr.nextInt();
			p.idx = i;
			b.add(p);
		}

		int[] ra = new int[m];
		while (!a.isEmpty()) {
			int v = a.poll();
			int i = b.poll().idx;
			ra[i] = v;
		}

		for (int i = 0; i < ra.length; i++) {
			System.out.print(ra[i] + " ");
		}

	}

}
