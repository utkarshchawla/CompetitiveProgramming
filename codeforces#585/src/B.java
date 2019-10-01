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
        long n = fr.nextLong();
        long[] arr = new long[(int) n];
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            long val = fr.nextLong();
            if (val > 0) arr[i] = 1;
            else {
                arr[i] = -1;
                count++;
            }
        }
        long[] pre = new long[(int) n];
        if (arr[0] == -1) pre[0] = 1;
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1];
            if (arr[i] == -1) pre[i]++;
        }
        long[] odd = new long[(int) n];
        long[] even = new long[(int) n];
        if (pre[0] == 0) even[0] = 1;
        else odd[0] = 1;
        for (int i = 1; i < n; i++) {
            odd[i] = odd[i - 1];
            even[i] = even[i - 1];
            if (pre[i] % 2 == 0) even[i]++;
            else odd[i]++;
        }
        long neg = count;
        if (1 < n && pre[1] % 2 == 1) neg++;
        for (int i = 2; i < n; i++) {
            if (pre[i] % 2 == 0) {
                neg += odd[i - 2];
            } else neg += even[i - 2] + 1;
        }

        System.out.println(neg + " " + ((n * 1L * (n + 1) / 2) - neg));
    }
}
