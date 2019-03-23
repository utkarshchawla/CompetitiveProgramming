import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class A166 {
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
        int solve;
        int time;

        pair(int solve, int time) {
            this.solve = solve;
            this.time = time;
        }

        @Override
        public int hashCode() {
            return solve * 31 + time;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            pair p = (pair) obj;
            return p.time == this.time && p.solve == this.solve;
        }

        @Override
        public int compareTo(pair o) {
            if (o.solve == this.solve) {
                return this.time - o.time;
            }
            return o.solve - this.solve;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int k = fr.nextInt();
        pair[] arr = new pair[n];
        HashMap<pair, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pair p = new pair(fr.nextInt(), fr.nextInt());
            arr[i] = p;
            if (map.containsKey(p)) map.put(p, map.get(p) + 1);
            else map.put(p, 1);
        }
        Arrays.sort(arr);
        System.out.println(map.get(arr[k - 1]));
    }

}
