package combinatorics;


import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva10689 {
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
        BigInteger[] arr = new BigInteger[15001];
        arr[0] = BigInteger.ZERO;
        arr[1] = BigInteger.ONE;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1].add(arr[i - 2]);
        }
        int t = fr.nextInt();
        while (t-- > 0) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            long n = fr.nextLong();
            int m = fr.nextInt();
            int mod = -1;
            if (m == 1) {
                mod = 60;
            } else if (m == 2) {
                mod = 300;
            } else if (m == 3) {
                mod = 1500;
            } else {
                mod = 15000;
            }

            String s = fiboCal(arr, a, b, (int) (n % mod));
            int sub = s.length() - m;
            if (s.length() - m < 0) {
                sub = 0;
            }
            fw.println(Integer.parseInt(s.substring(sub)));
        }
        fw.close();
    }

    public static String fiboCal(BigInteger[] arr, int a, int b, int n) {
        if (n == 0) {
            return (new BigInteger(a + "")).toString();
        }
        return arr[n].multiply(new BigInteger(b + "")).add(arr[n - 1].multiply(new BigInteger(a + ""))).toString();
    }
}
