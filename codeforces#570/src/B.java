import java.io.*;
import java.math.BigInteger;
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int q = fr.nextInt();
        while (q-- > 0) {
            int n = fr.nextInt();
            int k = fr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
            int ans = Integer.MIN_VALUE;
            o:
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i] - k;
                if (val < 0) continue;
                for (int j = 0; j < arr.length; j++) {
                    if (val < arr[j] - k || val > arr[j] + k) continue o;
                }
                ans = Math.max(ans, val);
            }
            o:
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i] + k;
                for (int j = 0; j < arr.length; j++) {
                    if (val < arr[j] - k || val > arr[j] + k) continue o;
                }
                ans = Math.max(ans, val);
            }


            if (ans == Integer.MIN_VALUE) System.out.println(-1);
            else System.out.println(ans);
        }
    }
}
