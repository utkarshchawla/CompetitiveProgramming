package july_18;

public class linkedList {

    public class HeapMover {
        Node node;
    }

    public class Node {
        int data;
        Node next;
    }

    int size;
    Node head;
    Node tail;

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

    public void reverseDataIterative() throws Exception {
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

    public void reversePointerIterative() {
        Node a = this.head;
        Node b = a.next;
        while (b != null) {
            Node c = b.next;
            b.next = a;
            a = b;
            b = c;
        }

        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        this.tail.next = null;
    }

    public void reversePointerRecursive() {
        reversePointerRecursive(this.head, this.head.next);
        Node temp = this.head;
        this.head = this.tail;
        this.tail = temp;
        this.tail.next = null;
    }

    private void reversePointerRecursive(Node a, Node b) {
        if (b == null) {
            return;
        }
        Node c = b.next;
        b.next = a;
        reversePointerRecursive(b, c);

    }

    public void reverseDataRecursive() {
        HeapMover left = new HeapMover();
        left.node = this.head;
        reverseDataRecursive(left, this.head, 0);

    }

    private void reverseDataRecursive(HeapMover left, Node right, int floor) {
        if (right == null) {
            return;
        }

        reverseDataRecursive(left, right.next, floor + 1);
        if (floor >= this.size / 2) {
            int temp = right.data;
            right.data = left.node.data;
            left.node.data = temp;
            left.node = left.node.next;
        }

    }

    public boolean IsPalindrome() {
        HeapMover left = new HeapMover();
        left.node = this.head;
        return IsPalindrome(left, this.head);
    }

    private boolean IsPalindrome(HeapMover left, Node right) {
        if (right == null) {
            return true;
        }

        boolean b = IsPalindrome(left, right.next);
        if (b == true) {
            if (left.node.data != right.data) {
                return false;
            }
            left.node = left.node.next;
        }
        return b;


    }

    public void fold() throws Exception {
        HeapMover left = new HeapMover();
        left.node = this.head;
        Node temp = getNodeAt(size / 2);
        fold(left, this.head, 0);
        this.tail = temp;
        tail.next = null;
    }

    private void fold(HeapMover left, Node right, int floor) {
        if (right == null) {
            return;
        }
        fold(left, right.next, floor + 1);
        if (floor > size / 2) {
            Node temp = left.node.next;
            left.node.next = right;
            right.next = temp;
            left.node = temp;
        }
    }

    public int kthFromLast(int k) {
        Node sl = this.head;
        Node fs = this.head;
        for (int i = 1; i < k; i++) {
            fs = fs.next;
        }
        while (fs != this.tail) {
            fs = fs.next;
            sl = sl.next;
        }
        return sl.data;

    }

    public int midElement() {
        Node sl = this.head;
        Node fs = this.head;

        if (this.size % 2 == 0) {
            fs = this.head.next;
        }

        while (fs != this.tail) {
            sl = sl.next;
            fs = fs.next.next;
        }

        return sl.data;
    }

    public void removeDupli() throws Exception {
        Node sl = this.head;
        Node fs = this.head.next;
        while (fs != null) {
            while (fs != null && sl.data == fs.data) {
                fs = fs.next;
            }
            sl.next = fs;
            sl = fs;
            if (fs != null) {
                fs = fs.next;
            }
        }
    }

    public linkedList mergeTwoLists(linkedList l) {
        linkedList c = new linkedList();
        Node a = this.head;
        Node b = l.head;
        while (a != null && b != null) {
            if (a.data < b.data) {
                c.addLast(a.data);
                a = a.next;
            } else {
                c.addLast(b.data);
                b = b.next;
            }

        }

        while (a != null) {
            c.addLast(a.data);
            a = a.next;
        }

        while (b != null) {
            c.addLast(b.data);
            b = b.next;
        }

        return c;
    }

    private Node midNode() {
        Node sl = this.head;
        Node fs = this.head;

        if (this.size % 2 == 0) {
            fs = this.head.next;
        }

        while (fs != this.tail && fs != null && fs.next != null) {
            sl = sl.next;
            fs = fs.next.next;
        }

        return sl;
    }

    public linkedList mergeSort() {
        if (this.size == 1) {
            return this;
        }
        Node mid = midNode();
        Node midNext = mid.next;

        linkedList fh = new linkedList();
        fh.head = this.head;
        fh.tail = mid;
        fh.tail.next = null;
        fh.size = (this.size + 1) / 2;

        linkedList sh = new linkedList();
        sh.head = midNext;
        sh.tail = this.tail;
//        sh.tail.next = null;
        sh.size = (this.size) / 2;

        sh = sh.mergeSort();
        fh = fh.mergeSort();

        return fh.mergeTwoLists(sh);
    }

    public void kthFromLastRec(int k) {
        intPair ip = new intPair();
        kthFromLastRec(k, head, ip);
    }

    public class intPair {
        int i = 0;
    }

    private void kthFromLastRec(int k, Node node, intPair ip) {
        if (node == null) {
            return;
        }
        kthFromLastRec(k, node.next, ip);
        ip.i++;
        if (ip.i == k) {
            System.out.println(node.data);
        }
    }

}
