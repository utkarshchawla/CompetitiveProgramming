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

    private static  int N = (int) (1.5e7);
    private static int[] seive = new int[N + 1];
    private static int[] count = new int[N + 1];
    private static int sub = Integer.MIN_VALUE;

    private static void seivegen() {
        for (long i = 2; i < seive.length; i++) {
            if (seive[(int) i] == 0) {
                for (long j = i * i; j < seive.length; j += i) {
                    seive[(int) j] = (int) i;
                }
            }
        }

        for (int i = 1; i < seive.length; i++) {
            if (seive[i] == 0) seive[i] = i;
        }

    }

    public static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    private static void primefactor(int val) {
        HashSet<Integer> set = new HashSet<>();
        while (val > 1) {
            int div = seive[val];
            count[div]++;
            sub = Math.max(sub, count[div]);
            while (val % div == 0) val /= div;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        seivegen();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextInt();
        }
        int gcd = gcd(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) gcd = gcd(gcd, arr[i]);
        for (int i = 0; i < arr.length; i++) arr[i] /= gcd;
        for (int i = 0; i < n; i++) {
            primefactor(arr[i]);
        }
        if (sub == Integer.MIN_VALUE) System.out.println(-1);
        else System.out.println(n - sub);
    }
}