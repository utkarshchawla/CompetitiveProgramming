import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D2 {
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

    static class pair {
        int val;
        int n;

        pair(int val, int n) {
            this.val = val;
            this.n = n;
        }
    }

    public static int mod = 998244353;
    public static int count = 0;

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        pair[] arr = new pair[n];
        for (int i = 0; i < arr.length; i++) {
            int val = fr.nextInt();
            arr[i] = new pair(val, getn(val));
        }
        long ans = 0;
        while (true) {
            int nz = 0;
            long val = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].n <= 0) nz++;
                val += arr[i].val % 10;
                arr[i].val /= 10;
                arr[i].n--;
            }
            if (nz == arr.length) break;
            long mp = modpow(10, count);
            long add = ((val % mod) * (mp % mod)) % mod;
            long mul = (nz * 2 + arr.length - nz);
            add = ((add % mod) * (mul % mod)) % mod;
            ans = (ans % mod + add % mod) % mod;
            count++;
            mp = modpow(10, count);
            add = ((val % mod) * (mp % mod)) % mod;
            mul = arr.length - nz;
            add = ((add % mod) * (mul % mod)) % mod;
            ans = (ans % mod + add % mod) % mod;
            count++;
        }

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

    public static int getn(int val) {
        String s = Integer.toString(val);
        return s.length();
    }
}
