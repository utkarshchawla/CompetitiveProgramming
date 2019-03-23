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

    public static class pair {
        int font;
        int price;

    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        pair[] arr = new pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new pair();
            arr[i].font = fr.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i].price = fr.nextInt();
        }

        long ans = Long.MAX_VALUE;
        for (int k = 0; k < arr.length; k++) {
            int i = k - 1;
            int j = k + 1;
            long mina = Long.MAX_VALUE;
            while (i >= 0) {
                if (arr[i].font < arr[k].font) mina = Math.min(mina, arr[i].price);
                i--;
            }
            if(mina == Long.MAX_VALUE)continue;
            long minb = Long.MAX_VALUE;
            while (j < arr.length) {
                if (arr[k].font < arr[j].font) minb = Math.min(minb, arr[j].price);
                j++;
            }
            if(minb == Long.MAX_VALUE)continue;
            Long val = arr[k].price + mina + minb;
            ans = Math.min(ans, val);
        }
        if(ans == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}
