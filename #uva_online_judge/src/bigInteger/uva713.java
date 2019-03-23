package bigInteger;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class uva713 {
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
        while (t-- > 0) {
            String s = fr.br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            StringBuilder a = new StringBuilder(st.nextToken());
            StringBuilder b = new StringBuilder(st.nextToken());

            BigInteger x = new BigInteger(String.valueOf(a.reverse()));
            BigInteger y = new BigInteger(String.valueOf(b.reverse()));
            BigInteger ans = x.add(y);
            StringBuilder val = new StringBuilder(ans.toString());
            ans = new BigInteger(String.valueOf(val.reverse()));
            System.out.println(ans);

        }
    }
}
