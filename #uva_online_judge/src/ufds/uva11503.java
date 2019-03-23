package ufds;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva11503 {
    static class unionFind {
        int[] parent;
        int[] rank;
        int numSets;
        int[] size;

        public unionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.numSets = n;
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
        }

        public int findSet(int i) {
            return (parent[i] == i) ? i : (parent[i] = findSet(parent[i]));

        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public int sizeOfSet(int i) {
            return size[findSet(i)];
        }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j)) return;
            numSets--;
            int x = findSet(i);
            int y = findSet(j);
            if (rank[x] > rank[y]) {
                size[findSet(x)] += size[findSet(y)];
                parent[y] = x;
            } else {
                size[findSet(y)] += size[findSet(x)];

                parent[x] = y;
                if (rank[x] == rank[y]) rank[y]++;
            }
        }

        public int getNumSets() {
            return numSets;
        }
    }

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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            unionFind uf = new unionFind(2 * n);
            HashMap<String, Integer> map = new HashMap<>();
            int cnt = 0;
            while (n-- > 0) {
                String s = fr.nextLine();
                StringTokenizer st = new StringTokenizer(s);
                String a = st.nextToken();
                String b = st.nextToken();
                if (!map.containsKey(a)) {
                    map.put(a, cnt);
                    cnt++;
                }

                if (!map.containsKey(b)) {
                    map.put(b, cnt);
                    cnt++;
                }

                uf.unionSet(map.get(a), map.get(b));
                fw.println(uf.sizeOfSet(map.get(a)));

            }
        }
        fw.close();
    }
}
