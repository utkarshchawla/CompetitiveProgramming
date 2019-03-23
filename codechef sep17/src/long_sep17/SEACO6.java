package long_sep17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SEACO6 {
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

	public static class map {
		HashMap<IntegerPair, Long> data = new HashMap<>();
	}

	public static class IntegerPair {
		int left;
		int right;

		public IntegerPair(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}

	static class SegmentTree {

		private class Node {
			map map = new map();

			// int data;
			int si;
			int ei;
			Node left;
			Node right;
		}

		private Node root;
		private int size;

		public SegmentTree(map[] arr) {
			root = construct(arr, 0, arr.length - 1);
		}

		private Node construct(map[] arr, int si, int ei) {

			if (si == ei) {
				Node base = new Node();
				this.size++;
				base.si = base.ei = si;
				base.map = arr[si];
				return base;
			}

			int mid = (si + ei) / 2;
			Node node = new Node();
			this.size++;
			node.si = si;
			node.ei = ei;

			node.left = construct(arr, si, mid);
			node.right = construct(arr, mid + 1, ei);
			// node.data = node.right.data + node.left.data;
			// oldRight.forEach((k, v) -> map.merge(k, v, Long::sum));
			// node.left.map.data.forEach((k, v) -> node.map.data.merge(k, v, Long::sum));
			// node.right.map.data.forEach((k, v) -> node.map.data.merge(k, v, Long::sum));
			return node;

		}

		public HashMap<IntegerPair, Long> query(int qsi, int qei) {
			return query(root, qsi, qei);
		}

		private HashMap<IntegerPair, Long> query(Node node, int qsi, int qei) {
			HashMap<IntegerPair, Long> rm = new HashMap<>();
			if (node.si >= qsi && node.ei <= qei) {
				return node.map.data;
			} else if (node.si > qei || node.ei < qsi) {
				rm.clear();
				return rm;
			} else {

				HashMap<IntegerPair, Long> l = query(node.left, qsi, qei);
				HashMap<IntegerPair, Long> r = query(node.right, qsi, qei);

				l.forEach((k, v) -> rm.merge(k, v, Long::sum));
				r.forEach((k, v) -> rm.merge(k, v, Long::sum));

				return rm;
			}

		}

		public void update(int idx, HashMap<IntegerPair, Long> data) {
			update(root, idx, data);
		}

		private void update(Node node, int idx, HashMap<IntegerPair, Long> data) {
			int mid = (node.si + node.ei) / 2;

			if (node.left == null && node.right == null && node.ei == idx) {
				node.map.data = data;
				return;
			}

			if (node.left != null && idx <= mid) {
				update(node.left, idx, data);
			}
			if (node.right != null && idx > mid) {
				update(node.right, idx, data);
			}

			if (node.left != null && node.right != null) {
				// node.data = node.left.data + node.right.data;
				// node.map.data.clear();
				node.left.map.data.forEach((k, v) -> node.map.data.merge(k, v, Long::sum));
				node.right.map.data.forEach((k, v) -> node.map.data.merge(k, v, Long::sum));
			}

		}

	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt();
			long[] sum = new long[n];
			int m = fr.nextInt();
			map[] arr = new map[m];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = new map();
			}
			SegmentTree st = new SegmentTree(arr);
			for (int i = 0; i < m; i++) {
				int type = fr.nextInt();
				int left = fr.nextInt();
				int right = fr.nextInt();

				if (type == 1) {
					IntegerPair t1 = new IntegerPair(left, right);
					HashMap<IntegerPair, Long> m1 = new HashMap<>();
					m1.put(t1, 1L);
					st.update(i, m1);
				} else {
					left--;
					right--;
					HashMap<IntegerPair, Long> t2 = st.query(left, right);
					st.update(i, t2);
				}
			}

			HashMap<IntegerPair, Long> total = st.query(0, m - 1);
			for (IntegerPair ip : total.keySet()) {
				cal(sum, ip, total.get(ip));
			}

			for (int i = 0; i < sum.length; i++) {
				System.out.print(sum[i] + " ");
			}
			System.out.println();

		}
	}

	public static void cal(long[] arr, IntegerPair ip, long add) {
		int l = ip.left;
		int r = ip.right;
		l--;
		r--;
		for (int i = l; i <= r; i++) {
			arr[i] = (arr[i] + add) % 1000000007;
		}
	}

}
