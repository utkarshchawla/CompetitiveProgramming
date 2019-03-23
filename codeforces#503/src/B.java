import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;
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
        int[] arr = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt() - 1;
        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            int temp = i;
            set.add(temp);
            while (true) {
                if (set.contains(arr[temp])) {
                    ans[i] = arr[temp] + 1;
                    break;
                }
                set.add(arr[temp]);
                temp = arr[temp];
            }
        }
        for (int i : ans) System.out.print(i + " ");

    }
}
