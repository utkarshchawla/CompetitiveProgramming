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
        String s = fr.nextLine();
        int ld = 0;
        int rd = 0;
        int ls = 0;
        int rs = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == '?') ld++;
            else ls += s.charAt(i) - '0';
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (s.charAt(i) == '?') rd++;
            else rs += s.charAt(i) - '0';
        }

        if (ld > rd && ls > rs) System.out.println("Monocarp");
        else if (rd > ld && rs > ls) System.out.println("Monocarp");
        else {
            int dd = 0;
            int sd = 0;
            if (ld > rd) {
                dd = ld - rd;
                sd = rs - ls;
            } else {
                dd = rd - ld;
                sd = ls - rs;
            }

            int mval = (dd / 2) * 9;
            if (mval == sd) System.out.println("Bicarp");
            else System.out.println("Monocarp");

        }
    }
}
