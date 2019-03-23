package preEl;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class temp {
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

    public static int count = 0;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int m = fr.nextInt();
            int x = fr.nextInt();
            int y = fr.nextInt();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == (x - 1) && j == (y - 1)) continue;
                    ans += n * m - 1 - (n - 1) - (m - 1);
                    ans -= Math.min(n - i - 1, m - j - 1);
                    ans -= Math.min(i, j);
                    ans -= Math.min(i, m - j - 1);
                    ans -= Math.min(n - i - 1, j);
                    ans += helper(i, j, x, y, m, n);
                }
            }
            System.out.println(ans);
        }
    }

    private static long helper(int i, int j, int x, int y, int m, int n) {
        x--;
        y--;
        if (i == x) {
            if (j > y) return y;
            else return m - y - 1;
        }

        if (j == y) {
            if (i > x) return x;
            else return n - x - 1;
        }

        if (Math.abs(i - x) == Math.abs(j - y)) {
            if (x < i && y > j) return Math.min(x, m - y - 1);
            if (x < i && y < j) return Math.min(x, y);
            if (x > i && y > j) return Math.min(n - x - 1, m - y - 1);
            if (x > i && y < j) return Math.min(n - x - 1, y);
        }

        return -1;
    }
}
