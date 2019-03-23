import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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
        StringBuilder s = new StringBuilder(fr.nextLine());
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') zero++;
            else if (s.charAt(i) == '1') one++;
            else two++;
        }
        zero = n / 3 - zero;
        one = n / 3 - one;
        two = n / 3 - two;
        if (zero > 0) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1' && one < 0 && zero > 0) {
                    s.setCharAt(i, '0');
                    zero--;
                    one++;
                } else if (s.charAt(i) == '2' && two < 0 && zero > 0) {
                    s.setCharAt(i, '0');
                    zero--;
                    two++;
                }
            }
        }
        if (two > 0) {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0' && zero < 0 && two > 0) {
                    s.setCharAt(i, '2');
                    two--;
                    zero++;
                } else if (s.charAt(i) == '1' && one < 0 && two > 0) {
                    s.setCharAt(i, '2');
                    two--;
                    one++;
                }
            }
        }
        if (one > 0) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '2' && two < 0 && one > 0) {
                    s.setCharAt(i, '1');
                    one--;
                    two++;
                }
            }

            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) == '0' && zero < 0 && one > 0) {
                    s.setCharAt(i, '1');
                    one--;
                    zero++;
                }
            }
        }


        System.out.println(s);
    }
}
