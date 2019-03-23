import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class PlayList {
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
        long t;
        long b;

        pair(long t, long b) {
            this.t = t;
            this.b = b;
        }

        @Override
        public int compareTo(pair o) {
            return (int) (o.b - this.b);
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        long n = fr.nextLong();
        long k = fr.nextLong();
        pair[] arr = new pair[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = new pair(fr.nextLong(), fr.nextLong());
        }
        Arrays.sort(arr);
        PriorityQueue<Long> q = new PriorityQueue<>();
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long b = arr[i].b;
            long t = arr[i].t;
            q.add(t);
            sum += t;
            while (q.size() > k) {
                sum -= q.poll();
            }
            ans = Math.max(ans, b * sum);
        }

        System.out.println(ans);
    }
}
