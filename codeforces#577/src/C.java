import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int k = fr.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextLong();
        Arrays.sort(arr);
        long[] sum = new long[n / 2 + 1];
        sum[0] = arr[n / 2];
        for (int i = n / 2 + 1; i < arr.length; i++) {
            sum[i - n / 2] = sum[i - n / 2 - 1] + arr[i];
        }
        int idx = 0;
        while (idx < sum.length) {
            long diff = arr[idx + n / 2] * 1L * (idx + 1) - sum[idx];
            if (k < diff) break;
            idx++;
        }
        idx--;
        k -= (arr[idx + n / 2] * 1L * (idx + 1) - sum[idx]);
        k /= (idx + 1);
        System.out.println(arr[idx + n / 2] + k);
    }
}
