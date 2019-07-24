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
        int w = fr.nextInt();
        int h = fr.nextInt();
        int mod = 998244353;
        long ans = 1;
        boolean[][] arr = new boolean[w][h];
        for(int i = 0; i < w; i++)for(int j = 0; j < h; j++){
            long val = 4;
            if(i - 1 >= 0 && arr[i - 1][j])val/=2;
            if(j - 1 >= 0 && arr[i][j - 1])val/= 2;
            if(i + 1 < w && arr[i + 1][j])val/= 2;
            if(j + 1 < h && arr[i][j + 1])val/= 2;
            ans = ((ans%mod)*(val%mod))%mod;
            arr[i][j] = true;
        }
        System.out.println(ans);
    }
}
