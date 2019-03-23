package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva324 {
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
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        while (true) {
            int n = fr.nextInt();
            if (n == 0) break;
            BigInteger big = BigInteger.ONE;
            for (int i = 2; i <= n; i++) {
                big = big.multiply(new BigInteger(i + ""));
            }
            int[] arr = new int[10];
            String s = big.toString();
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - '0']++;
            }

            fw.println(n + "! --");
            fw.println("   (0)" + addSpace(arr[0]) + "    (1)" + addSpace(arr[1]) + "    (2)" + addSpace(arr[2]) + "    (3)" + addSpace(arr[3]) + "    (4)" + addSpace(arr[4]));
            fw.println("   (5)" + addSpace(arr[5]) + "    (6)" + addSpace(arr[6]) + "    (7)" + addSpace(arr[7]) + "    (8)" + addSpace(arr[8]) + "    (9)" + addSpace(arr[9]));

        }
        fw.close();
    }

    private static String addSpace(int n) {
        StringBuilder s = new StringBuilder(n + "");
        int len = s.length();
        for (int i = 0; i < 5 - len; i++) {
            s.insert(0, " ");
        }
        return s.toString();
    }
}
