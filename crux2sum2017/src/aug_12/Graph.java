package aug_12;

import java.util.*;

import july_31.GenericHeap;

public class Graph {

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

	public boolean hasPath(String v1name, String v2name) {
		HashMap<String, Boolean> processed = new HashMap<>();
		return hasPath(v1name, v2name, processed);
	}

	private boolean hasPath(String v1name, String v2name, HashMap<String, Boolean> processed) {
		if (processed.containsKey(v1name) == true) {
			return false;
		}

		processed.put(v1name, true);

		if (vces.get(v1name) == null || vces.get(v2name) == null) {
			System.out.println("vertex not present");
			return false;
		}

		Vertex vrtx1 = vces.get(v1name);

		if (vrtx1.nbrs.containsKey(v2name)) {
			return true;
		}

		for (String name : vrtx1.nbrs.keySet()) {
			if (hasPath(name, v2name, processed)) {
				return true;
			}

		}
		return false;

	}

	public void printpath(String v1name, String v2name) {
		System.out.print(v1name);
		printpath(v1name, v2name, "", new HashMap<>());
		System.out.print("-");
		System.out.print(v2name + ".");
	}

	private void printpath(String v1name, String v2name, String path, HashMap<String, Boolean> processed) {

		processed.put(v1name, true);

		if (vces.get(v1name) == null || vces.get(v2name) == null) {
			System.out.print("vertex not present");
			return;
		}

		Vertex vrtx1 = vces.get(v1name);

		if (vrtx1.nbrs.containsKey(v2name)) {
			System.out.print(path);
			return;
		}

		for (String name : vrtx1.nbrs.keySet()) {
			if (!processed.containsKey(name)) {
				printpath(name, v2name, path + "-" + name, processed);
			}
		}

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

	public boolean bfs(String v1name, String v2name) {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		Pair rootp = new Pair(v1name, vces.get(v1name), v1name);
		queue.add(rootp);

		while (queue.size() != 0) {
			Pair rp = queue.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			System.out.println(rp.vname + " via " + rp.psf);
			if (this.containsEdge(rp.vname, v2name)) {
				System.out.println(v2name + " via " + rp.psf + v2name);
				return true;
			}

			for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
				if (!processed.containsKey(nbrs)) {
					Pair np = new Pair(nbrs, vces.get(nbrs), rp.psf + nbrs);
					queue.addLast(np);
				}
			}
		}
		return false;
	}

	public boolean dfs(String v1name, String v2name) {
		PriorityQueue<Integer> w = new PriorityQueue<>();
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();
		Pair rootp = new Pair(v1name, vces.get(v1name), v1name);
		stack.addFirst(rootp);

		while (stack.size() != 0) {
			Pair rp = stack.removeFirst();

			if (processed.containsKey(rp.vname)) {
				continue;
			}
			processed.put(rp.vname, true);

			System.out.println(rp.vname + " via " + rp.psf);
			if (this.containsEdge(rp.vname, v2name)) {
				System.out.println(v2name + " via " + rp.psf + v2name);
				return true;
			}

			for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
				if (!processed.containsKey(nbrs)) {
					Pair np = new Pair(nbrs, vces.get(nbrs), rp.psf + nbrs);
					stack.addFirst(np);
				}
			}
		}

		return false;
	}

	public void bft() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String s : vces.keySet()) {
			if (processed.containsKey(s)) {
				continue;
			}
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

	public void dft() {
		LinkedList<Pair> stack = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String s : vces.keySet()) {
			if (processed.containsKey(s)) {
				continue;
			}

			Pair rootp = new Pair(s, vces.get(s), s);
			stack.addFirst(rootp);

			while (stack.size() != 0) {
				Pair rp = stack.removeFirst();
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				System.out.println(rp.vname + " via " + rp.psf);

				for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
					if (!processed.containsKey(nbrs)) {
						Pair np = new Pair(nbrs, vces.get(nbrs), rp.psf + nbrs);
						stack.addFirst(np);
					}
				}
			}
		}

	}

	public boolean isConnected() {

		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		int counter = 0;
		for (String s : vces.keySet()) {
			if (processed.containsKey(s)) {
				continue;
			}

			counter++;
			Pair rootp = new Pair(s, vces.get(s), s);
			queue.add(rootp);

			while (queue.size() != 0) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					continue;
				}
				processed.put(rp.vname, true);

				// System.out.println(rp.vname + " via " + rp.psf);

				for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
					if (!processed.containsKey(nbrs)) {
						Pair np = new Pair(nbrs, vces.get(nbrs), rp.psf + nbrs);
						queue.addLast(np);
					}
				}
			}
		}

		return counter == 1;

	}

	public boolean isCyclic() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		for (String s : vces.keySet()) {
			if (processed.containsKey(s)) {
				continue;
			}
			Pair rootp = new Pair(s, vces.get(s), s);
			queue.add(rootp);

			while (queue.size() != 0) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					return true;
				}
				processed.put(rp.vname, true);

				// System.out.println(rp.vname + " via " + rp.psf);

				for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
					if (!processed.containsKey(nbrs)) {
						Pair np = new Pair(nbrs, vces.get(nbrs), rp.psf + nbrs);
						queue.addLast(np);
					}
				}
			}
		}

		return false;

	}

	public boolean isTree() {
		return this.isConnected() && !this.isCyclic();
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

	public HashMap<String, DjikstraPair> djikstra(String src) {
		HashMap<String, DjikstraPair> rv = new HashMap<>();
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

		return rv;

	}

	private static class PrimsPair {
		String vname;
		String ac;
		int csf;

		public String toString() {
			return ac + "@" + csf;
		}

		public static final PrimsPairComaparator ctor = new PrimsPairComaparator();

		public PrimsPair(String vname, String ac, int csf) {
			this.csf = csf;
			this.ac = ac;
			this.vname = vname;

		}

		public static class PrimsPairComaparator implements Comparator<PrimsPair> {

			@Override
			public int compare(PrimsPair o1, PrimsPair o2) {
				return o2.csf - o1.csf;
			}

		}

	}

	public Graph PrimsMST() {
		Graph mst = new Graph();
		HashMap<String, PrimsPair> rv = new HashMap<>();
		GenericHeap<PrimsPair> heap = new GenericHeap<>(PrimsPair.ctor);

		for (String s : vces.keySet()) {
			PrimsPair dp = new PrimsPair(s, null, Integer.MAX_VALUE);
			rv.put(s, dp);
			heap.add(dp);
		}

		while (heap.size() != 0) {
			PrimsPair rp = heap.removeHP();

			mst.addVertex(rp.vname);
			if (rp.ac != null) {
				mst.addEdge(rp.vname, rp.ac, rp.csf);
			}

			for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
				if (mst.containsVertex(nbrs)) {
					continue;
				}
				int newCount = vces.get(rp.vname).nbrs.get(nbrs);
				int oldCount = rv.get(nbrs).csf;

				if (newCount < oldCount) {
					PrimsPair np = rv.get(nbrs);
					np.csf = newCount;
					np.ac = rp.vname;
					heap.updatePriority(np);
				}
			}

		}

		return mst;

	}

	public boolean isBipartite2() {
		HashMap<String, Boolean> processed = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();

		for (String v : vces.keySet()) {
			processed.put(v, true);
			for (String n : vces.get(v).nbrs.keySet()) {
				if (!processed.containsKey(n)) {
					list.add(n);
				}
			}
			for (int i = 0; i < list.size() - 1; i++) {
				if (this.containsEdge(list.get(i), list.get(i + 1))) {
					return false;
				}
			}
			list = new ArrayList<>();
		}

		return true;
	}

	public boolean isBipartite() {
		LinkedList<Pair> queue = new LinkedList<>();
		HashMap<String, String> processed = new HashMap<>();

		for (String s : vces.keySet()) {
			if (processed.containsKey(s)) {
				continue;
			}
			Pair rootp = new Pair(s, vces.get(s), s);
			rootp.color = "red";
			queue.add(rootp);

			while (queue.size() != 0) {
				Pair rp = queue.removeFirst();

				if (processed.containsKey(rp.vname)) {
					if (!processed.get(rp.vname).equals(rp.color)) {
						return false;
					}
					continue;
				}
				processed.put(rp.vname, rp.color);

				System.out.println(rp.vname + " via " + rp.psf);

				for (String nbrs : vces.get(rp.vname).nbrs.keySet()) {
					if (!processed.containsKey(nbrs)) {
						Pair np = new Pair(nbrs, vces.get(nbrs), rp.psf + nbrs);
						if (rp.color == "red") {
							np.color = "green";
						} else {
							np.color = "red";
						}
						queue.addLast(np);
					}
				}
			}
		}
		return true;
	}

}
