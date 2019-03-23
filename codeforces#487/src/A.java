import sun.util.resources.cldr.lt.TimeZoneNames_lt;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class A {
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
        for (int i = 0; i < s.length(); i++) {
            char x = '.';
            char y = s.charAt(i);
            char z = '.';
            if (i - 1 >= 0) x = s.charAt(i - 1);
            if (i + 1 < s.length()) z = s.charAt(i + 1);
            char[] arr = new char[3];
            arr[0] = x;
            arr[1] = y;
            arr[2] = z;
            Arrays.sort(arr);
            if (arr[0] == 'A' && arr[1] == 'B' && arr[2] == 'C') {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
