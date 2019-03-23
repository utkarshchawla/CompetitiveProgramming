package july_25;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

import june_23.arraylist;

public class GT {

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	Node root;
	int size;

	public GT() {
		Scanner scn = new Scanner(System.in);
		System.out.println("enter input");
		this.root = takeInput(root, -1, scn);
	}

	public Node takeInput(Node parent, int childIdx, Scanner scn) {

		// if (parent == null) {
		// System.out.println("enter the root of the tree");
		// } else {
		// System.out.println("enter the data for the " + childIdx + " th
		// Node");
		// }

		int data = scn.nextInt();

		Node child = new Node();
		size++;

		child.data = data;

		// System.out.println("enter the no of childs of this node");
		int ChildCount = scn.nextInt();

		for (int i = 0; i < ChildCount; i++) {
			Node GC = takeInput(child, i, scn);
			child.children.add(GC);
		}

		return child;

	}

	public void display() {
		display(root);
		System.out.println("-------------------------------------------------");
	}

	private void display(Node a) {
		System.out.print(a.data + " => ");

		for (Node child : a.children) {
			System.out.print(child.data + ", ");
		}
		System.out.println(".");

		for (Node child : a.children) {
			display(child);
		}

	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node a) {
		int s = 0;
		for (Node v : a.children) {
			int c = size2(v);
			s += c;
		}

		s++;
		return s;

	}

	public int max() {
		return max(root);
	}

	private int max(Node a) {
		int m = a.data;

		for (Node child : a.children) {
			int d = max(child);
			if (d > m) {
				m = d;
			}
		}
		return m;
	}

	public int height() {
		return height(root);
	}

	private int height(Node a) {
		int h = -1;
		for (Node val : a.children) {
			int r = height(val);
			if (r > h) {
				h = r;
			}
		}
		h++;
		return h;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node a, int data) {

		boolean b = false;
		if (a.data == data) {
			return true;
		} else {
			for (Node val : a.children) {
				b = find(val, data);
				if (b == true) {
					break;
				}
			}
			return b;
		}

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node a) {

		int left = 0;
		int right = a.children.size() - 1;

		for (Node val : a.children) {
			mirror(val);
		}
		while (left < right) {
			Node l = a.children.get(left);
			Node r = a.children.get(right);

			a.children.set(left, r);
			a.children.set(right, l);
			left++;
			right--;
		}
	}

	public void levelOrder() {
		LinkedList<Node> q = new LinkedList<>();
		q.addLast(root);
		while (q.size() != 0) {
			Node a = q.removeFirst();
			System.out.print(a.data + ", ");
			for (Node child : a.children) {
				q.addLast(child);
			}
		}
	}

	public void levelOrderLW() {
		LinkedList<Node> q = new LinkedList<>();
		LinkedList<Node> nq = new LinkedList<>();
		q.addLast(root);
		while (q.size() != 0) {
			Node a = q.removeFirst();
			System.out.print(a.data + ", ");

			for (Node child : a.children) {
				nq.addLast(child);
			}

			if (q.size() == 0) {
				q = nq;
				nq = new LinkedList<>();
				System.out.println();
			}
		}
	}

	public class HeapMover {
		int size;
		boolean found;
		int height = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		Node curr;
		Node prev;
		Node prec;
		Node succ;
		Node jl;
	}

	public void multiSolver(int data) {
		HeapMover bucket = new HeapMover();
		multiSolver(root, 0, data, bucket);
		System.out.println("size = " + bucket.size);
		System.out.println("height = " + bucket.height);
		System.out.println("max = " + bucket.max);
		System.out.println("min = " + bucket.min);
		System.out.println("found = " + bucket.found);
		if (bucket.jl == null) {
			System.out.println("no next larger value");
		} else {
			System.out.println("just larger = " + bucket.jl.data);
		}
		if (bucket.prec == null) {
			System.out.println("No preceding val");
		} else {
			System.out.println("prec = " + bucket.prec.data);
		}

		if (bucket.succ == null) {
			System.out.println("No succeding val");
		} else {
			System.out.println("succ = " + bucket.succ.data);

		}

	}

	private void multiSolver(Node node, int depth, int data, HeapMover bucket) {
		bucket.prev = bucket.curr;
		bucket.curr = node;

		bucket.size++;

		if (bucket.found == true && bucket.succ == null) {
			bucket.succ = bucket.curr;
		}

		if (node.data == data) {
			bucket.found = true;
			bucket.prec = bucket.prev;
		}

		if (depth > bucket.height) {
			bucket.height = depth;
		}
		if (node.data > bucket.max) {
			bucket.max = node.data;
		}

		if (node.data < bucket.min) {
			bucket.min = node.data;
		}

		if (node.data > data) {
			if (bucket.jl == null) {
				bucket.jl = node;
			} else {
				if (node.data < bucket.jl.data) {
					bucket.jl = node;
				}
			}
		}

		for (Node child : node.children) {
			multiSolver(child, depth + 1, data, bucket);
		}
	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {

		for (int i = node.children.size() - 1; i >= 0; i--) {
			if (node.children.get(i).children.size() == 0) {
				node.children.remove(i);
			}
		}

		for (Node child : node.children) {
			removeLeaves(child);
		}

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		for (Node child : node.children) {
			linearize(child);
		}

		for (int i = node.children.size() - 1; i >= 1; i--) {
			Node a = node.children.remove(i);
			Node b = getTail(node.children.get(i - 1));
			b.children.add(a);
		}

	}

	private Node getTail(Node a) {
		while (a.children.size() != 0) {
			a = a.children.get(0);
		}

		return a;
	}

	public void levelOrderZZ() {
		levelOrderZZ(false);
	}

	private void levelOrderZZ(boolean flag) {

		LinkedList<Node> q = new LinkedList<>();
		LinkedList<Node> nq = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();

		q.addLast(root);

		while (q.size() != 0) {
			Node a = null;
			a = q.removeFirst();
			if (flag == true) {
				list.add(a.data);
			} else {
				list.add(0, a.data);
			}

			for (Node child : a.children) {
				nq.addLast(child);
			}

			if (q.size() == 0) {
				System.out.println(list);
				list = new ArrayList<>();
				flag = !flag;
				q = nq;
				nq = new LinkedList<>();
			}
		}
	}

	public boolean isIso(GT c) {
		ArrayList<Integer> la = new ArrayList<>();
		ArrayList<Integer> lb = new ArrayList<>();
		helper(root, la, 0);
		helper(c.root, lb, 0);
		if (la.size() != lb.size()) {
			return false;
		}
		for (int i = 0; i < la.size(); i++) {
			if (la.get(i) != lb.get(i)) {
				return false;
			}
		}
		return true;
	}

	private void helper(Node a, ArrayList<Integer> la, int count) {

		// la.add(Integer.MIN_VALUE);
		for (Node child : a.children) {
			la.add(count);
		}
		// la.add(Integer.MAX_VALUE);
		for (Node child : a.children) {
			helper(child, la, count + 1);
		}
	}

	public boolean mirrorIso() {

		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> bl = new ArrayList<>();

		this.mirror();
		helper(root, al, 0);
		this.mirror();
		helper(root, bl, 0);

		for (int i = 0; i < al.size(); i++) {
			if (al.get(i) != bl.get(i)) {
				return false;
			}
		}
		return true;
	}

	public void rootleaf(int target) {
		rootleaf(target, root, "");
	}

	private void rootleaf(int target, Node node, String s) {
		if (target == 0) {
			if (node == null) {
				System.out.println(s);
			} else if (node.children.size() == 0) {
				System.out.println(s);
			}
			return;
		}

		if (node == null) {
			return;
		}

		if (node.children.size() == 0) {
			rootleaf(target - node.data, null, s + node.data + " => ");

		}

		for (Node child : node.children) {
			rootleaf(target - node.data, child, s + node.data + " => ");
		}
	}

	public int sumNode() {
		return sumNode(root, 0);
	}

	private int sumNode(Node node, int sum) {

		int a = node.data;
		for (Node child : node.children) {
			a += sumNode(child, sum + node.data);
		}
		return a;
	}

	public void replaceDepthValue() {
		replaceDepthValue(root, 0);
	}

	private void replaceDepthValue(Node node, int count) {

		for (Node child : node.children) {
			replaceDepthValue(child, count + 1);
		}

		node.data = count;
	}

	public void linearize2() {
		linearize2(root);

	}

	private Node linearize2(Node node) {
		if (node.children.size() == 0) {
			return node;
		}

		Node tail = null;
		for (Node child : node.children) {
			if (tail != null) {
				tail.children.add(child);
			}

			tail = linearize2(child);
		}

		while (node.children.size() != 1) {
			node.children.remove(node.children.size() - 1);
		}

		return tail;

	}

	// public void flatten() {
	// ArrayList<Node> list = new ArrayList<>();
	// flatten(root, list);
	//
	// root.children.clear();
	//
	// for (int i = 0; i < list.size(); i++) {
	// list.get(i).children.clear();
	// root.children.add(list.get(i));
	// }
	//
	// }
	//
	// private void flatten(Node node, ArrayList<Node> list) {
	// if (node.children.size() == 0) {
	// return;
	// }
	//
	// for (int i = 0; i < node.children.size(); i++) {
	// Node child = node.children.get(i);
	// list.add(child);
	// flatten(child, list);
	// }
	// }

	public void flatten() {
		this.flatten(root);
	}

	private void flatten(Node node) {

		for (Node child : node.children) {
			flatten(child);
		}

		// for (Node child : node.children) {
		int size = node.children.size();
		for (int i = 0; i < size; i++) {
			Node child = node.children.get(i);
			for (Node gc : child.children) {
				node.children.add(gc);
			}
			child.children = new ArrayList<>();
		}
	}

	public boolean isMirror2() {
		return isMirror2(root, root);
	}

	private boolean isMirror2(Node lmnode, Node rmnode) {
		if (lmnode.children.size() != rmnode.children.size()) {
			return false;
		}

		for (int i = 0; i < lmnode.children.size(); i++) {
			Node lc = lmnode.children.get(i);
			Node rc = rmnode.children.get(rmnode.children.size() - 1 - i);

			if (!isMirror2(rc, lc)) {
				return false;
			}
		}

		return true;

	}
}
