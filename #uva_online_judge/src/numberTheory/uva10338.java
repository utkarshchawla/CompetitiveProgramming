package numberTheory;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class uva10338 {
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
        int tc = fr.nextInt();
        for (int i = 1; i <= tc; i++) {
            String s = fr.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }

            long ans = fac(s.length());
            for (Character c : map.keySet()) {
                int val = map.get(c);
                if (val > 1) {
                    ans /= fac(val);
                }
            }
            fw.println("Data set " + i + ": " + ans);
        }
        fw.close();

    }

    private static long fac(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }

        return ans;
    }
}
