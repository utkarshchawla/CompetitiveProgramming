package long_sep17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FILLMTR {

	static class Graph {
		public class Vertex {
			HashMap<String, Integer> nbrs = new HashMap<>();
		}

		HashMap<String, Vertex> vces = new HashMap<>();

		public int numVertices() {
			return vces.size();
		}

		public boolean containsVertex(String vname) {
			return vces.containsKey(vname);
		}

		public void addVertex(String vname) {
			if (vces.containsKey(vname)) {
				return;
			}

			Vertex v = new Vertex();
			vces.put(vname, v);
		}

		public void removeVertex(String vname) {
			for (String name : vces.keySet()) {
				if (vces.get(name).nbrs.containsKey(vname)) {
					vces.get(name).nbrs.remove(vname);
				}
			}

			vces.remove(vname);

		}

		public int numEdges() {
			int val = 0;
			for (String name : vces.keySet()) {
				val += vces.get(name).nbrs.size();
			}
			return val / 2;

		}

		public void removeEdge(String v1name, String v2name) {
			if (vces.get(v1name) == null || vces.get(v2name) == null) {
				return;
			}

			vces.get(v1name).nbrs.remove(v2name);
			vces.get(v2name).nbrs.remove(v1name);

		}

		public boolean containsEdge(String v1name, String v2name) {
			if (vces.get(v1name) == null || vces.get(v2name) == null) {
				return false;
			}

			if (vces.get(v2name).nbrs.containsKey(v1name) && vces.get(v1name).nbrs.containsKey(v2name)) {
				return true;
			}

			return false;
		}

		public void addEdge(String v1name, String v2name, int weight) {
			if (vces.get(v1name) == null || vces.get(v2name) == null) {
				return;
			}

			vces.get(v1name).nbrs.put(v2name, weight);
			vces.get(v2name).nbrs.put(v1name, weight);
		}

		public boolean merge(String v1name, String v2name) {
			removeEdge(v1name, v2name);
			addVertex(v1name + v2name);
			for (String nbr1 : vces.get(v1name).nbrs.keySet()) {
				addEdge(v1name + v2name, nbr1, vces.get(v1name).nbrs.get(nbr1));
			}
			removeVertex(v1name);

			for (String nbr2 : vces.get(v2name).nbrs.keySet()) {
				if (containsEdge(v1name + v2name, nbr2)) {
					if (vces.get(v1name + v2name).nbrs.get(nbr2) != vces.get(v2name).nbrs.get(nbr2)) {
						return false;
					}
				} else {
					addEdge(v1name + v2name, nbr2, vces.get(v2name).nbrs.get(nbr2));
				}
			}
			removeVertex(v2name);
			return true;
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
		int t = fr.nextInt();
		while (t-- > 0) {
			int n = fr.nextInt();
			int q = fr.nextInt();

			Graph g = new Graph();
			for (int i = 1; i <= n; i++) {
				g.addVertex("" + i);
			}

			boolean flag = true;
			while (q-- > 0) {
				int a = fr.nextInt();
				int b = fr.nextInt();
				int val = fr.nextInt();

				if (g.containsEdge("" + a, "" + b)) {
					if (g.vces.get("" + a).nbrs.get("" + b) != val) {
						flag = false;
					}
				} else if (a != b) {
					g.addEdge("" + a, "" + b, val);
				}

			}

			ArrayList<String> iteratorv = new ArrayList<>(g.vces.keySet());
			for (String vrtx : iteratorv) {
				if (g.containsVertex(vrtx)) {
					ArrayList<String> iteratorn = new ArrayList<>(g.vces.get(vrtx).nbrs.keySet());
					for (String nbr : iteratorn) {
						if (g.containsEdge(vrtx, nbr)) {
							if (g.vces.get(vrtx).nbrs.get(nbr) == 0) {
								if (!g.merge(vrtx, nbr)) {
									flag = false;
								}
							}
						}
					}
				}
			}

			int noTria = 0;
			if (flag) {
				for (String edge1 : g.vces.keySet()) {
					for (String edge2 : g.vces.get(edge1).nbrs.keySet()) {
						for (String vrtx : g.vces.keySet()) {
							if (g.containsEdge(edge1, vrtx) && g.containsEdge(edge2, vrtx)) {
								noTria++;
							}
						}
					}
				}
			}

			if (!flag || noTria > 0) {
				System.out.println("no");
			} else {
				System.out.println("yes");
			}

		}

	}

}
