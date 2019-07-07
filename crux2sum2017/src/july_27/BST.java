package july_27;

import java.util.ArrayList;
import java.util.LinkedList;

public class BST {

    private class Node {
        int data;
        Node left;
        Node right;
    }

    int size;
    Node root;

    public BST(int[] post, int[] in) {
        root = construct(post, in, 0, post.length - 1, 0, in.length - 1);
    }

    public BST(int[] sa) {
        root = construct(sa, 0, sa.length - 1);
    }

    private Node construct(int[] sa, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        Node node = new Node();
        size++;

        int mid = (lo + hi) / 2;
        int data = sa[mid];
        node.data = data;

        node.left = construct(sa, lo, mid - 1);
        node.right = construct(sa, mid + 1, hi);

        return node;

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

        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public int min() {
        return min(root);
    }

    private int min(Node node) {
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    public boolean find(int data) {
        return find(root, data);
    }

    private boolean find(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (data > node.data) {
            return find(node.right, data);
        } else if (data < node.data) {
            return find(node.left, data);
        } else {
            return true;
        }

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

        // int a = this.height(node.left);
        // int b = this.height(node.right);
        // int f1 = a + b + 2;
        // int f2 = diameter(node.left);
        // int f3 = diameter(node.right);

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
        if (b.isBal != false) {
            if (Math.abs(ln.height - rn.height) >= 1) {
                b.isBal = false;
            }
            b.isBal = true;
        }

        b.height = Math.max(ln.height, rn.height) + 1;
        return b;

    }

    private class bstPair {
        boolean isBst;
        int max;
        int min;
    }

    public boolean isBST() {
        return isBST(root).isBst;
    }

    private bstPair isBST(Node node) {

        if (node == null) {
            bstPair rp = new bstPair();
            rp.isBst = true;
            rp.max = Integer.MIN_VALUE;
            rp.min = Integer.MAX_VALUE;
            return rp;
        }

        bstPair lp = isBST(node.left);
        bstPair rp = isBST(node.right);

        bstPair mp = new bstPair();
        if (lp.isBst == true && rp.isBst == true && node.data > lp.max && node.data < rp.min)
            mp.isBst = true;

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
            if (top.selfdone == false) {
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

    public void add(int data) {
        if (this.size == 0) {
            Node node = new Node();
            node.data = data;
            this.root = node;
            this.size++;
        } else {
            add(root, data);
        }
    }

    private void add(Node node, int data) {

        if (data > node.data) {
            if (node.right != null) {
                add(node.right, data);
            } else {
                node.right = new Node();
                node.right.data = data;
                this.size++;
            }
        } else if (data < node.data) {
            if (node.left != null) {
                add(node.left, data);
            } else {
                node.left = new Node();
                node.left.data = data;
                this.size++;
            }
        }
    }

    // public void remove(int data) {
    // remove(data, root, null, false);
    // }
    //
    // private void remove(int data, Node node, Node parent, boolean ilc) {
    // if (data == root.data) {
    // Node t = root;
    // root = null;
    // size = 0;
    // addall(t);
    // return;
    // }
    //
    // if (data > node.data) {
    // remove(data, node.right, node, false);
    // } else if (data < node.data) {
    // remove(data, node.left, node, true);
    // } else {
    // if (ilc) {
    // if (node.left == null && node.right == null) {
    // parent.left = null;
    // size--;
    // } else {
    // Node temp = node;
    // parent.left = null;
    // size--;
    // addall(temp);
    //
    // }
    // } else {
    // if (node.left == null && node.right == null) {
    // parent.right = null;
    // size--;
    // } else {
    // Node temp = node;
    // parent.right = null;
    // size--;
    // addall(temp);
    // }
    // }
    // }
    // }
    //
    // private void addall(Node node) {
    //
    // if (node.left != null) {
    // add(node.left.data);
    // addall(node.left);
    // }
    //
    // if (node.right != null) {
    // add(node.right.data);
    // addall(node.right);
    // }
    // }


    public void remove(int data) {
        remove(data, root, null, false);
    }

    private void remove(int data, Node node, Node parent, boolean ilc) {
        if (node == null) {
            return;
        }

        if (data > node.data) {
            remove(data, node.right, node, false);
        } else if (data < node.data) {
            remove(data, node.left, node, true);
        } else {
            if (node.left == null && node.right == null) {
                if (ilc) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                size--;
            } else if (node.left == null) {
                if (ilc) {
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
                size--;
            } else if (node.right == null) {
                if (ilc) {
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }
                size--;

            } else {
                int min = min(node.right);
                node.data = min;
                remove(min, node.right, node, false);
            }
        }
    }

    private class HeapMover {
        int sum;
    }

    public void replaceWithSum() {
        HeapMover hp = new HeapMover();
        replaceWithSum(root, hp);
    }

    private void replaceWithSum(Node node, HeapMover hp) {
        if (node == null) {
            return;
        }
        replaceWithSum(node.right, hp);

        int temp = node.data;
        node.data = hp.sum;
        hp.sum = hp.sum + temp;

        replaceWithSum(node.left, hp);
    }

    public void pir(int lo, int hi) {
        pir(lo, hi, root);
    }

    private void pir(int lo, int hi, Node node) {
        if (node == null) {
            return;
        }
        if (node.data > hi) {
            pir(lo, hi, node.left);
        } else if (node.data < lo) {
            pir(lo, hi, node.right);
        } else {
            System.out.print(node.data + ", ");
            pir(lo, hi, node.left);
            pir(lo, hi, node.right);
        }

    }

    public void assques2() {
        assques2(root);
    }

    private void assques2(Node node) {
        if (node == null) {
            return;
        }

        assques2(node.left);
        assques2(node.right);

        if (node.left == null) {
            Node du = new Node();
            du.data = node.data;
            node.left = du;
        } else {
            Node du = new Node();
            du.data = node.data;
            Node temp = node.left;
            node.left = du;
            du.left = temp;
        }
    }

    public void assques3(int data) {
        assques3(root, data);
    }

    private void assques3(Node node, int data) {
        if (node == null) {
            return;
        }

        assques3(node.left, data);
        assques3(node.right, data);

        Node t = findNode(root, data - node.data);
        if (t != null) {
            System.out.println(node.data + " + " + t.data);
        }

    }

    private Node findNode(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data > node.data) {
            return findNode(node.right, data);
        } else if (data < node.data) {
            return findNode(node.left, data);
        } else {
            return node;
        }

    }

    public void assques3b(int data) {
        ArrayList<Integer> list = new ArrayList<>();
        assques3b(list, root);
        getsum(list, data, 0);
    }

    private void assques3b(ArrayList<Integer> list, Node node) {
        if (node == null) {
            return;
        }
        assques3b(list, node.left);
        list.add(node.data);
        assques3b(list, node.right);

    }

    private void getsum(ArrayList<Integer> list, int data, int vidx) {
        if (vidx == list.size()) {
            return;
        }
        int co = data - list.get(vidx);

        int left = vidx;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (co > list.get(mid)) {
                left = mid + 1;
            } else if (co < list.get(mid)) {
                right = mid - 1;
            } else {
                System.out.println(list.get(vidx) + " + " + co);
                break;
            }
        }

        getsum(list, data, vidx + 1);

    }

    public void assques9(int target) {
        assques9(root, "", target);
    }

    private void assques9(Node node, String ans, int target) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            if (target == node.data) {
                System.out.println(ans + "->"+ node.data);
            }
            return;
        }

        if (node.left != null) {
            assques9(node.left, ans + "->" + node.data, target - node.data);
        }

        if (node.right != null) {
            assques9(node.right, ans + "->" + node.data, target - node.data);
        }

    }


}
