import java.io.*;
import java.util.*;

public class lis {
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

//        int arr[] = {-7, 10, 9, 2, 3, 8, 8, 1};
        int arr[] = {8, 9, 1, 2, 3, 4};
        System.out.println(lisiter(arr));
    }

    public static int lisiter(int[] arr) {
        int[] strg = new int[arr.length];
        strg[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int maxlis = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    maxlis = Math.max(maxlis, 1 + strg[j]);
                }
            }
            strg[i] = maxlis;
        }

        Arrays.sort(strg);
        return strg[arr.length - 1];
    }

}