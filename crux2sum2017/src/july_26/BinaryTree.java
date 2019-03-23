package july_26;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {

    private class Node {
        int data;
        Node left;
        Node right;
    }

    int size;
    Node root;

    public BinaryTree() {
        Scanner scn = new Scanner(System.in);
        System.out.println("input");
        this.root = takeInput(null, false, scn);
    }

    public BinaryTree(int[] post, int[] in) {
        root = construct(post, in, 0, post.length - 1, 0, in.length - 1);
    }

    private Node construct(int[] post, int[] in, int psi, int pei, int isi, int iei) {
        if (psi > pei || isi > iei) {
            return null;
        }
        Node node = new Node();
        this.size++;
        node.data = post[pei];

        int idx = -1;
        for (int i = isi; i <= iei; i++) {
            if (in[i] == node.data) {
                idx = i;
                break;
            }
        }

        int ncl = idx - isi;

        node.left = construct(post, in, psi, psi + ncl - 1, isi, idx - 1);
        node.right = construct(post, in, psi + ncl, pei - 1, idx + 1, iei);

        return node;
    }

    public Node takeInput(Node parent, boolean ilc, Scanner scn) {

        int data = scn.nextInt();
        Node node = new Node();
        node.data = data;
        this.size++;

        boolean hln = scn.nextBoolean();
        if (hln) {
            node.left = takeInput(node, true, scn);
        }

        boolean hrn = scn.nextBoolean();
        if (hrn) {
            node.right = takeInput(node, false, scn);
        }

        return node;
    }

    public void display() {
        display(root);
    }

    private void display(Node node) {
        if (node == null) {
            return;
        }
        String s = "";
        if (node.left != null) {
            s += node.left.data;
        } else {
            s += " .";
        }

        s += " <= ";
        s += node.data;
        s += " => ";

        if (node.right != null) {
            s += node.right.data;
        } else {
            s += ". ";
        }

        System.out.println(s);
        display(node.left);
        display(node.right);

    }

    public int size2() {
        return size2(root);
    }

    private int size2(Node node) {
        if (node == null) {
            return 0;
        }

        int a = size2(node.left);
        int b = size2(node.right);

        return a + b + 1;
    }

    public int max() {
        return max(root);
    }

    private int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int a = max(node.left);
        int b = max(node.right);

        return Math.max(node.data, Math.max(a, b));
    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

//		if (node.data == data) {
//			return true;
//		}
//
//		if (find(node.left, data)) {
//			return true;
//		}
//
//		if (find(node.right, data)) {
//			return true;
//		}
//
//		return false;
        return (node.data == data) && find(node.left, data) && find(node.right, data);

    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }

        int a = height(node.left);
        int b = height(node.right);

        return Math.max(a, b) + 1;
    }

    public int diameter() {
        return diameter(root).dia;
    }

    private diaPair diameter(Node node) {
        if (node == null) {
            diaPair bp = new diaPair();
            bp.height = -1;
            bp.dia = 0;
            return bp;
        }

        diaPair lp = diameter(node.left);
        diaPair rp = diameter(node.right);

        int f1 = lp.height + rp.height + 2;
        int f2 = lp.dia;
        int f3 = rp.dia;

        diaPair rep = new diaPair();
        rep.height = Math.max(lp.height, rp.height) + 1;
        rep.dia = Math.max(Math.max(f1, f2), f3);
        return rep;

    }

    private class diaPair {
        int height;
        int dia;
    }

    private class bPair {
        int height;
        boolean isBal;
    }

    public boolean isBalanced() {
        return isBalanced(root).isBal;
    }

    private bPair isBalanced(Node node) {
        if (node == null) {
            bPair rp = new bPair();
            rp.height = -1;
            rp.isBal = true;
            return rp;
        }

        bPair ln = isBalanced(node.left);
        bPair rn = isBalanced(node.right);

        bPair b = new bPair();
        if (b.isBal) {
            if (Math.abs(ln.height - rn.height) >= 1) {
                b.isBal = false;
            }
        }

        b.height = Math.max(ln.height, rn.height) + 1;
        return b;

    }

    private class bstPair {
        boolean isBst;
        int max;
        int min;
        Node largest;
        int largestsize;
    }

    public void isBST() {
        System.out.println(isBST(root).isBst);
        System.out.println(isBST(root).largestsize);
        System.out.println(isBST(root).largest.data);
    }

    private bstPair isBST(Node node) {
        if (node == null) {
            bstPair rp = new bstPair();
            rp.isBst = true;
            rp.max = Integer.MIN_VALUE;
            rp.min = Integer.MAX_VALUE;
            rp.largestsize = 0;
            rp.largest = null;
            return rp;
        }

        bstPair lp = isBST(node.left);
        bstPair rp = isBST(node.right);

        bstPair mp = new bstPair();
        if (lp.isBst && rp.isBst && node.data > lp.max && node.data < rp.min) {
            mp.isBst = true;
            mp.largestsize = lp.largestsize + rp.largestsize + 1;
            mp.largest = node;
        } else {
            mp.isBst = false;
            mp.largestsize = Integer.max(lp.largestsize, rp.largestsize);
            if (lp.largestsize > rp.largestsize) {
                mp.largest = lp.largest;
            } else {
                mp.largest = rp.largest;
            }
        }

        mp.max = Math.max(Math.max(lp.max, rp.max), node.data);
        mp.min = Math.min(Math.min(lp.min, rp.min), node.data);

        return mp;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.data + ", ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.data + ", ");
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        preOrder(node.left);
        System.out.print(node.data + ", ");
        preOrder(node.right);
    }

    public void levelOrder() {

        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);

        while (q.size() != 0) {
            Node temp = q.removeFirst();
            System.out.print(temp.data + ", ");

            if (temp.left != null) {
                q.addLast(temp.left);
            }

            if (temp.right != null) {
                q.addLast(temp.right);
            }
        }

        System.out.println(".");

    }

    public class TraversalPair {
        Node node;
        boolean selfdone;
        boolean leftdone;
        boolean rightdone;
    }

    public void preOrderIter() {

        LinkedList<TraversalPair> stack = new LinkedList<>();
        TraversalPair rootp = new TraversalPair();
        rootp.node = root;
        stack.addFirst(rootp);

        while (stack.size() != 0) {
            TraversalPair top = stack.getFirst();
            if (!top.selfdone) {
                System.out.print(top.node.data + ", ");
                top.selfdone = true;
            } else if (top.leftdone == false) {
                if (top.node.left != null) {
                    TraversalPair lp = new TraversalPair();
                    lp.node = top.node.left;
                    stack.addFirst(lp);
                }
                top.leftdone = true;
            } else if (top.rightdone == false) {
                if (top.node.right != null) {
                    TraversalPair rp = new TraversalPair();
                    rp.node = top.node.right;
                    stack.addFirst(rp);
                }
                top.rightdone = true;
            } else {
                stack.removeFirst();
            }
        }
        System.out.println();
    }

    public void postOrderIter() {

        LinkedList<TraversalPair> stack = new LinkedList<>();
        TraversalPair rootp = new TraversalPair();
        rootp.node = root;
        stack.addFirst(rootp);

        while (stack.size() != 0) {
            TraversalPair top = stack.getFirst();
            if (top.leftdone == false) {
                if (top.node.left != null) {
                    TraversalPair lp = new TraversalPair();
                    lp.node = top.node.left;
                    stack.addFirst(lp);
                }
                top.leftdone = true;

            } else if (top.rightdone == false) {
                if (top.node.right != null) {
                    TraversalPair rp = new TraversalPair();
                    rp.node = top.node.right;
                    stack.addFirst(rp);
                }
                top.rightdone = true;

            } else if (top.selfdone == false) {
                System.out.print(top.node.data + ", ");
                top.selfdone = true;
            } else {
                stack.removeFirst();
            }
        }
        System.out.println();
    }

    public void inOrderIter() {
        LinkedList<TraversalPair> stack = new LinkedList<>();
        TraversalPair rootp = new TraversalPair();
        rootp.node = root;
        stack.addFirst(rootp);

        while (stack.size() != 0) {
            TraversalPair top = stack.getFirst();
            if (top.leftdone == false) {
                if (top.node.left != null) {
                    TraversalPair lp = new TraversalPair();
                    lp.node = top.node.left;
                    stack.addFirst(lp);
                }
                top.leftdone = true;

            } else if (top.selfdone == false) {
                System.out.print(top.node.data + ", ");
                top.selfdone = true;

            } else if (top.rightdone == false) {
                if (top.node.right != null) {
                    TraversalPair rp = new TraversalPair();
                    rp.node = top.node.right;
                    stack.addFirst(rp);
                }
                top.rightdone = true;

            } else {
                stack.removeFirst();
            }
        }
        System.out.println();
    }

    public void printsib() {
        printsib(root, root);
    }

    private void printsib(Node node, Node parent) {
        if (node == null) {
            return;
        }

        printsib(node.left, node);
        printsib(node.right, node);

        if (parent.left == null && parent.right != null && parent.right.right == null && parent.right.left == null) {
            System.out.println(parent.right.data);
        }
        if (parent.right == null && parent.left != null && parent.left.right == null && parent.left.left == null) {
            System.out.println(parent.left.data);
        }
    }

    public void removeleaves() {
        removeleaves(root, null, false);
    }

    private void removeleaves(Node node, Node parent, boolean ilc) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            if (ilc) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        }
        removeleaves(node.right, node, false);
        removeleaves(node.left, node, true);
    }

    private Node findNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            return node;
        }
        Node l = findNode(node.left, data);
        Node r = findNode(node.right, data);

        if (l != null) {
            return l;
        }

        if (r != null) {
            return r;
        }
        return null;

    }

    private Node findParent(Node node, Node parent, int data) {
        if (node == null) {
            return null;
        }
        if (node.data == data) {
            return parent;
        }
        Node l = findParent(node.left, node, data);
        Node r = findParent(node.right, node, data);

        if (l != null) {
            return l;
        }

        if (r != null) {
            return r;
        }

        return null;

    }

    public int LCA(int a, int b) {
        return this.LCA(a, b, this.root).data;
    }

    private Node LCA(int a, int b, Node node) {
        if (node == null) {
            return null;
        }
        if (a == node.data || b == node.data) {
            return node;
        }
        Node lc = LCA(a, b, node.left);
        Node rc = LCA(a, b, node.right);

        if (lc != null && rc != null) {
            return node;
        } else if (lc != null) {
            return lc;
        } else {
            return rc;
        }
    }

    private void getNodes(Node node, int k) {
        if (node == null) {
            return;
        }

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        // Node parent = findParent(root, null, node.data);
        getNodes(node.right, k - 1);
        getNodes(node.left, k - 1);

    }

//    public void kaway(int k, int data) {
//        Node node = findNode(root, data);
//        Node parent = findParent(root, null, data);
//
//        this.kaway(node, parent, false, k);
//
//    }

//    private void kaway(Node node, Node parent, boolean b, int k) {
//        if (node == null) {
//            return;
//        }
//        if (k == 0) {
//            System.out.println(node.data);
//        }
//        if (b) {
//            kaway(node.left, node, true, k - 1);
//            kaway(node.right, node, true, k - 1);
//        } else {
//            kaway(node.left, node, true, k - 1);
//            kaway(node.right, node, true, k - 1);
//            kaway(parent, findParent(root, null, parent.data), false, k - 1);
//        }
//
//    }

    public void kaway(int data, int k) {
        HeapMover mover = new HeapMover();
        mover.k = k;
        kaway(root,false, data,mover);
    }

    private class HeapMover {
        boolean found;
        boolean isright;
        int k;
    }

    private void kaway(Node root, Boolean isleft, int data, HeapMover mover) {
        if (root.data == data) {
            mover.found = true;
            return;
        }

        if (!mover.found) kaway(root.left, true, data, mover);
        if (!mover.found) kaway(root.right, false, data, mover);
        if(root.data == data) getNodes(root, mover.k);
        else {
            if(mover.isright)getNodes(root.right,mover.k - 1);
            else getNodes(root.left,mover.k - 1);
        }
        if (isleft) mover.isright = true;
        else mover.isright  = false;
        mover.k -= 1;
    }


}