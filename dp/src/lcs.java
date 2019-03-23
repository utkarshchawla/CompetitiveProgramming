import java.io.*;
import java.util.StringTokenizer;

public class lcs {
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
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        System.out.println(lcsTD("abcdaf", "acbcf"));
        System.out.println(lcsBU("abcdaf", "acbcf"));

    }

    public static int lcsTD(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0) {
            return 0;
        }
        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        int ans = 0;
        if (c1 == c2) {
            ans = 1 + lcsTD(s1.substring(1), s2.substring(1));
        } else {
            ans = Math.max(lcsTD(s1, s2.substring(1)), lcsTD(s1.substring(1), s2));
        }
        return ans;

    }

    public static int lcsBU(String s1, String s2) {
        int[][] strg = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < strg.length; i++) {
            for (int j = 1; j < strg[0].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    strg[i][j] = 1 + strg[i - 1][j - 1];
                } else {
                    strg[i][j] = Math.max(strg[i - 1][j], strg[i][j - 1]);
                }
            }
        }

        return strg[strg.length - 1][strg[0].length - 1];
    }
}
