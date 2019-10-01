import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class A {
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
        int a1 = fr.nextInt();
        int a2 = fr.nextInt();
        int k1 = fr.nextInt();
        int k2 = fr.nextInt();
        int n = fr.nextInt();
        int t = n;
        t -= (a1 * (k1 - 1) + a2 * (k2 - 1));
        int min = 0;
        if (t > 0) {
            min = Math.min(a1 + a2, t);
        }

        int max = 0;
        if (k1 < k2) {
            int p = Math.min(n / k1, a1);
            max = p;
            n -= p * k1;
            if (n > 0) {
                p = Math.min(n / k2, a2);
                n -= p * k2;
                max += p;
            }
        } else {
            int p = Math.min(n / k2, a2);
            max = p;
            n -= p * k2;
            if (n > 0) {
                p = Math.min(n / k1, a1);
                n -= p * k1;
                max += p;
            }
        }

        System.out.println(min + " " + max);

    }
}
