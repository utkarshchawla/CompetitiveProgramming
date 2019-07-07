package july_24;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericTree {

    private class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private Node root;
    int size;

    public GenericTree() {
        Scanner scn = new Scanner(System.in);
        System.out.println("enter input");
        this.root = takeInput(root, -1, scn);
    }

    private Node takeInput(Node parent, int childIdx, Scanner scn) {
        int data = scn.nextInt();

        Node child = new Node();
        size++;

        child.data = data;

        int noGC = scn.nextInt();

        for (int i = 0; i < noGC; i++) {
            Node a = takeInput(child, i, scn);
            child.children.add(a);
        }

        return child;
    }

    public void display() {
        display(root);
    }

    private void display(Node a) {
        String s = a.data + "=> ";
        for (Node val : a.children) {
            s += val.data + ", ";
        }
        System.out.println(s + ".");

        for (Node val : a.children) {
            display(val);
        }
    }

    public int size2() {
        return size2(root);
    }

    private int size2(Node node) {
        int s = 0;
        for (Node child : node.children) {
            int cs = size2(child);
            s += cs;
        }

        s += 1;
        return s;
    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        int m = node.data;
        for (Node child : node.children) {
            int c = max(child);
            if (c > m) {
                m = c;
            }
        }
        return m;
    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        int h = -1;
        for (Node child : node.children) {
            int c = height(child);
            if (c > h) {
                h = c;
            }
        }
        h += 1;
        return h;
    }

    public boolean find(int data) {
        return find(data, root);
    }

    private boolean find(int data, Node a) {
        boolean b = false;
        if (a.data == data) {
            return true;
        }

        for (Node val : a.children) {
            b = find(data, val);
            if (b == true) {
                break;
            }
        }
        return b;
    }

    public void mirror() {
        mirror(root);
    }

    private void mirror(Node node) {
        int left = 0;
        int right = node.children.size() - 1;
        while (left <= right) {
            Node l = node.children.get(left);
            Node r = node.children.get(right);
            node.children.set(right, l);
            node.children.set(left, r);
            left++;
            right--;
        }
        for (Node val : node.children) {
            mirror(val);
        }
    }

    public void printAtDepth(int idx) {
        printAtDepth(idx, root, 0);
    }

    private void printAtDepth(int idx, Node node, int count) {

        if (count == idx) {
            System.out.print(node.data + ", ");
        }
        for (Node val : node.children) {
            printAtDepth(idx, val, count + 1);
        }


    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {

        System.out.print(node.data + ", ");
        for (Node val : node.children) {
            preOrder(val);
        }
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        for (Node val : node.children) {
            postOrder(val);
        }

        System.out.print(node.data + ", ");
    }

    public void levelOrder() {
        int count = 1;
        LinkedList<Node> cq = new LinkedList<>();
        LinkedList<Node> nq = new LinkedList<>();

        System.out.print(count + " . ");
        cq.addLast(root);
        while (cq.size() != 0) {
            Node rn = cq.removeFirst();
            System.out.print(rn.data + ", ");
            for (Node val : rn.children) {
                nq.addLast(val);
            }

            if (cq.size() == 0) {
                cq = nq;
                nq = new LinkedList<>();
                System.out.println();
                count++;
                System.out.print(count + " . ");
            }
        }
    }

    public class HeapMover {
        int size;
        boolean found;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int height = 0;
        Node pre;
        Node curr;
        Node jlarge = root;
        Node pred;
        Node succ;
        ArrayList<Integer> a = new ArrayList<>();

    }

    public void multisolver(int data) {
        HeapMover bucket = new HeapMover();
        // bucket.jlarge.data = Integer.MAX_VALUE;
        multisolver(root, bucket, 0, data);

        System.out.println("size = " + bucket.size);
        System.out.println("found = " + bucket.found);
        System.out.println("max = " + bucket.max);
        System.out.println("min = " + bucket.min);
        System.out.println("height = " + bucket.height);
        // System.out.println("justlarge = " + bucket.jlarge.data);
        if (bucket.pred == null) {
            System.out.println("pred not found");
        } else {
            System.out.println("pred = " + bucket.pred.data);
        }

        if (bucket.succ == null) {
            System.out.println("succ not found");
        } else {
            System.out.println("succ = " + bucket.succ.data);
        }
    }

    private void multisolver(Node node, HeapMover bucket, int depth, int data) {
        bucket.pre = bucket.curr;
        bucket.curr = node;

        bucket.size++;

        if (bucket.found == true && bucket.succ == null) {
            bucket.succ = bucket.curr;
        }

        if (node.data == data) {
            bucket.found = true;
            bucket.pred = bucket.pre;
        }

        if (node.data > bucket.max) {
            bucket.max = node.data;
        }

        if (node.data < bucket.min) {
            bucket.min = node.data;
        }

        if (depth > bucket.height) {
            bucket.height = depth;
        }

        if (node.data - data < bucket.jlarge.data && node.data - data > 0) {
            bucket.jlarge = node;
            // bucket.jlarge.data = node.data - data;
        }

        bucket.pre = node;
        for (Node child : node.children) {
            multisolver(child, bucket, depth + 1, data);

        }
    }

    // public void kthSmallest(int k) {
    // Node v = new Node();
    // ArrayList<Integer> ra = new ArrayList<>();
    // while (ra.size() <= this.size) {
    // v = this.min();
    // ra.add(v.data);
    // v.data = Integer.MAX_VALUE;
    // }
    //
    // System.out.println(ra.get(k - 1));
    // }
    //
    // public Node min() {
    // return minN(root);
    // }
    //
    // private Node minN(Node node) {
    // Node m = node;
    // for (Node child : node.children) {
    // Node c = minN(child);
    // if (c.data < m.data) {
    // m = c;
    // }
    // }
    // return m;
    // }

    public int kthSmallest(int k) {
        HeapMover st = new HeapMover();
        kthSmallest(k, st, root);
        st.a.sort(null);
        return st.a.get(k - 1);
    }

    private void kthSmallest(int k, HeapMover st, Node node) {

        st.a.add(node.data);
        for (Node child : node.children) {
            kthSmallest(k, st, child);
        }
    }

    public void removeLeaves() {
        removeLeaves(root);
    }

    private void removeLeaves(Node node) {

        for (int i = 0; i < node.children.size(); i++) {
            if (node.children.get(i).children.size() == 0) {
                node.children.remove(i);
                i--;
            }
        }

        for (Node val : node.children) {
            removeLeaves(val);
        }

    }

    public void linearize() {
        linearize(root);
    }

    private void linearize(Node node) {

        for (Node val : node.children) {
            linearize(val);
        }

        if (node.children.size() >= 2) {
            for (int i = node.children.size() - 1; i >= 1; i--) {
                Node a = node.children.remove(i);

                Node temp = node;
                temp = temp.children.get(i - 1);
                while (temp.children.size() != 0) {
                    temp = temp.children.get(0);
                }
                temp.children.add(a);
            }
        }
    }
}
