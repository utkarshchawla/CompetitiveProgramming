import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B {
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

    public static int mod = 1000000007;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();

        int n = fr.nextInt();
        int m = fr.nextInt();
        BigInteger a = BigInteger.valueOf(2);
        a = a.modPow(BigInteger.valueOf(m), BigInteger.valueOf(mod));
        a = a.subtract(BigInteger.ONE);
        a = a.modPow(BigInteger.valueOf(n), BigInteger.valueOf(mod));
        System.out.println(a);
    }

    public static int modpow(int b, int p) {
        if (p == 1) return b;
        if (p == 0) return 1;
        if (p % 2 == 1) return ((b % mod) * (modpow(b, p - 1) % mod)) % mod;
        int y = modpow(b, p / 2) % mod;
        return (int) ((y * 1L * y) % mod);
    }
}
