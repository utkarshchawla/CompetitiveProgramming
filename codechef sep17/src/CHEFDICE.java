import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CHEFDICE {

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

		public void display() {

			for (String name : vces.keySet()) {
				String s = "";
				s += name + " => ";
				for (String nbr : vces.get(name).nbrs.keySet()) {
					s += nbr + "[" + vces.get(name).nbrs.get(nbr) + "], ";
				}
				System.out.println(s + ".");
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
		int t = fr.nextInt();
		while (t-- > 0) {
			boolean flag = false;
			boolean flag2 = true;
			Graph g = new Graph();
			int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
			int n = fr.nextInt();
			int x = fr.nextInt();
			g.addVertex(x + "");
			n--;
			while (n-- > 0) {
				int v1 = fr.nextInt();
				g.addVertex(v1 + "");
				if (x == v1) {
					flag2 = false;
					break;
				}
				g.addEdge(x + "", v1 + "", 1);
				x = v1;
			}

			if (flag2) {
				o: for (a = 1; a <= 6; a++) {
					for (b = 1; b <= 6; b++) {
						for (c = 1; c <= 6; c++) {
							for (d = 1; d <= 6; d++) {
								for (e = 1; e <= 6; e++) {
									for (f = 1; f <= 6; f++) {
										if (isok(a, b, c, d, e, f, g) && a != b && a != c && a != d && a != e && a != f
												&& b != c && b != d && b != e && b != f && c != d && c != e && c != f
												&& d != e && d != f && e != f && a != 1 && b != 2 && c != 3 && d != 4
												&& e != 5 && f != 6) {
											flag = true;
											break o;
										}
									}

								}
							}
						}
					}
				}
			}
			if (flag) {
				System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f);
			} else {
				System.out.println("-1");
			}
		}
	}

	private static boolean isok(int a, int b, int c, int d, int e, int f, Graph g) {
		if (g.containsEdge("1", a + "") || g.containsEdge("2", b + "") || g.containsEdge("3", c + "")
				|| g.containsEdge("4", d + "") || g.containsEdge("5", e + "") || g.containsEdge("6", f + "")) {
			return false;
		}
		return true;
	}

}
