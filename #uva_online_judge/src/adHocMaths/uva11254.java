package adHocMaths;

import java.io.*;
import java.util.StringTokenizer;

public class uva11254 {
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
        while (true) {
            int n = fr.nextInt();
            if (n == -1) {
                break;
            }
            int start = -1;
            int end = -1;
            for (int i = (int) Math.sqrt(2 * n); i >= 1; i--) {
                double a = (double) (2 * n + i - i * i) / (double) (2 * i);
                int b = (int) a;
                if (a - b == 0 && a > 0) {
                    start = b;
                    end = start + i - 1;
                    break;
                }
            }

            fw.println(n + " = " + start + " + ... + " + end);

        }

        fw.close();
    }
}
