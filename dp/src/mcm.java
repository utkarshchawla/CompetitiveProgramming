import java.io.*;
import java.util.StringTokenizer;

public class mcm {
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
        int[] dims = {20, 25, 60, 42, 57,43};
        int[][] strg = new int[dims.length][dims.length];
        System.out.println(mcmTD(dims, 0, dims.length - 1, strg));
        System.out.println(mcmBU(dims));
    }

    public static int mcmTD(int[] dims, int si, int fi, int[][] strg) {
        if (fi - si < 2) {
            return 0;
        }
        if (strg[si][fi] != 0) {
            return strg[si][fi];
        }
        int min = Integer.MAX_VALUE;
        for (int i = si + 1; i < fi; i++) {
            int sum1 = mcmTD(dims, si, i, strg);
            int sum2 = mcmTD(dims, i, fi, strg);
            int sum3 = dims[si] * dims[i] * dims[fi];
            int sum = sum1 + sum2 + sum3;
            if (sum < min) {
                min = sum;
            }
        }

        return strg[si][fi] = min;
    }

    public static int mcmBU(int[] dims) {
        int strg[][] = new int[dims.length][dims.length];
        for (int i = strg.length - 1; i >= 0; i--) {
            for (int j = i + 2; j < strg[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int sum1 = strg[i][k];
                    int sum2 = strg[k][j];
                    int sum3 = dims[i] * dims[k] * dims[j];
                    int sum = sum1 + sum2 + sum3;
                    if (sum < min) {
                        min = sum;
                    }
                }
                strg[i][j] = min;
            }
        }

        return strg[0][strg[0].length - 1];
    }
}
