package combinatorics;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva11955 {
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
        for (int tc = 1; tc <= t; tc++) {
            String s = fr.nextLine();
            int n = Integer.parseInt((s.charAt(s.length() - 1) - '0') + "");
            if (s.charAt(s.length() - 2) != '^') {
                n = Integer.parseInt(s.substring(s.length() - 2));
            }
            int temp = 1;
            int sub = 3;
            if (n > 9) {
                sub++;
            }
            String a = "";
            String b = "";
            while (true) {
                if (s.charAt(temp) == '+') {
                    a = s.substring(1, temp);
                    b = s.substring(temp + 1, s.length() - sub);
                    break;
                }
                temp++;
            }
            StringBuilder ans = new StringBuilder();
            ans.append(a);
            if (n > 1) {
                ans.append("^").append(n);
            }
            ans.append("+");
            for (int i = 1; i < n; i++) {
                BigInteger big = solver(n, i);
                if (!big.equals(BigInteger.ONE)) {
                    ans.append(solver(n, i)).append("*");
                }
                ans.append(a);
                if (n - i > 1) ans.append("^").append(n - i);

                ans.append("*").append(b);
                if (i > 1) ans.append("^").append(i);
                ans.append("+");
            }
            ans.append(b);
            if (n > 1) {
                ans.append("^").append(n);
            }

            System.out.println("Case " + tc + ": " + ans);
        }
    }

    private static BigInteger solver(int n, int c) {
        int min = Math.min(c, n - c);
        BigInteger ans = BigInteger.ONE;
        for (int i = 0; i < min; i++) {
            ans = ans.multiply(new BigInteger(n - i + ""));
            ans = ans.divide(new BigInteger(i + 1 + ""));
        }
        return ans;
    }
}
