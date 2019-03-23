import java.io.*;
import java.util.StringTokenizer;

public class subset_sum {
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
        int set[] = {2, 3, 7, 8, 10};
//        subsetSumAll(set, 14, 0, "");
        int[][] arr = new int[15][6];
        System.out.println(subsetSumTD(set, 14, 0,arr));
    }

    public static void subsetSumAll(int[] set, int target, int vidx, String ans) {
        if (target < 0) {
            return;
        }
        if (vidx == set.length) {
            if (target == 0) {
                System.out.println(ans);
            }
            return;
        }
        subsetSumAll(set, target, vidx + 1, ans);
        subsetSumAll(set, target - set[vidx], vidx + 1, ans + " " + set[vidx]);
    }

    public static boolean subsetSumTD(int[] set, int target, int vidx, Boolean[][] arr) {
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        if (vidx == set.length && target != 0) {
            return false;
        }

        return subsetSumTD(set, target, vidx + 1, arr) || subsetSumTD(set, target - set[vidx], vidx + 1, arr);
    }

}
