import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class C {
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

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        String s = fr.nextLine();
        String t = fr.nextLine();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.charAt(i) == 'a') a.add(i + 1);
                else b.add(i + 1);
            }
        }
        if ((a.size() + b.size()) % 2 == 1) System.out.println(-1);
        else {
            if (a.size() % 2 == 0) {
                fw.println(a.size() / 2 + b.size() / 2);
                for (int i = 0; i < a.size(); i += 2) {
                    fw.println(a.get(i) + " " + a.get(i + 1));
                }
                for (int i = 0; i < b.size(); i += 2) {
                    fw.println(b.get(i) + " " + b.get(i + 1));
                }
            } else {
                fw.println(a.size() / 2 + b.size() / 2 + 2);
                for (int i = 0; i < a.size() - 1; i += 2) {
                    fw.println(a.get(i) + " " + a.get(i + 1));
                }
                for (int i = 0; i < b.size() - 1; i += 2) {
                    fw.println(b.get(i) + " " + b.get(i + 1));
                }

                fw.println(b.get(b.size() - 1) + " " + b.get(b.size() - 1));
                fw.println(b.get(b.size() - 1) + " " + a.get(a.size() - 1));
            }
        }
        fw.close();
    }
}
