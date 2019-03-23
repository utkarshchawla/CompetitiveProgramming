package A1;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class CHEFADD2 {
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

    private static int findbits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        while (t-- > 0) {
            int a = findbits(fr.nextInt());
            int b = findbits(fr.nextInt());
            int c = fr.nextInt();
            String s = Integer.toBinaryString(c);
            int[][][][] dp = new int[32][32][32][32];
            int ans = helper(s, s.length() - 1, a, b, 0, dp);
            fw.println(ans);
        }
        fw.close();

    }


    public static int helper(String s, int idx, int a, int b, int carry, int[][][][] dp) {
        if (a < 0 || b < 0) return 0;
        if (idx < 0) {
            if (a == 0 && b == 0 && carry == 0) return 1;
            return 0;
        }
        int ans = 0;
        if (carry == 1) {
            if (s.charAt(idx) == '1') {
                ans += helper(s, idx - 1, a, b, 0, dp);
                if (a - 1 >= 0 && b - 1 >= 0)
                    ans += helper(s, idx - 1, a - 1, b - 1, 1, dp);
            } else {
                if (a - 1 >= 0)
                    ans += helper(s, idx - 1, a - 1, b, 1, dp);
                if (b - 1 >= 0)
                    ans += helper(s, idx - 1, a, b - 1, 1, dp);
            }
        } else {
            if (s.charAt(idx) == '1') {
                if (b - 1 >= 0)
                    ans += helper(s, idx - 1, a, b - 1, 0, dp);
                if (a - 1 >= 0)
                    ans += helper(s, idx - 1, a - 1, b, 0, dp);
            } else {
                ans += helper(s, idx - 1, a, b, 0, dp);
                if (a - 1 >= 0 && b - 1 >= 0)
                    ans += helper(s, idx - 1, a - 1, b - 1, 1, dp);
            }
        }
        return dp[idx][a][b][carry] = ans;
    }
}
