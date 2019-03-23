package adHocMaths;

import java.io.*;
import java.util.StringTokenizer;

public class uva10161 {
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
            if (n == 0) break;
            int val = (int) Math.ceil(Math.sqrt(n));
            int x;
            int y;
            int diff = val * val - n;
            if (val % 2 == 0) {
                if (diff < val) {
                    x = val;
                    y = 1 + diff;
                } else {
                    y = val;
                    x = val - (diff - val + 1);
                }
            } else {
                if (diff < val) {
                    y = val;
                    x = diff + 1;
                } else {
                    x = val;
                    y = val - (diff - val + 1);
                }

            }
            System.out.println(x + " " + y);
        }
    }
}
