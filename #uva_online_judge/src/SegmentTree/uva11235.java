package SegmentTree;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva11235 {
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
        int[] arr;

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
            node.data = Math.max(node.left.data, node.right.data);
            node.idx = (node.left.data > node.right.data) ? node.left.idx : node.right.idx;
            return node;

        }

        public int query(int qsi, int qei) {
            int a = qsi + 1;
            while (a <= qei && arr[a] == arr[qsi]) a++;
            int b = qei - 1;
            while (b >= qsi && arr[b] == arr[qei]) b--;
            int q1 = a - qsi;
            int q2 = qei - b;
            int q3 = Integer.MIN_VALUE;
            if (b >= a)
                q3 = query(root, a, b).data;

            return Math.max(q1, Math.max(q2, q3));
        }

        private Node query(Node node, int qsi, int qei) {
            if (node.si >= qsi && node.ei <= qei) {
                return node;
            } else if (node.si > qei || node.ei < qsi) {
                Node bn = new Node();
                bn.data = Integer.MIN_VALUE;
                bn.idx = -1;
                return bn;
            } else {
                Node l = query(node.left, qsi, qei);
                Node r = query(node.right, qsi, qei);
                Node mn = new Node();
                mn.data = Math.max(l.data, r.data);
                mn.idx = (l.data > r.data) ? l.idx : r.idx;
                return mn;
            }

        }

    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        while (true) {
            int n = fr.nextInt();
            if (n == 0) break;
            int q = fr.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                arr[i] = fr.nextInt();
                if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
                else map.put(arr[i], 1);
            }

            int freq[] = new int[n];
            for (int i = 0; i < arr.length; i++) freq[i] = map.get(arr[i]);
            SegmentTree st = new SegmentTree(freq);
            st.arr = arr;
            while (q-- > 0) {
                System.out.println(st.query(fr.nextInt() - 1, fr.nextInt() - 1));
            }

        }
    }
}
