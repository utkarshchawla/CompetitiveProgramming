import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C {
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
        long n = fr.nextLong();
        long m = fr.nextLong();
        long k = fr.nextLong();
        long ak = k;
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < m; i++) list.add(fr.nextLong());
        list.sort(null);
        long ans = 0;
        long si = 0;
        while (si < list.size()) {
            int idx = Collections.binarySearch(list, k);
            if (idx < 0) idx = -(idx + 1);
            else idx++;
            if (idx - si == 0) {
                long mul = (list.get((int) si) - k) / ak;
                if ((list.get((int) si) - k) % ak != 0) mul++;
                long add = ak * (mul);
                k += add;
                continue;
            }
            k += idx - si;
            si = idx;
            ans++;
        }
        System.out.println(ans);
    }
}
