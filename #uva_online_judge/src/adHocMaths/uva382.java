package adHocMaths;

import java.io.*;
import java.util.StringTokenizer;

public class uva382 {
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
        System.out.println("PERFECTION OUTPUT");
        while (true) {
            int n = fr.nextInt();
            if (n == 0) {
                System.out.println("END OF OUTPUT");
                break;
            }
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                }
            }

            if (sum == n) {
                System.out.printf("%5d  PERFECT", n);
                System.out.println();
            } else if (sum < n) {
                System.out.printf("%5d  DEFICIENT", n);
                System.out.println();
            } else {
                System.out.printf("%5d  ABUNDANT", n);
                System.out.println();
            }

        }
    }
}
