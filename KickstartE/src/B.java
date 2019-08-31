import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B {
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

    static class pair implements Comparable<pair> {
        int e;
        int c;
        double ratio;

        pair(int c, int e) {
            this.e = e;
            this.c = c;
            ratio = (double) c / (double) e;
        }

        @Override
        public int compareTo(pair o) {
            double diff = o.ratio - this.ratio;
            if (diff < 0) return -1;
            if (diff > 0) return 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int d = fr.nextInt();
            int s = fr.nextInt();
            pair[] arr1 = new pair[s];
            pair[] arr2 = new pair[s];
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < s; i++) {
                pair p1 = new pair(fr.nextInt(), fr.nextInt());
                pair p2 = new pair(p1.e, p1.c);
                sum1 += p1.e;
                sum2 += p2.e;
                arr1[i] = p1;
                arr2[i] = p2;
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            StringBuilder sb = new StringBuilder();
            while (d-- > 0) {
                int a = fr.nextInt();
                int b = fr.nextInt();
                int tb = sum1 - b;
                double ma = 0;
                for (int i = 0; i < arr1.length && tb > 0; i++) {
                    int sub = Math.min(arr1[i].e, tb);
                    ma += sub * arr1[i].ratio;
                    tb -= sub;
                }
                int ta = sum2 - a;
                double mb = 0;
                for (int i = 0; i < arr2.length && ta > 0; i++) {
                    int sub = Math.min(arr2[i].e, ta);
                    mb += sub * arr2[i].ratio;
                    ta -= sub;
                }


                if ((ma >= a && tb >= 0) || (mb >= b && ta >= 0)) sb.append("Y");
                else sb.append("N");

            }
            System.out.println("Case #" + tc + ": " + sb);
        }
    }
}
