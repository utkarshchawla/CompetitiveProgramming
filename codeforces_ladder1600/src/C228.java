import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C228 {
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
        Integer arr[] = new Integer[n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
        int hi = n;
        int lo = 1;
        Arrays.sort(arr, Collections.reverseOrder());
        int ans = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (isOk(mid, arr)) {
                ans = Math.min(ans, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean isOk(int mid, Integer[] arr) {
        int[] pos = new int[mid];
        for (int i = 0; i < mid; i++) pos[i] = arr[i];
        for (int i = mid; i < arr.length; i++) {
            if (pos[i % mid] > 0) {
                pos[i % mid] = Math.min(pos[i % mid] - 1, arr[i]);
            } else return false;
        }
        return true;

    }
}
