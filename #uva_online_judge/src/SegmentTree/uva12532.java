package SegmentTree;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva12532 {
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        BigInteger nextBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }
    }

    public static class SegmentTree {

        static class Pair {
            int data;
            int idx;

            Pair(int data, int idx) {
                this.data = data;
                this.idx = idx;
            }
        }

        public class Node {
            int data;
            int si;
            int ei;
            int idx;
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
                base.idx = si;
                return base;
            }

            int mid = (si + ei) / 2;
            Node node = new Node();
            node.si = si;
            node.ei = ei;

            node.left = construct(arr, si, mid);
            node.right = construct(arr, mid + 1, ei);
            node.data = node.left.data * node.right.data;
            node.idx = (node.left.data > node.right.data) ? node.left.idx : node.right.idx;
            return node;

        }

        public Pair query(int qsi, int qei) {
            Node n = query(root, qsi, qei);
            return new Pair(n.data, n.idx);
        }

        private Node query(Node node, int qsi, int qei) {
            if (node.si >= qsi && node.ei <= qei) {
                return node;
            } else if (node.si > qei || node.ei < qsi) {
                Node bn = new Node();
                bn.data = 1;
                bn.idx = -1;
                return bn;
            } else {
                Node l = query(node.left, qsi, qei);
                Node r = query(node.right, qsi, qei);
                Node mn = new Node();
                mn.data = l.data * r.data;
                mn.idx = (l.data > r.data) ? l.idx : r.idx;
                return mn;
            }

        }

        public void update(int idx, int data) {
            update(root, idx, data);
        }

        private void update(Node node, int idx, int data) {
            int mid = (node.si + node.ei) / 2;

            if (node.left == null && node.right == null && node.ei == idx) {
                node.data = data;
                node.idx = idx;
                return;
            }

            if (node.left != null && idx <= mid) {
                update(node.left, idx, data);
            }
            if (node.right != null && idx > mid) {
                update(node.right, idx, data);
            }

            if (node.left != null && node.right != null) {
                node.data = node.left.data * node.right.data;
                node.idx = (node.left.data > node.right.data) ? node.left.idx : node.right.idx;
            }

        }

    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        while (fr.br.ready()) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                int val = fr.nextInt();
                arr[i] = Integer.compare(val, 0);
            }

            SegmentTree tree = new SegmentTree(arr);
            StringBuilder ans = new StringBuilder();
            while (k-- > 0) {
                String str = fr.nextLine();
                StringTokenizer st = new StringTokenizer(str);
                String com = st.nextToken();
                if (com.equals("C")) {
                    int idx = Integer.parseInt(st.nextToken()) - 1;
                    int val;
                    int temp = Integer.parseInt(st.nextToken());
                    val = Integer.compare(temp, 0);
                    tree.update(idx, val);
                } else {
                    int si = Integer.parseInt(st.nextToken()) - 1;
                    int ei = Integer.parseInt(st.nextToken()) - 1;
                    int val = tree.query(si, ei).data;
                    if (val > 0) ans.append("+");
                    else if (val < 0) ans.append("-");
                    else ans.append(0);
                }
            }
            System.out.println(ans);
        }
    }
}
