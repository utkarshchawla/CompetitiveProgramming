package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva10176 {
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

    public static void main(String[] args) throws IOException {
        Scanner fr = new Scanner(System.in);
        FastWriter fw = new FastWriter();
        while (fr.hasNext()) {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String s = fr.nextLine();
                sb.append(s);
                if (s.charAt(s.length() - 1) == '#') break;
            }
            String s = sb.toString();
            BigInteger ans = BigInteger.ZERO;
            BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
            for (int i = s.length() - 2; i >= 0; i--) {
                if (s.charAt(i) == '1') {
                    ans = ans.add(two.modPow(BigInteger.valueOf(s.length() - 2 - i), BigInteger.valueOf(131071)));
//                    ans += Math.pow(2, s.length() - 2 - i);
//                    ans %= 131071;
                }
            }
            ans = ans.mod(BigInteger.valueOf(131071));
            if (ans.equals(BigInteger.ZERO)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }
}
