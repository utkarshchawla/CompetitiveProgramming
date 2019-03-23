import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class D {

	public static class Graph {
		public class Vertex {
			HashMap<String, Integer> nbrs = new HashMap<>();
			int idx;
		}

		HashMap<String, Vertex> vces = new HashMap<>();

		public int numVertices() {
			return vces.size();
		}

		public boolean containsVertex(String vname) {
			return vces.containsKey(vname);
		}

		public void addVertex(String vname, int idx) {
			if (vces.containsKey(vname)) {
				return;
			}

			Vertex v = new Vertex();
			v.idx = idx;
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

		private class Pair {
			String vname;
			Vertex vrtx;
			String psf;
			String color;

			Pair(String vname, Vertex vrtx, String psf) {
				this.psf = psf;
				this.vname = vname;
				this.vrtx = vrtx;
			}
		}

		public void bft() {
			LinkedList<Pair> queue = new LinkedList<>();
			HashMap<String, Boolean> processed = new HashMap<>();

			for (String s : vces.keySet()) {
				if (processed.containsKey(s)) {
					continue;
				}

				if (vces.get(s).nbrs.size() % 2 == vces.get(s).idx || vces.get(s).idx == -1) {
					Pair rootp = new Pair(s, vces.get(s), s);
					queue.add(rootp);

					while (queue.size() != 0) {
						Pair rp = queue.removeFirst();

						if (processed.containsKey(rp.vname)) {
							continue;
						}
						processed.put(rp.vname, true);

						System.out.println(rp.vname + " via " + rp.psf);

						for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
							if (!processed.containsKey(nbrs)) {
								Pair np = new Pair(nbrs, vces.get(nbrs), rp.psf + nbrs);
								queue.addLast(np);
							}
						}
					}
				}
			}

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
		int v = fr.nextInt();
		int e = fr.nextInt();
		Graph g = new Graph();

		for (int i = 0; i < v; i++) {
			g.addVertex(i + 1 + "", fr.nextInt());

		}
		int count = 1;
		for (int i = 0; i < e; i++) {
			int a = fr.nextInt();
			int b = fr.nextInt();
			g.addEdge(a + "", b + "", count);
			count++;
		}

		g.bft();

	}

}
