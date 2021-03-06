package adHocMaths;

import java.io.*;
import java.util.StringTokenizer;

public class uva11723 {

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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();

        for (int i = 1; ; i++) {
            double r = fr.nextDouble();
            double n = fr.nextDouble();
            if (r == 0 || n == 0) {
                break;
            }

            r -= n;
            double d = Math.ceil(r / n);
            if (d > 26) {
                fw.println("Case " + i + ": impossible");
            } else {
                fw.println("Case " + i + ": " + (int)d);
            }
        }
        fw.close();
    }
}
