import java.io.*;
import java.util.Dictionary;
import java.util.StringTokenizer;

public class editdist {
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
        System.out.println(editDistTD("abcdef", "a"));
        System.out.println(editDistBU("abcdef", "a"));

    }

    public static int editDistTD(String s1, String s2) {

        if (s1.length() == 0) {
            return s2.length();
        }

        if (s2.length() == 0) {
            return s1.length();
        }

        char c1 = s1.charAt(0);
        char c2 = s2.charAt(0);

        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);

        if (c1 == c2) {
            return editDistTD(ros1, ros2);
        }

        return 1 + Math.min(editDistTD(s1, ros2), Math.min(editDistTD(ros1, s2), editDistTD(ros1, ros2)));

    }

    public static int editDistBU(String s1, String s2) {
        int[][] strg = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i < strg.length; i++) {
            for (int j = 0; j < strg[0].length; j++) {
                if (i == 0) {
                    strg[i][j] = j;
                } else if (j == 0) {
                    strg[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    strg[i][j] = strg[i - 1][j - 1];
                } else {
                    strg[i][j] = 1 + Math.min(strg[i - 1][j], Math.min(strg[i][j - 1], strg[i - 1][j - 1]));
                }

            }
        }

        return strg[strg.length - 1][strg[0].length - 1];
    }
}


