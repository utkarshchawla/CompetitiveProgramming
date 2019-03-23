package assignment_LL;

public class LL {
	public class Node {
		int data;
		Node next;
	}

	int size;
	Node head;
	Node tail;

	public class HeapMover {
		Node node;
	}

	public void addLast(int val) {
		Node node = new Node();
		node.data = val;
		node.next = null;

		if (size == 0) {
			this.head = node;
		} else {
			this.tail.next = node;

		}

		this.tail = node;
		size++;
	}

	public void display() {
		System.out.println("-------------------------------------");
		for (Node temp = this.head; temp != null; temp = temp.next) {
			System.out.print(temp.data + ", ");
		}
		System.out.println();
		System.out.println("-------------------------------------");
	}

	public void addFirst(int val) {
		Node node = new Node();
		node.data = val;

		if (size == 0) {
			this.tail = node;
			node.next = null;
		} else {
			node.next = this.head;
		}
		this.head = node;
		size++;
	}

	public int getAt(int idx) throws Exception {
		return getNodeAt(idx).data;
	}

	public void addAt(int idx, int val) throws Exception {
		Node node = new Node();
		node.data = val;
		if (idx == 0) {
			addFirst(val);
		} else if (idx == this.size - 1) {
			addLast(val);
		} else {
			Node m1 = getNodeAt(idx - 1);
			Node p1 = m1.next;

			m1.next = node;
			node.next = p1;
			size++;
		}
	}

	public int getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		return this.tail.data;
	}

	public int removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		int rv = this.head.data;
		if (size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		size--;
		return rv;
	}

	public int removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		int rv = this.tail.data;
		if (size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.tail = getNodeAt(this.size - 2);
			this.tail.next = null;
		}
		size--;
		return rv;
	}

	public int removeAt(int idx) throws Exception {
		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {
			int rv = getAt(idx);
			Node m1 = getNodeAt(idx - 1);
			Node p1 = m1.next;
			m1.next = p1.next;
			size--;
			return rv;
		}

	}

	public Node getNodeAt(int idx) throws Exception {
		if (idx < 0 || idx >= this.size) {
			throw new Exception("index out of bound");
		}
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void reverseData() throws Exception {
		int left = 0;
		int right = this.size - 1;
		while (left <= right) {
			Node a = getNodeAt(left);
			Node b = getNodeAt(right);

			int temp = a.data;
			a.data = b.data;
			b.data = temp;

			left++;
			right--;
		}
	}

	public void ques1(int i, int j) throws Exception {
		if (i == 0) {

			Node a = this.head.next;
			Node b = getNodeAt(j - 1);
			Node c = b.next;
			Node d = c.next;

			c.next = a;
			b.next = this.head;
			this.head.next = d;
			this.head = c;

		} else if (j - i == 1) {
			Node a = getNodeAt(i - 1);
			Node b = a.next;
			Node c = b.next;
			Node d = c.next;
			a.next = c;
			c.next = b;
			b.next = d;

		} else {

			Node im1 = getNodeAt(i - 1);
			Node jm1 = getNodeAt(j - 1);

			Node itemp = im1.next;
			Node jtemp = jm1.next;

			im1.next = jm1.next;
			Node temp = jtemp.next;
			jtemp.next = itemp.next;
			jm1.next = itemp;
			itemp.next = temp;
		}

	}

	public void ques2() throws Exception {
		LL nl = new LL();
		nl.addLast(this.removeFirst());
		while (this.size != 0) {
			int val = this.removeFirst();
			if (nl.tail.data != val) {
				nl.addLast(val);
			}
		}

		this.head = nl.head;
		this.tail = nl.tail;
		this.size = nl.size;
	}

	public void ques9() throws Exception {
		LL even = new LL();
		LL odd = new LL();
		while (this.size != 0) {
			int val = removeFirst();
			if (val % 2 == 0) {
				even.addLast(val);
			} else {
				odd.addLast(val);
			}
		}

		odd.tail.next = even.head;
		odd.tail = even.tail;

		this.head = odd.head;
		this.tail = odd.tail;
		this.size = odd.size;
	}

	public void ques11(int n) throws Exception {
		Node a = getNodeAt(this.size - n - 1);
		Node b = a.next;

		this.tail.next = this.head;
		this.head = b;
		this.tail = a;
		this.tail.next = null;
	}

	public void bubbleSort() {
		for (int i = 0; i < this.size - 1; i++) {
			for (Node j = this.head; j.next != null; j = j.next) {
				if (j.data > j.next.data) {
					int temp = j.data;
					j.data = j.next.data;
					j.next.data = temp;
				}
			}
		}
	}

	public void selectionSort() throws Exception {
		for (int i = 0; i < this.size - 1; i++) {
			Node t = getNodeAt(i);
			for (Node j = t.next; j != null; j = j.next) {
				if (t.data > j.data) {
					int temp = j.data;
					j.data = t.data;
					t.data = temp;
				}
			}
		}
	}

	public void insertionSort() throws Exception {
		for (int i = 1; i < this.size; i++) {
			LL temp = new LL();
			for (int j = 0; j <= i; j++) {
				temp.addFirst(removeFirst());
			}
			for (Node c = temp.head; c.next != null; c = c.next) {
				if (c.data < c.next.data) {
					int t = c.data;
					c.data = c.next.data;
					c.next.data = t;
				} else {
					break;
				}
			}

			while (this.size != 0) {
				temp.addFirst(removeFirst());
			}

			temp.reverseData();
			this.head = temp.head;
			this.tail = temp.tail;
			this.size = temp.size;

		}

	}

	public void bubbleSortRecursive() {
		bubbleSortRecursive(this.head, this.tail, 0);
	}

	private void bubbleSortRecursive(Node curr, Node last, int count) {
		if (curr == this.tail) {
			bubbleSortRecursive(this.head, last, count + 1);
			return;
		}
		if (count == this.size - 1) {
			return;
		}

		Node next = curr.next;
		if (curr.data > next.data) {
			int temp = curr.data;
			curr.data = next.data;
			next.data = temp;
		}

		bubbleSortRecursive(curr.next, last, count);

	}

	public void selectionSortRecursive() {
		selectionSortRecursive(this.head, this.head.next, 0);
	}

	private void selectionSortRecursive(Node curr, Node next, int count) {
		if (count == this.size - 1) {
			return;
		}

		if (next == null) {
			selectionSortRecursive(curr.next, curr.next.next, count + 1);
			return;
		}

		if (curr.data > next.data) {
			int temp = curr.data;
			curr.data = next.data;
			next.data = temp;
		}

		selectionSortRecursive(curr, next.next, count);

	}

	private void insertionSortRecursive(Node curr) {
		LL temp = new LL();
		for (Node a = this.head; a != curr; a = a.next) {
			temp.addFirst(a.data);
		}
		temp.addFirst(curr.data);

	}

	public void insertionSortRecursive() {

	}
}