import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D2 {
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
            int ans = Integer.MAX_VALUE;
            int n = fr.nextInt();
            int k = fr.nextInt();
            String s = fr.nextLine();
            String[] arr = {"RGB", "GBR", "BRG"};
            for (String str : arr) {
                int count = 0;
                for (int i = 0; i < k; i++) {
                    if (s.charAt(i) != str.charAt(i % 3)) count++;
                }
                ans = Math.min(ans, count);
                for (int i = k; i < s.length(); i++) {
                    if (s.charAt(i) != str.charAt(i % 3)) count++;
                    if (s.charAt(i - k) != str.charAt((i - k) % 3)) count--;
                    ans = Math.min(ans, count);
                }
            }
            System.out.println(ans);
        }
    }
}
