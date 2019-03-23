import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class E {
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

    static class pair {
        int left;
        int right;

        pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        String s = fr.nextLine();
        pair[] arr = new pair[n];
        arr[0] = new pair(0, 0);
        if (s.charAt(0) == '(') arr[0].left++;
        else arr[0].right++;
        for (int i = 1; i < n; i++) {
            arr[i] = new pair(arr[i - 1].left, arr[i - 1].right);
            if (s.charAt(i) == '(') arr[i].left++;
            else arr[i].right++;

            if (arr[i].right - arr[i].left > 2) {
                System.out.println(0);
                return;
            }
        }
        int ans = 0;
        if (Math.abs(arr[arr.length - 1].right - arr[arr.length - 1].left) != 2) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) {
                int pr = arr[i - 1].right;
                int pl = arr[i - 1].left;
                if (pr > pl) break;
            }
            int tr = arr[arr.length - 1].right;
            int tl = arr[arr.length - 1].left;

            int cr = arr[i].right;
            int cl = arr[i].left;
            if (s.charAt(i) == '(') {
                if (tl - 1 == tr + 1 && cl - 1 >= cr + 1) ans++;
            } else {
                if (tl + 1 == tr - 1 && cl + 1 >= cr - 1) ans++;
            }
        }

        System.out.println(ans);

    }

}
