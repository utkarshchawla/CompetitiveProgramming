import java.util.*;

public class A {
    public static int mod = 1000000009;

    public static class SegmentTree {
        private class Node {
            int data;
            int zeros;
            int si;
            int ei;
            Node left;
            Node right;
        }

        private Node root;

        public SegmentTree(int[] arr) {
            root = construct(arr, 0, arr.length - 1);
        }

        private Node construct(int[] arr, int si, int ei) {
            if (si == ei) {
                Node base = new Node();
                base.si = base.ei = si;
                base.data = arr[si];
                return base;
            }
            int mid = (si + ei) / 2;
            Node node = new Node();
            node.si = si;
            node.ei = ei;
            node.left = construct(arr, si, mid);
            node.right = construct(arr, mid + 1, ei);
            node.data = (node.left.data % mod + node.right.data % mod) % mod;
            return node;
        }

        public int query1(int qsi, int qei) {
            return query1(root, qsi, qei);
        }

        private int query1(Node node, int qsi, int qei) {
            if (node.si >= qsi && node.ei <= qei) {
                return node.data;
            } else if (node.si > qei || node.ei < qsi) {
                return 0;
            } else {
                int l = query1(node.left, qsi, qei);
                int r = query1(node.right, qsi, qei);
                return (l % mod + r % mod) % mod;
            }
        }

        public int query2(int qsi, int qei) {
            return query2(root, qsi, qei);
        }

        private int query2(Node node, int qsi, int qei) {
            if (node.si >= qsi && node.ei <= qei) {
                return node.zeros;
            } else if (node.si > qei || node.ei < qsi) {
                return 0;
            } else {
                int l = query2(node.left, qsi, qei);
                int r = query2(node.right, qsi, qei);
                return (l % mod + r % mod) % mod;
            }
        }

        public void update(int idx, int data) {
            update(root, idx, data);
        }

        private void update(Node node, int idx, int data) {
            int mid = (node.si + node.ei) / 2;
            if (node.left == null && node.right == null && node.ei == idx) {
                node.data = data;
                node.zeros = 1;
                return;
            }
            if (node.left != null && idx <= mid) {
                update(node.left, idx, data);
            }
            if (node.right != null && idx > mid) {
                update(node.right, idx, data);
            }
            if (node.right != null && node.left != null) {
                node.data = (node.left.data % mod + node.right.data % mod) % mod;
                node.zeros = node.left.zeros + node.right.zeros;
            }
        }
    }

    public static class pair implements Comparable<pair> {
        int x;
        int b;

        public int compareTo(pair o) {
            return this.b - o.b;
        }

    }

    public static void main(String args[]) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            int n = scn.nextInt();
            pair[] arr = new pair[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new pair();
                arr[i].x = scn.nextInt();
                b[i] = arr[i].x;
            }

            for (int i = 0; i < n; i++) {
                arr[i].b = scn.nextInt();
            }

            Arrays.sort(b);
            Arrays.sort(arr);
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(b[i], i);
            }

            long sum = 0;

            SegmentTree st = new SegmentTree(b);
            for (int i = arr.length - 1; i >= 0; i--) {
                int val = arr[i].x;
                int idx = map.get(arr[i].x);
                long a = ((val % mod) * ((idx - st.query2(0, idx - 1)) % mod)) % mod;
                a -= st.query1(0, idx - 1);
                a = (a * (arr[i].b % mod)) % mod;
                long bo = st.query1(idx + 1, b.length - 1);
                bo -= ((val % mod) * ((b.length - idx - 1 - st.query2(idx + 1, b.length - 1)) % mod)) % mod;
                bo = (bo * (arr[i].b % mod)) % mod;
                sum = (sum % mod + a % mod) % mod;
                sum = (sum % mod + bo % mod) % mod;
                st.update(idx, 0);

            }
            System.out.println(sum);
        }


    }
}