import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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
        if ((2 * m * n) % k != 0) {
            System.out.println("NO");
            return;
        }

        long a = 0, b = 0;
        if (2 * m % k == 0) {
            a = n;
            b = 2 * m / k;
        } else if (2 * n % k == 0) {
            a = 2 * n / k;
            b = m;
        } else {
            long g = gcd(2 * n, k);
            a = 2 * n / g;
            b = m * g / k;
        }
        System.out.println("YES");
        System.out.println("0 0");
        System.out.println(a + " 0");
        System.out.println("0 " + b);
    }

    private static long gcd(long l, long k) {
        if (l == 0) return k;
        return gcd(k % l, l);
    }
}
