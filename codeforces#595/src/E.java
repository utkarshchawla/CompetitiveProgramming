import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class E {
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
        int n = fr.nextInt();
        int c = fr.nextInt();
        int[] s = new int[n];
        for (int i = 1; i < n; i++) s[i] = fr.nextInt();
        int[] e = new int[n];
        for (int i = 1; i < n; i++) e[i] = fr.nextInt() + c;
        int ans[] = new int[n];
        boolean el = false;
        for (int i = 1; i < n; i++) {
            if (el) e[i] -= c;
            if (s[i] < e[i]) {
                ans[i] = ans[i - 1] + s[i];
                el = false;
            } else if (e[i] <= s[i]) {
                ans[i] = ans[i - 1] + e[i];
                el = true;
            }
        }

//        System.out.print(0 + " ");
        for (int i : ans) System.out.print(i + " ");
        System.out.println();
    }
}
