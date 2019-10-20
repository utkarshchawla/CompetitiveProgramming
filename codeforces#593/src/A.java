import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class A {
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

        BigInteger nextBigInteger() {
            try {
                return new BigInteger(nextLine());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        while (t-- > 0) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            int c = fr.nextInt();
            int ans1 = 0;
            int ta = a;
            int tb = b;
            int tc = c;
            while (tb >= 1 && tc >= 2) {
                ans1 += 3;
                tb--;
                tc -= 2;
            }
            while (ta >= 1 && tb >= 2) {
                ans1 += 3;
                ta--;
                tb -= 2;
            }
            int ans2 = 0;
            ta = a;
            tb = b;
            tc = c;
            while (ta >= 1 && tb >= 2) {
                ans2 += 3;
                ta--;
                tb -= 2;
            }
            while (tb >= 1 && tc >= 2) {
                ans2 += 3;
                tb--;
                tc -= 2;
            }

            System.out.println(Math.max(ans1, ans2));
        }
    }
}
