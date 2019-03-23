import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class D {
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        String s = fr.nextLine();
        StringBuilder sb = new StringBuilder(s);
        HashSet<Character> set = new HashSet<>();
        set.add('R');
        set.add('B');
        set.add('G');
        int count = 0;
        for (int i = 0; i < sb.length() - 1; i++) {
            HashSet<Character> hola = new HashSet<>(set);
            if (sb.charAt(i) == sb.charAt(i + 1)) {
                count++;
                hola.remove(sb.charAt(i));
                if (i + 2 < sb.length()) hola.remove(sb.charAt(i + 2));
                if (hola.contains('R')) sb.setCharAt(i + 1, 'R');
                else if (hola.contains('G')) sb.setCharAt(i + 1, 'G');
                else sb.setCharAt(i + 1, 'B');
            }
        }
        System.out.println(count);
        System.out.println(sb);
    }
}
