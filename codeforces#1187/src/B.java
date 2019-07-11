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
        int n = fr.nextInt();
        String s = fr.nextLine();
        int[][] arr = new int[n][26];
        arr[0][s.charAt(0) - 'a']++;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < arr[0].length; j++) arr[i][j] = arr[i - 1][j];
            arr[i][s.charAt(i) - 'a']++;
        }
        int m = fr.nextInt();
        while (m-- > 0) {
            String f = fr.nextLine();
            int[] check = new int[26];
            for (int i = 0; i < f.length(); i++) check[f.charAt(i) - 'a']++;
            int lo = 0;
            int hi = n;
            int ans = Integer.MAX_VALUE;
            while (lo <= hi) {
                int mid = (hi + lo) / 2;
                if (isOk(check, mid, arr)) {
                    ans = Math.min(ans, mid);
                    hi = mid - 1;
                } else lo = mid + 1;
            }
            System.out.println(ans + 1);
        }
    }

    public static boolean isOk(int[] check, int i, int[][] arr) {
        int[] na = arr[i];
        for (int j = 0; j < check.length; j++) {
            if (check[j] > na[j]) return false;
        }

        return true;
    }
}
