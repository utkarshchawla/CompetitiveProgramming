import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class coins {
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
        int[] arr = {1, 3, 4, 5};
        System.out.println(coinsTD(arr, 7));
        System.out.println(coinsBU(arr, 7));
        coinstotal(arr, 7, "", 0);
        System.out.println(coinstotalBetter(arr,7));

    }

    public static int coinsTD(int[] arr, int sum) {
        if (sum == 0) {
            return 0;
        }

        if (sum < 0) {
            return 100000;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            ans = Math.min(ans, 1 + coinsTD(arr, sum - arr[i]));
        }
        return ans;
    }

    public static int coinsBU(int[] arr, int sum) {
        int[] strg = new int[sum + 1];
        int[] ans = new int[sum + 1];
        Arrays.fill(strg, 100000);
        strg[0] = 0;
        for (int val : arr) {
            for (int j = 0; j < strg.length; j++) {
                if (j - val >= 0) {
                    if (1 + strg[j - val] < strg[j]) {
                        ans[j] = val;
                    }
                    strg[j] = Math.min(strg[j], 1 + strg[j - val]);

                }

            }
        }

        int i = ans.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (i > 0) {
            list.add(ans[i]);
            i -= ans[i];
        }
        System.out.println(list);
        return strg[strg.length - 1];
    }

    public static void coinstotal(int[] arr, int sum, String ans, int vidx) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            System.out.println(ans);
            return;
        }

        if (vidx == arr.length) {
            return;
        }
        coinstotal(arr, sum, ans, vidx + 1);
        coinstotal(arr, sum - arr[vidx], ans + arr[vidx], vidx);
    }

    public static int coinstotalBetter(int[] arr, int sum) {
        int[][] strg = new int[arr.length][sum + 1];
        for (int i = 0; i < strg.length; i++) {
            for (int j = 0; j < strg[0].length; j++) {
                if (j == 0) {
                    strg[i][j] = 1;
                } else {
                    if (i - 1 >= 0)
                        strg[i][j] = strg[i - 1][j];
                    if (j - arr[i] >= 0)
                        strg[i][j] += strg[i][j - arr[i]];
                }
            }
        }

        return strg[strg.length - 1][strg[0].length - 1];
    }

}
