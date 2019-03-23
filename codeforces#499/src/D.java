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
        long m = fr.nextLong();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int ans = helper(m, fr);
            if (ans == 0) System.exit(0);
            else if (ans == -1) arr[i] = 1;
            else arr[i] = 0;
        }
        long lo = 1;
        long hi = m;
        int count = 0;
        boolean flag;
        while (lo <= hi) {
            if (arr[count] == 0) flag = false;
            else flag = true;
            long mid = (lo + hi) / 2;
            int ans = helper(mid, fr);
            if (Math.abs(ans) == 2) System.exit(0);
            if (ans == 0) System.exit(0);
            if (flag) {
                if (ans == -1) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if (ans == -1) lo = mid + 1;
                else hi = mid - 1;
            }
            count = (count + 1) % n;
        }
    }

    public static int helper(long a, FastReader fr) {
        System.out.println(a);
        System.out.flush();
        return fr.nextInt();
    }
}
