import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

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
        int t = fr.nextInt();
        o:
        while (t-- > 0) {
            int n = fr.nextInt();
            int[] x = new int[2];
            int[] y = new int[2];
            x[0] = -100000;
            x[1] = 100000;
            y[0] = -100000;
            y[1] = 100000;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int xi = fr.nextInt();
                int yi = fr.nextInt();
                int a = fr.nextInt();
                int b = fr.nextInt();
                int c = fr.nextInt();
                int d = fr.nextInt();
                if (a == 0) x[0] = Math.max(x[0], xi);
                if (b == 0) y[1] = Math.min(y[1], yi);
                if (c == 0) x[1] = Math.min(x[1], xi);
                if (d == 0) y[0] = Math.max(y[0], yi);
                if (x[0] > x[1] || y[0] > y[1]) flag = false;
            }
            if (flag)
                System.out.println(1 + " " + x[0] + " " + y[0]);
            else System.out.println(0);

        }
    }
}
