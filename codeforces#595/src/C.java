import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C {
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
        int q = fr.nextInt();
        while (q-- > 0) {
            long n = fr.nextLong();
            BigInteger val = BigInteger.ZERO;
            int pow = 0;
            BigInteger ans = BigInteger.ZERO;
            while (val.compareTo(BigInteger.valueOf(n)) < 0) {
                val = BigInteger.valueOf(3).pow(pow);
                ans = ans.add(val);
                pow++;
            }
            pow--;
            for (int p = pow; p >= 0; p--) {
                BigInteger hola = BigInteger.valueOf(3).pow(p);
                BigInteger sub = ans.subtract(hola);
                if (sub.compareTo(BigInteger.valueOf(n)) >= 0) ans = sub;
            }
            System.out.println(ans);

        }
    }
}
