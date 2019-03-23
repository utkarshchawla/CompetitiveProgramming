import java.io.*;
import java.util.StringTokenizer;

public class rodCutting {
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

        int[] len = {1, 2, 3, 4};
        int[] prices = {2, 5, 7, 8};
        int l = 5;
        int[] strg = new int[l + 1];
        System.out.println(rodCuttingTD(l, len, prices, strg));
        System.out.println(rodCuttingBU(l, len, prices));
    }

    public static int rodCuttingTD(int l, int[] len, int[] prices, int[] strg) {
        if (l == 0) {
            return 0;
        }

        if (strg[l] != 0) {
            return strg[l];
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < len.length; i++) {
            if (l >= len[i])
                ans = Math.max(ans, prices[i] + rodCuttingTD(l - len[i], len, prices, strg));
        }

        return strg[l] = ans;
    }

    public static int rodCuttingBU(int l, int[] len, int[] prices) {
        int strg[][] = new int[len.length][l + 1];
        for (int i = 0; i < strg.length; i++) {
            for (int j = 1; j < strg[0].length; j++) {
                int a = 0, b = 0;
                if (j >= len[i])
                    a = prices[i] + strg[i][j - len[i]];
                if (i > 0)
                    b = strg[i - 1][j];
                strg[i][j] = Math.max(a, b);

            }
        }

        return strg[strg.length - 1][strg[0].length - 1];
    }
}
