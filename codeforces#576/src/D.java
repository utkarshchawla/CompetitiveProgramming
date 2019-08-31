import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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

    static class query {
        int type;
        int idx;
        int val;
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
        int q = fr.nextInt();
        query[] queries = new query[q];
        for (int i = 0; i < q; i++) {
            int type = fr.nextInt();
            queries[i] = new query();
            queries[i].type = type;
            if (type == 1) {
                queries[i].idx = fr.nextInt() - 1;
                queries[i].val = fr.nextInt();
            } else {
                queries[i].val = fr.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        boolean[] ismod = new boolean[n];
        for (int i = queries.length - 1; i >= 0; i--) {
            if (queries[i].type == 2) max = Math.max(max, queries[i].val);
            else {
                if (ismod[queries[i].idx]) continue;
                arr[queries[i].idx] = Math.max(queries[i].val, max);
                ismod[queries[i].idx] = true;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (!ismod[i]) val = Math.max(val, max);
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
