import java.io.*;
import java.util.StringTokenizer;

public class egg_dropping {
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
        int ne = 2;
        int nf = 6;
        int[][] strg = new int[ne + 1][nf + 1];
        System.out.println(eggDropTD(ne, nf, strg));
    }

    public static int eggDropTD(int ne, int nf, int[][] strg) {
        if (nf == 0 || nf == 1) {
            return nf;
        }
        if (ne == 1) {
            return nf;
        }

        if (strg[ne][nf] != 0) {
            return strg[ne][nf];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= nf; i++) {
            int val = Math.max(eggDropTD(ne - 1, i - 1, strg), eggDropTD(ne, nf - i, strg));
            if (val < min) {
                min = val;
            }
        }

        return strg[ne][nf] = min + 1;
    }
}
