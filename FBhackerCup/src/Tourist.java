import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Tourist {
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
        FastReader fr = new FastReader( );
        FastWriter fw = new FastWriter();
        long t = fr.nextLong();
        for (int c = 1; c <= t; c++) {
            long n = fr.nextLong();
            long k = fr.nextLong();
            long v = fr.nextLong();
            String[] arr = new String[(int) n];
            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextLine();
            }
            long idx = (k * (v - 1)) % n;
            int[] ans = new int[(int) k];
            for (int i = 0; i < k; i++) {
                ans[i] = (int) ((i + idx) % n);
            }
            Arrays.sort(ans);
            fw.print("Case #" + c + ": ");
            for (int i = 0; i < ans.length; i++) {
                fw.print(arr[ans[i]]);
                if (i < ans.length - 1) fw.print(" ");
            }
            fw.println("");
        }
        fw.close();
    }
}
