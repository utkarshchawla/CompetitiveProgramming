package adHocMaths;

import java.io.*;
import java.util.StringTokenizer;

public class uva10773 {
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
        int t = fr.nextInt();
        for (int i = 1; i <= t; i++) {
            double d = fr.nextDouble();
            double v = fr.nextDouble();
            double u = fr.nextDouble();
            double den = Math.sqrt(u * u - v * v);
            if (u <= v || den == 0 || v == 0) {
                System.out.println("Case " + i + ": can't determine");
                continue;
            }

            double t1 = d / den;
            double t2 = d / u;
            System.out.print("Case " + i + ": ");
            System.out.printf("%.3f", (t1 - t2));
            System.out.println();
        }
    }
}
