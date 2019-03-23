import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C279 {
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
        int n = fr.nextInt();
        int m = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fr.nextInt();
        ArrayList<Integer> end = new ArrayList<>();
        for (int i = 0; i < (arr.length - 1); i++) {
            if (arr[i] > arr[i + 1]) {
                while (i < (arr.length - 1) && arr[i] > arr[i + 1]) i++;
                end.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int l = fr.nextInt() - 1;
            int r = fr.nextInt() - 1;
            int el = Collections.binarySearch(end, l);
            if (el < 0) el = -(el + 1);
            int numend = 0;
            int endidx1 = -1;
            int endidx2 = -1;
            for (int i = el; i < end.size(); i++) {
                if (numend > 2) break;
                if (end.get(i) > r) break;
                if (endidx1 == -1) endidx1 = end.get(i);
                else endidx2 = end.get(i);
                numend++;
            }
            if (numend > 2) {
                sb.append("No");
            } else if (numend == 1) {
                if (endidx1 == r || endidx1 == l || arr[endidx1] == arr[r]) {
                    sb.append("Yes");
                } else sb.append("No");
            } else if (numend == 2) {
                if (endidx1 == l && endidx2 == r) sb.append("Yes");
                else sb.append("No");
            } else sb.append("Yes");
            sb.append("\n");
        }
        fw.print(sb);
        fw.close();
    }
}
