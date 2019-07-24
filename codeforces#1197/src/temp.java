import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class temp {
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
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int tar = fr.nextInt();
            int[] p = new int[n];
            int[] f = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = fr.nextInt();
                f[i] = fr.nextInt();
            }
            int[][][] dp = new int[11][11][n + 1];
            for (int[][] ta : dp) for (int[] tta : ta) Arrays.fill(tta, -1);
            if (helper(p, f, 0, 0, 0, tar, dp) == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static int helper(int[] p, int[] f, int i, int tp, int tf, int tar, int[][][] dp) {
        if (i == p.length) {
            if (tf != 0 && tp / tf == tar) return 1;
            return 0;
        }
        if (dp[tp][tf][i] != -1) return dp[tp][tf][i];

        int ans = 0;
        if (helper(p, f, i + 1, tp + p[i], tf + f[i], tar, dp) == 1 || helper(p, f, i + 1, tp, tf, tar, dp) == 1)
            ans = 1;
        return dp[tp][tf][i] = ans;
    }
}
