import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B959 {
    static class unionFind {
        int[] parent;
        int[] rank;
        int numSets;
        int[] size;
        int[] min;

        public unionFind(int n, int[] arr) {
            this.parent = new int[n];
            this.rank = new int[n];
            this.numSets = n;
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            size = new int[n];
            Arrays.fill(size, 1);
            min = new int[n];
            for (int i = 0; i < arr.length; i++) {
                min[i] = arr[i];
            }

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
                min[x] = Math.min(min[x], min[y]);
                size[findSet(x)] += size[findSet(y)];
                parent[y] = x;
            } else {
                min[y] = Math.min(min[x], min[y]);
                size[findSet(y)] += size[findSet(x)];
                parent[x] = y;
                if (rank[x] == rank[y]) rank[y]++;
            }
        }

        public int getNumSets() {
            return numSets;
        }

        public int getMinCost(int i) {
            return min[findSet(i)];
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int k = fr.nextInt();
        int m = fr.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(fr.next(), i);
        }
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = fr.nextInt();
        }
        unionFind uf = new unionFind(n, min);
        for (int i = 0; i < k; i++) {
            int num = fr.nextInt();
            int[] temp = new int[num];
            for (int j = 0; j < num; j++) {
                temp[j] = fr.nextInt() - 1;
            }
            for (int j = 0; j < num - 1; j++) {
                uf.unionSet(temp[j], temp[j + 1]);
            }
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            ans += uf.getMinCost(map.get(fr.next()));
        }
        System.out.println(ans);
    }
}
