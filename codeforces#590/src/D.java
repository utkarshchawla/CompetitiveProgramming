import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.io.*;
import java.math.BigInteger;
import java.util.BitSet;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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
        private class Node {
            BitSet data;
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
                base.data = new BitSet();
                base.data.set(arr[si]);
                return base;
            }
            int mid = (si + ei) / 2;
            Node node = new Node();
            node.si = si;
            node.ei = ei;
            node.left = construct(arr, si, mid);
            node.right = construct(arr, mid + 1, ei);
            node.data = (BitSet) node.left.data.clone();
            node.data.or(node.right.data);
            return node;
        }

        public BitSet query(int qsi, int qei) {
            return query(root, qsi, qei);
        }

        private BitSet query(Node node, int qsi, int qei) {
            if (node.si >= qsi && node.ei <= qei) {
                return node.data;
            } else if (node.si > qei || node.ei < qsi) {
                return new BitSet();
            } else {
                BitSet l = (BitSet) query(node.left, qsi, qei).clone();
                BitSet r = (BitSet) query(node.right, qsi, qei).clone();
                l.or(r);
                return l;
            }
        }


        public void update(int idx, int data) {
            update(root, idx, data);
        }

        private void update(Node node, int idx, int data) {
            int mid = (node.si + node.ei) / 2;
            if (node.left == null && node.right == null && node.ei == idx) {
                node.data = new BitSet();
                node.data.set(data);
                return;
            }
            if (node.left != null && idx <= mid) {
                update(node.left, idx, data);
            }
            if (node.right != null && idx > mid) {
                update(node.right, idx, data);
            }
            if (node.right != null && node.left != null) {
                node.data = (BitSet) node.left.data.clone();
                node.data.or(node.right.data);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        String s = fr.nextLine();
        int[] arr = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - 'a';
        }
        SegmentTree st = new SegmentTree(arr);
        int q = fr.nextInt();
        while (q-- > 0) {
            String str = fr.nextLine();
            String[] sar = str.split(" ");
            String type = sar[0];
            if (type.equals("1")) {
                int idx = Integer.parseInt(sar[1]) - 1;
                char c = sar[2].charAt(0);
                st.update(idx, c - 'a');
            } else {
                int l = Integer.parseInt(sar[1]) - 1;
                int r = Integer.parseInt(sar[2]) - 1;
                fw.println(st.query(l, r).cardinality());
            }
        }

        fw.close();
    }
}
