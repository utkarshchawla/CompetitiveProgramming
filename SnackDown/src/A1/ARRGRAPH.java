package A1;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class ARRGRAPH {
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

    public static class UFDS {
        private int[] parent;
        private int[] rank;
        private int[] size;
        private int numSets;

        public UFDS(int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.size = new int[n];
            this.numSets = n;
            for (int i = 0; i < parent.length; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        private int findSet(int i) {
            return (parent[i] == i) ? i : (parent[i] = findSet(parent[i]));

        }

        private boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j)) return;
            numSets--;
            int x = findSet(i);
            int y = findSet(j);
            if (rank[x] > rank[y]) {
                parent[y] = x;
                size[x] += size[y];
            } else {
                parent[x] = y;
                size[y] += size[x];
                if (rank[x] == rank[y]) rank[y]++;
            }
        }

        public int getNumSets() {
            return numSets;
        }

        public int getSize(int i) {
            return size[findSet(i)];
        }

    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
            UFDS set = new UFDS(n);
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (gcd(arr[i], arr[j]) == 1) set.unionSet(i, j);
                }
            }
            if (set.numSets == 1) {
                fw.println("0");
                for (int i : arr) fw.print(i + " ");
                fw.println("");
            } else {
                fw.println("1");
                if (arr[0] != 47) arr[0] = 47;
                else arr[0] = 46;
                for (int i : arr) fw.print(i + " ");
                fw.println("");
            }

        }
        fw.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
