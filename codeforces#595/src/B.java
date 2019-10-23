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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int q = fr.nextInt();
        while (q-- > 0) {
            int n = fr.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt() - 1;
            int[] ans = new int[n];
            for (int i = 0; i < arr.length; i++) {
                if (ans[i] != 0) continue;
                HashSet<Integer> set = new HashSet<>();
                int count = 1;
                set.add(i);
                int j = arr[i];
                while (i != j) {
                    set.add(j);
                    j = arr[j];
                    count++;
                }
                for (int k : set) ans[k] = count;
            }
            for (int i : ans) fw.print(i + " ");
            fw.println("");
        }
        fw.close();
    }
}