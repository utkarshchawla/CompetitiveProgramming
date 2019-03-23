import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C437 {
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

    static class pair implements Comparable<pair> {
        int val;
        int idx;

        pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(pair o) {
            return o.val - this.val;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        pair[] arr = new pair[n];
        HashMap<Integer, Integer> price = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = fr.nextInt();
            arr[i] = new pair(val, i);
            price.put(i, val);
        }
        Arrays.sort(arr);
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = fr.nextInt() - 1;
            int v = fr.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }
        HashSet<Integer> rem = new HashSet<>();
        long ans = 0;
        for (pair p : arr) {
            rem.add(p.idx);
            for (int i : g[p.idx]) {
                if (!rem.contains(i)) ans += price.get(i);
            }
        }
        System.out.println(ans);

    }
}
