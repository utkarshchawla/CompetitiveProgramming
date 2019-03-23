import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C_2 {
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
        int one;
        long two = Long.MAX_VALUE;
        long three = Long.MAX_VALUE;
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
            arr[i].one = fr.nextInt();
        }

        long ans = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if(arr[i].font <= arr[j].font)continue;
                arr[i].two = Math.min(arr[i].two, arr[j].one);
                arr[i].three = Math.min(arr[i].three, arr[j].two);
            }
            if (arr[i].two < Long.MAX_VALUE)
                arr[i].two += arr[i].one;
            if (arr[i].three < Long.MAX_VALUE)
                arr[i].three += arr[i].one;
            ans = Math.min(ans, arr[i].three);
        }
        if(ans == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);

    }
}
