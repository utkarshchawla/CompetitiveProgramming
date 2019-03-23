package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva10407 {
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
        while (true) {
            ArrayList<Integer> list = new ArrayList<>();
            int n = fr.nextInt();
            if (n == 0) break;
            while (true) {
                int val = fr.nextInt();
                if (val == 0) break;
                list.add(val);
            }
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) - n);
            }

            while (list.size() > 1) {
                int a = list.remove(list.size() - 1);
                int b = list.remove(list.size() - 1);
                list.add(gcd(a, b));
            }

            System.out.println(Math.abs(list.get(0)));
        }
    }

    private static int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
