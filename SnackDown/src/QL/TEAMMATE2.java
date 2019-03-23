package QL;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class TEAMMATE2 {
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
            TreeMap<Long, Long> map = new TreeMap<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                long val = fr.nextLong();
                if (map.containsKey(val)) map.put(val, map.get(val) + 1L);
                else map.put(val, 1L);
            }
            ArrayList<Long> list = new ArrayList<>(map.values());
            long ans = 1;
            for (int i = 0; i < list.size(); i++) {
                long val = list.get(i);
                if (val == 0) continue;
                if (val % 2 == 0) {
                    for (long temp = val - 1; temp >= 1; temp -= 2) ans = ((ans % mod) * (temp % mod)) % mod;
                } else {
                    if (val == 1 && i + 1 < list.size()) {
                        ans = ((ans % mod) * (list.get(i + 1) % mod)) % mod;
                        list.set(i + 1, list.get(i + 1) - 1);
                    } else if (val != 1) {
                        for (long temp = val; temp >= 1; temp -= 2) ans = ((ans % mod) * (temp % mod)) % mod;
                        list.set(i, 1L);
                        i--;
                    }
                }
            }

            System.out.println(ans);

        }

    }
}
