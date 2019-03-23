package A1;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class CHEFADD {
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
        while (t-- > 0) {
            int a = findbits(fr.nextInt());
            int b = findbits(fr.nextInt());
            int c = fr.nextInt();
            int temp = (int) Math.ceil(Math.log(c) / Math.log(2));
            ArrayList<Integer> ans = new ArrayList<>();
            helper(a, ans, temp, 0, 0, 0, c);
            int count = 0;
            for (int i : ans) {
                if (findbits(c - i) == b) count++;
            }
            System.out.println(count);
        }


    }

    private static void helper(int ones, ArrayList<Integer> ans, int n, int mo, int number, int size, int c) {
        if (mo > ones || size > n || number >= c) return;
        if (size == n) {
            if (mo == ones) ans.add(number);
            return;
        }
        helper(ones, ans, n, mo + 1, number * 2 + 1, size + 1, c);
        helper(ones, ans, n, mo, number * 2, size + 1, c);
    }

    public static int findbits(int n) {
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}
