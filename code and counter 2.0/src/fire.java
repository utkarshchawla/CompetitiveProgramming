package codeAndCounter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class fire {

	static class GenericHeap<T> {
		private ArrayList<T> data = new ArrayList<>();
		private Comparator<T> ctor;

		public GenericHeap(Comparator<T> ctor) {
			this.ctor = ctor;
		}

		public void add(T value) {
			data.add(value);
			upHeapify(data.size() - 1);
		}

		private void upHeapify(int ci) {
			if (ci == 0) {
				return;
			}

			int pi = (ci - 1) / 2;

			if (isLarger(ci, pi)) {
				swap(ci, pi);
				upHeapify(pi);
			}

		}

		public T removeHP() {
			swap(0, data.size() - 1);
			T rv = data.remove(data.size() - 1);

			downheapify(0);
			return rv;
		}

		private void downheapify(int pi) {
			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;

			int maxi = pi;
			if (lci < data.size() && isLarger(lci, maxi)) {
				maxi = lci;
			}

			if (rci < data.size() && isLarger(rci, maxi)) {
				maxi = rci;
			}
			if (pi != maxi) {
				swap(pi, maxi);
				downheapify(maxi);
			}

		}

		public boolean isLarger(int i, int j) {

			T ith = data.get(i);
			T jth = data.get(j);

			return ctor.compare(ith, jth) > 0;
		}

		public void swap(int i, int j) {
			T ith = data.get(i);
			T jth = data.get(j);

			data.set(i, jth);
			data.set(j, ith);
		}

		public int size() {
			return data.size();
		}

		public void updatePriority(T val) {
			int idx = -1;
			for (int i = 0; i < data.size(); i++) {
				if (val.equals(data.get(i))) {
					idx = i;
				}
			}

			upHeapify(idx);
			downheapify(idx);
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

		private static class DjikstraPair {
			String vname;
			String psf;
			int csf;
			public static final djikstraPairComaparator ctor = new djikstraPairComaparator();

			public DjikstraPair(String vname, String psf, int csf) {
				this.csf = csf;
				this.psf = psf;
				this.vname = vname;

			}

			public static class djikstraPairComaparator implements Comparator<DjikstraPair> {

				@Override
				public int compare(DjikstraPair o1, DjikstraPair o2) {
					return o2.csf - o1.csf;
				}

			}

			@Override
			public String toString() {
				return psf + "@" + csf;
			}
		}

		public HashMap<Integer,String> djikstra(String src) {
			HashMap<String, DjikstraPair> rv = new HashMap<>();
			HashMap<Integer,String> map = new HashMap<>();
			GenericHeap<DjikstraPair> heap = new GenericHeap<>(DjikstraPair.ctor);

			for (String s : vces.keySet()) {
				DjikstraPair dp = new DjikstraPair(s, "", Integer.MAX_VALUE);
				if (s.equals(src)) {
					dp.csf = 0;
					dp.psf = s;
				}

				rv.put(s, dp);
				heap.add(dp);
			}

			while (heap.size() != 0) {
				DjikstraPair rp = heap.removeHP();

				for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
					int newCount = rp.csf + vces.get(rp.vname).nbrs.get(nbrs);
					int oldCount = rv.get(nbrs).csf;

					if (newCount < oldCount) {
						DjikstraPair np = rv.get(nbrs);
						np.csf = newCount;
						np.psf = rp.psf + nbrs;
						heap.updatePriority(np);
					}
				}

			}

			for (String s : rv.keySet()) {
				map.put(rv.get(s).csf,s);
			}
			return map;

		}

	}

	public static void main(String[] args) {
		FastReader fr = new FastReader();
		Graph g = new Graph();
		int n = fr.nextInt();
		int wof = fr.nextInt();

		for (int i = 1; i <= n; i++) {
			g.addVertex("" + i);
		}

		while (true) {
			int a = fr.nextInt();
			if (a == 0) {
				break;
			}

			int b = fr.nextInt();
			int c = fr.nextInt();
			g.addEdge(a + "", b + "", c);
		}

		HashMap<Integer,String> map = g.djikstra(wof + "");
		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		list.sort(null);
		
		long d = 0;
		for (Integer i : list) {
			System.out.print(map.get(i) + " ");
			d = (d + i) % 1000000007;
		}
		System.out.println();

		System.out.println(d);

	}

}
