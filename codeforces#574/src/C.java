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
        int n = fr.nextInt();
        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = 0; i < n; i++) up[i] = fr.nextInt();
        for (int i = 0; i < n; i++) down[i] = fr.nextInt();
        long[][] dp = new long[2][up.length];
        for (long[] ta : dp) Arrays.fill(ta, -1);
        System.out.println(Math.max(helper(up, down, 0, 1, dp), helper(up, down, 0, 0, dp)));
    }

    public static long helper(int[] up, int[] down, int idx, int isup, long[][] dp) {
        if (idx >= up.length) return 0;
        if (dp[isup][idx] != -1) {
            return dp[isup][idx];
        }
        long ans = Long.MIN_VALUE;
        if (isup == 1) {
            ans = up[idx] + Math.max(helper(up, down, idx + 1, 0, dp), helper(up, down, idx + 2, 0, dp));
        } else {
            ans = down[idx] + Math.max(helper(up, down, idx + 1, 1, dp), helper(up, down, idx + 2, 1, dp));
        }
        return dp[isup][idx] = ans;
    }
}
