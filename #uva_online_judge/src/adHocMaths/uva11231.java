package adHocMaths;

import java.io.*;
import java.util.StringTokenizer;

public class uva11231 {
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

        while (true) {

            int n = fr.nextInt();
            int m = fr.nextInt();
            int c = fr.nextInt();
            if (m == 0 && n == 0 && c == 0) {
                break;
            }
            int ans = -1;
            if (c == 1) {
                ans = solver(n, m);
            } else {
                ans = solver(n, m - 1);
                if (n >= 9) {
                    ans += (n - 9) / 2 + 1;
                }
            }

            if (n < 8 || m < 8) {
                ans = 0;
            }

            System.out.println(ans);
        }
    }

    public static int solver(int n, int m) {
        int rv = 0;
        if (n < 8 || m < 8) {
            return rv;
        }
        for (int i = 0, j = 0; n - 8 - i >= 0 && m - 8 - j >= 0; i++, j++) {
            rv += (n - 8 - i) / 2 + (m - 8 - j) / 2 + 1;
        }

        return rv;
    }
}
