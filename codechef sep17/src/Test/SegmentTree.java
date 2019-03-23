package Test;

public class SegmentTree {

	private class Node {
		int data;
		int si;
		int ei;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public SegmentTree(int[] arr) {
		root = construct(arr, 0, arr.length - 1);
	}

	private Node construct(int[] arr, int si, int ei) {

		if (si == ei) {
			Node base = new Node();
			this.size++;
			base.si = base.ei = si;
			base.data = arr[si];
			return base;
		}

		int mid = (si + ei) / 2;
		Node node = new Node();
		this.size++;
		node.si = si;
		node.ei = ei;

		node.left = construct(arr, si, mid);
		node.right = construct(arr, mid + 1, ei);
		node.data = node.right.data + node.left.data;
		return node;

	}

	public int query(int qsi, int qei) {
		return query(root, qsi, qei);
	}

	private int query(Node node, int qsi, int qei) {

		if (node.si >= qsi && node.ei <= qei) {
			return node.data;
		} else if (node.si > qei || node.ei < qsi) {
			return 0;
		} else {

			int l = query(node.left, qsi, qei);
			int r = query(node.right, qsi, qei);

			return l + r;
		}

	}

	public void update(int idx, int data) {
		update(root, idx, data);
	}

	private void update(Node node, int idx, int data) {
		int mid = (node.si + node.ei) / 2;

		if (node.left == null && node.right == null && node.ei == idx) {
			node.data = data;
			return;
		}

		if (node.left != null && idx <= mid) {
			update(node.left, idx, data);
		}
		if (node.right != null && idx > mid) {
			update(node.right, idx, data);
		}

		if (node.left != null && node.right != null) {
			node.data = node.left.data + node.right.data;
		}

	}

}
