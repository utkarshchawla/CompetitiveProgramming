import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C {
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
        long n = fr.nextLong();
        long m = fr.nextLong();
        long[] arr = new long[(int) n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextLong();
        Arrays.sort(arr);
        long[] presum = new long[arr.length];
        presum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) presum[i] = arr[i] + presum[i - 1];
        long ans[] = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            long val = presum[i];
            if (i - m >= 0) val += ans[(int) (i - m)];
            ans[i] = val;
        }
        for (int i = 0; i < ans.length; i++) {
            fw.print(ans[i] + " ");
        }
        fw.println("");
        fw.close();

    }
}
