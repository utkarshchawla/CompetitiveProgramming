import java.io.*;
import java.util.StringTokenizer;

public class textJustification {
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
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        String[] arr = {"tushar", "roy", "likes", "to", "code"};
        int width = 10;
        int[][] strg = new int[arr.length + 1][arr.length + 1];
//        String[] arr = {"aaa", "bb", "cc", "ddddd"};
        System.out.println(textJustTD(arr, 0, arr.length - 1, width, strg));
    }

    public static int textJustTD(String[] arr, int si, int fi, int l, int[][] strg) {
        if (strg[si][fi] != 0) {
            return strg[si][fi];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = si; i < fi; i++) {
            int val1 = 0;
            for (int j = si; j <= i; j++) {
                val1 += arr[j].length() + 1;
            }
            val1--;
            if (val1 > l) {
                val1 = textJustTD(arr, si, i, l, strg);
            } else {
                val1 = (l - val1) * (l - val1);
            }
            int val2 = 0;
            for (int j = i + 1; j <= fi; j++) {
                val2 += arr[j].length() + 1;
            }
            val2--;
            if (val2 > l) {
                val2 = textJustTD(arr, i + 1, fi, l, strg);
            } else {
                val2 = (l - val2) * (l - val2);
            }

            ans = Math.min(ans, val1 + val2);

        }
        return strg[si][fi] = ans;


    }
}
