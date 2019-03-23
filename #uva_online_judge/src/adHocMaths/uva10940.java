package adHocMaths;

import javax.xml.transform.Source;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class uva10940 {
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

        while (true) {
            int n = fr.nextInt();
            if (n == 0) {
                break;
            }

            if(n == 1){
                System.out.println(n);
                continue;
            }

            System.out.println(getSafePosition(n));

        }
    }

    public static int getSafePosition(int n) {
        int valueOfL = n - Integer.highestOneBit(n);
        if(valueOfL == 0){
            return n;
        }
        return 2 * valueOfL;
    }
}
