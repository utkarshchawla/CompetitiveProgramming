import java.io.*;
import java.util.StringTokenizer;

public class jobScheduling {
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
        int[] st = {1, 3, 6, 2};
        int[] ft = {2, 5, 19, 100};
        int[] p = {50, 20, 100, 200};
        int[][] strg = new int[st.length][ft[ft.length - 1] + 1];
        System.out.println(jobTD(st, ft, p, 0, 0, strg));

    }

    public static int jobTD(int[] st, int[] ft, int[] p, int time, int vidx, int[][] strg) {
        if (vidx == st.length) {
            return 0;
        }

        if (strg[vidx][time] != 0) {
            return strg[vidx][time];
        }

        int a = jobTD(st, ft, p, time, vidx + 1, strg);
        int b = 0;
        if (st[vidx] >= time) {
            b = p[vidx] + jobTD(st, ft, p, ft[vidx], vidx + 1, strg);
        }

        return strg[vidx][time] = Math.max(a, b);
    }
}
