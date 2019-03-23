import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int[] arr = new int[n];
        int sum = 0;
        String num = fr.nextLine();
        for (int i = 0; i < num.length(); i++) {
            arr[i] = num.charAt(i) - '0';
            sum += arr[i];
        }
        boolean flag = false;
        for (int len = 2; len <= n; len++) {
            if (sum % len != 0) continue;
            if (isok(sum / len, arr, len)) flag = true;
        }
        if (flag) System.out.println("YES");
        else System.out.println("NO");

    }

    private static boolean isok(int n, int[] arr, int len) {
        int curr = 0;
        int count = 0;
        for (int i : arr) {
            curr += i;
            if (curr > n) return false;
            if (curr == n) {
                curr = 0;
                count++;
            }
        }
        return count == len;
    }
}