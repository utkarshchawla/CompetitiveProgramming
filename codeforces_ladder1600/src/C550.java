import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C550 {
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
        String s = fr.nextLine();
        mover m = new mover();
        m.s = "";
        int dp[][] = new int[s.length()][8];
        boolean ans = helper(s, 0, 0, "", m, dp);
        if (ans) {
            System.out.println("YES");
            System.out.println(m.s);
        } else System.out.println("NO");
    }

    public static class mover {
        String s;
    }

    private static boolean helper(String s, int idx, int mod, String ans, mover m, int[][] dp) {
        if (idx == s.length()) {
            if (mod == 0 && !ans.equals("")) {
                if (m.s.equals(""))
                    m.s = ans;
                return true;
            }
            return false;
        }
        if (dp[idx][mod] != 0) return dp[idx][mod] == 1;

        boolean a = helper(s, idx + 1, (mod * 10 + s.charAt(idx) - '0') % 8, ans + s.charAt(idx), m, dp);
        boolean b = helper(s, idx + 1, mod, ans, m, dp);
        if (a || b) dp[idx][mod] = 1;
        else dp[idx][mod] = -1;
        return a || b;
    }
}