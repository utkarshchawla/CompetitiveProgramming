package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class uva374 {
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
        Scanner fr = new Scanner(System.in);
        FastWriter fw = new FastWriter();

        while (true) {
            BigInteger b = BigInteger.valueOf(fr.nextInt());
            BigInteger p = BigInteger.valueOf(fr.nextInt());
            BigInteger m = BigInteger.valueOf(fr.nextInt());
            System.out.println(b.modPow(p, m));
            if (fr.hasNext()) {
                String s = fr.nextLine();
            } else {
                break;
            }

        }
    }
}
