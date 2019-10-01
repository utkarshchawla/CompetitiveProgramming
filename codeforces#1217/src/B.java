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
        int d;
        int h;

        public int compareTo(pair o) {
            return (o.d - o.h) - (this.d - this.h);
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int t = fr.nextInt();
        while (t-- > 0) {
            int n = fr.nextInt();
            int x = fr.nextInt();
            pair[] arr = new pair[n];
            int maxd = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new pair();
                arr[i].d = fr.nextInt();
                arr[i].h = fr.nextInt();
                maxd = Math.max(maxd, arr[i].d);
            }
            Arrays.sort(arr);
            int d = arr[0].d - arr[0].h;
            if (d <= 0) {
                if (x - maxd <= 0) System.out.println(1);
                else System.out.println(-1);
                continue;
            }

            x -= maxd;
            int val = 1;
            x = Math.max(0, x);
            val += Math.ceil(x / (double) d);
            System.out.println(val);
        }
    }
}
