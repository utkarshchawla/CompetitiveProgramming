import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
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
        int k1 = fr.nextInt();
        int k2 = fr.nextInt();
        int k3 = fr.nextInt();
        int tot = k1 + k2 + k3;
        int[] arr = new int[tot + 1];
        int[][] dp = new int[tot + 1][4];
        for(int[] ta : dp) Arrays.fill(ta,-1);
        for (int i = 0; i < k1; i++) arr[fr.nextInt()] = 1;
        for (int i = 0; i < k2; i++) arr[fr.nextInt()] = 2;
        for (int i = 0; i < k3; i++) arr[fr.nextInt()] = 3;
        int ans = helper(tot, 3, arr, dp);
        System.out.println(ans);
    }

    public static int helper(int n, int c, int[] arr, int[][] dp) {
        if (n == 0) return 0;
        if (c == 0) return 1000000000;
        if (dp[n][c] != -1) return dp[n][c];
        int val = 0;
        if (arr[n] != c) val = 1;
        return dp[n][c] = Math.min(helper(n, c - 1, arr, dp), val + helper(n - 1, c, arr, dp));

    }
}
