import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C285 {
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
        boolean arr[] = new boolean[n + 1];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int val = fr.nextInt();
            if (val > 0 && val < arr.length && !arr[val]) {
                arr[val] = true;
            } else list.add(val);
        }
        list.sort(null);
        long ans = 0;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (!arr[i]) {
                ans += Math.abs(i - list.get(list.size() - 1));
                list.remove(list.size() - 1);
            }
        }
        System.out.println(ans);
    }
}
