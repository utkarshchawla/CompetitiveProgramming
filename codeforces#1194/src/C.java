import java.io.*;
import java.util.*;
import java.math.BigInteger;
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int q = fr.nextInt();
        o:
        while (q-- > 0) {
            String s = fr.nextLine();
            String t = fr.nextLine();
            String p = fr.nextLine();
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < p.length(); i++) map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
            int j = 0;
            for (int i = 0; i < t.length(); i++) {
                if (j < s.length() && t.charAt(i) == s.charAt(j)) {
                    j++;
                } else if (map.containsKey(t.charAt(i))) {
                    map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
                    if (map.get(t.charAt(i)) == 0) map.remove(t.charAt(i));
                } else {
                    System.out.println("NO");
                    continue o;
                }
            }
            if (j == s.length())
                System.out.println("YES");
            else System.out.println("NO");


        }

    }
}