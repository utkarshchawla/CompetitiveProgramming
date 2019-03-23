package adHocMaths;

import java.io.*;
import java.util.StringTokenizer;

public class uva616 {
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

        while (true) {
            int n = fr.nextInt();
            if (n < 0) {
                break;
            }

            int ans = -1;
            for (int i = (int) Math.ceil(Math.sqrt(n)); i >= 2; i--) {
                int temp = n;
                int sum = 0;
                while (temp % i == 1) {
                    temp -= (temp / i + 1);
                    sum++;
                    if (sum > i) {
                        break;
                    }
                }
                if (temp % i == 0 && sum == i) {
                    ans = i;
                    break;
                }

            }

            if (ans == -1) {
                System.out.println(n + " coconuts, no solution");
            } else {
                System.out.println(n + " coconuts, " + ans + " people and 1 monkey");
            }
        }
    }
}
