import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class knapsack {
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
        int[] values = {1, 4, 5, 7};
//        int[] values = {2, 10, 5, 6, 8};
//        int[] weights = {12, 15, 9, 5, 10};
        int[] weights = {1, 3, 4, 5};
        int w = 30;
        int[][] strg = new int[values.length][w + 1];
        for (int[] arr : strg) Arrays.fill(arr, -1);
        System.out.println(knapsackTD(values, weights, 0, w, strg));
//        System.out.println(knapsackBD(values, weights, w));

    }

    public static int knapsackTD(int[] values, int[] weights, int vidx, int w, int[][] strg) {
        if (vidx == values.length) {
            return 0;
        }

        if (strg[vidx][w] != -1) {
            System.out.println(vidx + " " + w);
            return strg[vidx][w];
        }
        int a = knapsackTD(values, weights, vidx + 1, w, strg);
        int b = 0;
        if (w - weights[vidx] >= 0) {
            b = values[vidx] + knapsackTD(values, weights, vidx + 1, w - weights[vidx], strg);
        }
        return strg[vidx][w] = Math.max(a, b);
    }

    public static int knapsackBD(int[] values, int[] weights, int w) {
        int[][] strg = new int[values.length][w + 1];
        for (int i = 0; i < strg.length; i++) {
            for (int j = 0; j < strg[0].length; j++) {
                if (j == 0) {
                    strg[i][j] = 0;
                } else if (j < weights[i]) {
                    if (i > 0)
                        strg[i][j] = strg[i - 1][j];
                } else {
                    if (i > 0) {
                        strg[i][j] = Math.max(strg[i - 1][j], strg[i - 1][j - weights[i]] + values[i]);
                    } else {
                        strg[i][j] = values[i];
                    }
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        int i = strg.length - 1;
        int j = strg[0].length - 1;
        while (j > 0 && i >= 0) {
            if ((i - 1 >= 0 && strg[i][j] != strg[i - 1][j]) || i == 0) {
                list.add(i);
                j -= weights[i];
            }
            i--;
        }
        list.sort(null);
        System.out.println(list);

        return strg[strg.length - 1][strg[0].length - 1];
    }


}
