import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B433 {
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
        int n = fr.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
        long sum[] = new long[n];
        long sumSort[] = new long[n];
        sum[0] = arr[0];
        for (int i = 1; i < sum.length; i++) sum[i] = arr[i] + sum[i - 1];
        Arrays.sort(arr);
        sumSort[0] = arr[0];
        for (int i = 1; i < sumSort.length; i++) sumSort[i] = arr[i] + sumSort[i - 1];
        int m = fr.nextInt();
        while (m-- > 0) {
            int type = fr.nextInt();
            if (type == 1) {
                int l = fr.nextInt() - 2;
                int r = fr.nextInt() - 1;
                long ans = sum[r];
                if(l >= 0)ans -= sum[l];
                fw.println(ans);
            } else {
                int l = fr.nextInt() - 2;
                int r = fr.nextInt() - 1;
                long ans = sumSort[r];
                if(l >= 0)ans -= sumSort[l];
                fw.println(ans);
            }
        }
        fw.close();
    }
}
