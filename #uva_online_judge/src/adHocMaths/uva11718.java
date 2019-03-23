package adHocMaths;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class uva11718 {
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
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        for (int c = 1; c <= t; c++) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int m = fr.nextInt();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += fr.nextInt();
            }
            BigInteger base, exp, mod, x, y, z, ans;
            base = new BigInteger(String.valueOf(n));
            exp = new BigInteger(String.valueOf(k - 1));
            mod = new BigInteger(String.valueOf(m));
            x = base.modPow(exp, mod);
            y = new BigInteger(String.valueOf(k)).mod(mod);
            z = new BigInteger(String.valueOf(sum)).mod(mod);
            ans = x.multiply(y).multiply(z);
            fw.println("Case " + c + ": " + ans.mod(mod));
        }
        fw.close();
    }
}
