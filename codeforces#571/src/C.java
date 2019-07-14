import java.io.*;
import java.math.BigInteger;
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
        String a = fr.nextLine();
        String b = fr.nextLine();
        int par = 0;
        for (int i = 0; i < b.length(); i++) if (b.charAt(i) == '1') par++;
        boolean flag = false;
        if (par % 2 == 0) flag = true;
        int[] arr = new int[a.length()];
        arr[0] = (a.charAt(0) == '1') ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + ((a.charAt(i) == '1') ? 1 : 0);
        }
        int ans = 0;
        for (int i = 0; i < a.length() - b.length() + 1; i++) {
            int l = (i > 0) ? arr[i - 1] : 0;
            int r = arr[i + b.length() - 1];
            if (flag && (r - l) % 2 == 1) continue;
            if (!flag && (r - l) % 2 == 0) continue;
            ans++;
        }
        System.out.println(ans);
    }
}
