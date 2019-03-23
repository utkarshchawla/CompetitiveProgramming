package aug_6;

public class linkedList<T> {

	public class HeapMover {
		Node node;
	}

	public class Node {
		T data;
		Node next;
	}

	int size;
	Node head;
	Node tail;

	public void addLast(T val) {
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

	public void addFirst(T val) {
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

	public Node getNodeAt(int idx) throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		Node rn = this.head;
		for (int i = 0; i < idx; i++) {
			rn = rn.next;
		}
		return rn;
	}

	public T getAt(int idx) throws Exception {
		return getNodeAt(idx).data;
	}

	public void addAt(int idx, T val) throws Exception {
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

	public T getFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		return this.head.data;
	}

	public T getLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		return this.tail.data;
	}

	public T removeFirst() throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		T rv = this.head.data;
		if (size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		size--;
		return rv;
	}

	public T removeLast() throws Exception {
		if (this.size == 0) {
			throw new Exception("ll is empty");
		}
		T rv = this.tail.data;
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

	public T removeAt(int idx) throws Exception {
		if (idx == 0) {
			return removeFirst();
		} else if (idx == this.size - 1) {
			return removeLast();
		} else {
			T rv = getAt(idx);
			Node m1 = getNodeAt(idx - 1);
			Node p1 = m1.next;
			m1.next = p1.next;
			size--;
			return rv;
		}

	}

}
