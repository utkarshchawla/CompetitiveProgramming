package QL;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class TEAMMATE {
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
            long mod = 1000000007;
            int n = fr.nextInt();
            long[] arr = new long[n];
            HashMap<Long, Long> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
                if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1L);
                else map.put(arr[i], 1L);
            }
            Arrays.sort(arr);
            long ans = 1;
            for (int i = 0; i < arr.length - 1; i += 2) {
                long a = arr[i];
                long b = arr[i + 1];
                map.put(a, map.get(a) - 1);
                if (map.get(b) > 0)
                    ans = ((ans % mod) * (map.get(b) % mod)) % mod;
                map.put(b, map.get(b) - 1);
            }
            System.out.println(ans % mod);
        }
    }
}
