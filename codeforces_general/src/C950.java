import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C950 {
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


    public static class pair {
        StringBuilder s;
        int length;

        pair(StringBuilder s, int length) {
            this.s = s;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        FastWriter fw = new FastWriter();
        FastReader fr = new FastReader();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = fr.nextLine();
        boolean flag = true;

        ArrayList<pair> good = new ArrayList<>();
        ArrayList<pair> bad = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (bad.size() > 0) {
                    pair str = bad.remove(bad.size() - 1);
                    if (str.s.length() == 1) {
                        flag = false;
                        break;
                    }
                    str.s.append(" ");
                    str.s.append((i + 1));
                    str.length++;
                    good.add(str);
                } else {
                    good.add(new pair(new StringBuilder(i + 1 + ""), 1));
                }
            } else {
                if (good.size() > 0) {
                    pair str = good.remove(good.size() - 1);
                    str.s.append(" ");
                    str.s.append((i + 1));
                    str.length++;
                    bad.add(str);
                } else {
                    bad.add(new pair(new StringBuilder(i + 1 + ""), 1));
                }
            }
        }

        if (bad.size() > 0) {
            flag = false;
        }

//        for (pair sg : good) {
//            if (s.charAt(Integer.parseInt((sg.s.charAt(0) - 1 - '0') + "")) == '1') {
//                flag = false;
//            }
//        }

        if (flag) {
//            System.out.println(good.size());
            fw.println(good.size());
            for (pair sg : good) {
//                System.out.print(sg.length + " ");
                fw.print(sg.length + " ");
//                System.out.println(sg.s);
                fw.println(String.valueOf(sg.s));
            }
        } else {
//            System.out.println(-1);
            fw.println(-1);
        }
        fw.close();
    }
}
