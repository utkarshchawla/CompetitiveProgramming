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
        String s = fr.nextLine();
        StringBuilder sb = new StringBuilder();
        if (s.length() <= 3) {
            System.out.println(s.charAt(0));
            return;
        }
        for (int i = 0; i <= s.length() / 2; i += 2) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(s.length() - i - 1);
            char d = s.charAt(s.length() - i - 2);
            if (i + 1 >= s.length() - i - 2) {
                if (s.length() % 4 != 0) sb.append(a);
                break;
            }
            if (a == c || a == d) sb.append(a);
            else if (b == c || b == d) sb.append(b);
        }
        int n = sb.length() - 1;
        if (s.length() % 4 == 0) n = sb.length();
        for (int i = n - 1; i >= 0; i--) sb.append(sb.charAt(i));
        System.out.println(sb);
    }
}
