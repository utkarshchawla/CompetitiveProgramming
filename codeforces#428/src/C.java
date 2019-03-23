import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class C {

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

	static class Graph {
		public class Vertex {
			HashMap<String, Integer> nbrs = new HashMap<>();
		}

		HashMap<String, Vertex> vces = new HashMap<>();

		public void addVertex(String vname) {
			if (vces.containsKey(vname)) {
				return;
			}

			Vertex v = new Vertex();
			vces.put(vname, v);
		}

		public void addEdge(String v1name, String v2name, int weight) {
			if (vces.get(v1name) == null || vces.get(v2name) == null) {
				return;
			}

			vces.get(v1name).nbrs.put(v2name, weight);
			vces.get(v2name).nbrs.put(v1name, weight);
		}

		public double dfs(String start, HashMap<String, Boolean> map) {
			if (noOfchild(start, map) == 0) {
				return 0;
			}

			map.put(start, true);

			double ans = 0;
			int nochild = noOfchild(start, map);
			for (String nbrs : vces.get(start).nbrs.keySet()) {
				if (!map.containsKey(nbrs)) {
					ans += dfs(nbrs, map) / nochild;
				}
			}
			ans += 1;
			return ans;
		}

		private int noOfchild(String s, HashMap<String, Boolean> map) {
			int count = 0;
			for (String nbrs : vces.get(s).nbrs.keySet()) {
				if (!map.containsKey(nbrs)) {
					count++;
				}
			}

			return count;

		}
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		FastReader fr = new FastReader();
		int n = fr.nextInt();
		for (int i = 1; i <= n; i++) {
			g.addVertex("" + i);
		}

		int temp = n;
		temp--;
		while (temp > 0) {
			g.addEdge("" + fr.nextInt(), "" + fr.nextInt(), 1);
			temp--;
		}

		HashMap<String, Boolean> map = new HashMap<>();
		System.out.println(g.dfs("1", map));

	}

}
