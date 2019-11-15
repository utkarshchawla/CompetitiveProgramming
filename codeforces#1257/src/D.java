import java.io.*;
import java.math.BigInteger;
import java.util.*;

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
            int data;
            int si;
            int ei;
            Node left;
            Node right;
        }

        private Node root;
        private int size;


        public SegmentTree(int[] arr) {
            root = construct(arr, 0, arr.length - 1);
        }

        private Node construct(int[] arr, int si, int ei) {

            if (si == ei) {
                Node base = new Node();
                this.size++;
                base.si = base.ei = si;
                base.data = arr[si];
                return base;
            }

            int mid = (si + ei) / 2;
            Node node = new Node();
            this.size++;
            node.si = si;
            node.ei = ei;

            node.left = construct(arr, si, mid);
            node.right = construct(arr, mid + 1, ei);

            node.data = Math.max(node.left.data, node.right.data);

            return node;

        }


        public int query(int qsi, int qei) {
            return query(root, qsi, qei);
        }

        private int query(Node node, int qsi, int qei) {

            if (node.si >= qsi && node.ei <= qei) {
                return node.data;
            } else if (node.si > qei || node.ei < qsi) {
                return Integer.MIN_VALUE;
            } else {

                int l = query(node.left, qsi, qei);
                int r = query(node.right, qsi, qei);

                return Math.max(l, r);
            }

        }

    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        o:
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = fr.nextInt();
            SegmentTree st = new SegmentTree(a);
            int m = fr.nextInt();
            ArrayList<pair> hero = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                pair np = new pair(fr.nextInt(), fr.nextInt());
                hero.add(np);
            }

            hero.sort(null);
            int[] suffmax = new int[hero.size()];
            suffmax[suffmax.length - 1] = hero.get(suffmax.length - 1).s;
            for (int i = suffmax.length - 2; i >= 0; i--) {
                suffmax[i] = Math.max(suffmax[i + 1], hero.get(i).s);
            }
            int idx = 0;
            int days = 0;
            while (idx < n) {
                int ni = -1;
                int lo = idx;
                int hi = n - 1;
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if (helper(st.query(idx, mid), hero, mid - idx + 1, suffmax)) {
                        lo = mid + 1;
                        ni = Math.max(ni, mid);
                    } else hi = mid - 1;
                }
                if (ni == -1) {
                    System.out.println(-1);
                    continue o;
                }
                idx = ni + 1;
                days++;
            }
            System.out.println(days);
        }
    }

    public static boolean helper(int tarP, ArrayList<pair> hero, int tarS, int[] suffmax) {

        int i1 = Collections.binarySearch(hero, new pair(tarP, tarS));
        if (i1 >= 0) return true;
        i1 = -(i1 + 1);
        if (i1 < suffmax.length && suffmax[i1] >= tarS) return true;
        return false;
    }


    public static class pair implements Comparable<pair> {
        int p;
        int s;

        pair(int p, int s) {
            this.p = p;
            this.s = s;
        }

        @Override
        public int compareTo(pair obj) {
            if (this.p == obj.p) return this.s - obj.s;
            return this.p - obj.p;
        }
    }
}
