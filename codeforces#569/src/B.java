import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
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

    static class pair {
        int val;
        int idx;

        pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        pair[] arr = new pair[n];
        for (int i = 0; i < arr.length; i++) {
            int val = fr.nextInt();
            if (val < 0) val = -val - 1;
            arr[i] = new pair(val, i);
        }
        Arrays.sort(arr, (o1, o2) -> o2.val - o1.val);
        if (arr.length > 1) {
            for (int i = arr.length - 1; i >= 1; i -= 2) {
                arr[i].val = -arr[i].val - 1;
                arr[i - 1].val = -arr[i - 1].val - 1;
            }
        }
//        if (arr[0].val == 0) {
//            arr[0].val = -1;
//            if (arr[arr.length - 1].val != -1 || arr.length % 2 == 1)
//                arr[arr.length - 1].val = -arr[arr.length - 1].val - 1;
//        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o.idx));


        for (pair i : arr) System.out.print(i.val + " ");

    }

}

