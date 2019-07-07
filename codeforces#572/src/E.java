import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class E {
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
        int n = fr.nextInt();
        int p = fr.nextInt();
        int k = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = transform(fr.nextInt(), k, p);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        long ans = 0;
        for (int v : map.values()) {
            ans += v * (v - 1) / 2;
        }
        System.out.println(ans);
    }

    public static int transform(int val, int k, int mod) {
        long rv = ((val % mod) *1L* (val % mod)) % mod;
        rv = ((rv % mod) *1L* (val % mod)) % mod;
        rv = ((rv % mod) *1L* (val % mod)) % mod;
        long sub = ((val % mod) *1L* (k % mod)) % mod;
        rv = (rv % mod - sub % mod + mod) % mod;
        return (int) rv;
    }
}
