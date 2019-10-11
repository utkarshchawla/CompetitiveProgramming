import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
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
        long q = fr.nextLong();
        while (q-- > 0) {
            long n = fr.nextLong();
            long[] arr = new long[(int) n];
            for (int i = 0; i < arr.length; i++) arr[i] = fr.nextLong();
            Arrays.sort(arr);
            long x = fr.nextLong();
            long a = fr.nextLong();
            long y = fr.nextLong();
            long b = fr.nextLong();
            long k = fr.nextLong();
            long ans = Long.MAX_VALUE;
            long lo = 1;
            long hi = n;
            while (lo <= hi) {
                long mid = (lo + hi) / 2;
                if (isok(arr, mid, x, a, y, b, k)) {
                    ans = Math.min(ans, mid);
                    hi = mid - 1;
                } else lo = mid + 1;
            }

            if (ans == Long.MAX_VALUE) System.out.println(-1);
            else System.out.println(ans);
        }

    }

    public static boolean isok(long[] arr, long mid, long x, long a, long y, long b, long k) {
        long pro = (a * 1L * b) / gcd(a, b);
        long val = mid / pro;
        long sum = 0;
        int count = arr.length - 1;
        for (int i = 0; i < val; i++) {
            sum += (arr[count] * 1L * (x + y)) / 100;
            if (sum >= k) return true;
            count--;
        }
        if (y > x) {
            long temp = x;
            x = y;
            y = temp;
            temp = a;
            a = b;
            b = temp;
        }
        long temp = val;
        val = mid / a - temp;
        for (int i = 0; i < val; i++) {
            sum += (arr[count] * 1L * x) / 100;
            if (sum >= k) return true;
            count--;
        }

        val = mid / b - temp;
        for (int i = 0; i < val; i++) {
            sum += (arr[count] * 1L * y) / 100;
            if (sum >= k) return true;
            count--;
        }

        if (sum >= k) return true;
        return false;

    }

    private static long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
