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

    public static int mod = 998244353;
    public static int count = 0;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
        long ans = 0;
        while (true) {
            if (arr[0] == 0) break;
            long val = 0;
            for (int i = 0; i < arr.length; i++) {
                val += arr[i] % 10;
                arr[i] /= 10;
            }
            long mp = modpow(10, count);
            long add = ((val % mod) * (mp % mod)) % mod;
            ans = (ans % mod + add % mod) % mod;
            count++;
            mp = modpow(10, count);
            add = ((val % mod) * (mp % mod)) % mod;
            ans = (ans % mod + add % mod) % mod;
            count++;
        }

        ans = (ans * n) % mod;
        System.out.println(ans);
    }

    private static long modpow(int b, int p) {
        if (p == 0) return 1;
        if (p == 1) return b;
        if (p % 2 == 1) {
            return (b % mod) * (modpow(b, p - 1) % mod) % mod;
        }

        long y = modpow(b, p / 2) % mod;
        return ((y % mod) * (y % mod)) % mod;
    }
}
