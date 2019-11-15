import java.io.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class E {
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
        int k1 = fr.nextInt();
        int k2 = fr.nextInt();
        int k3 = fr.nextInt();
        int tot = k1 + k2 + k3;
        int min = Math.min(tot - k1, Math.min(tot - k2, tot - k3));
        int steps = 0;
        HashSet<Integer> one = new HashSet<>();
        HashSet<Integer> three = new HashSet<>();
        int maxone = Integer.MIN_VALUE;
        for (int i = 0; i < k1; i++) {
            int v = fr.nextInt();
            one.add(v);
            maxone = Math.max(maxone, v);
        }
        for (int i = 0; i < k2; i++) fr.nextInt();
        for (int i = 0; i < k3; i++) three.add(fr.nextInt());
        for (int i = 1; i <= maxone; i++) {
            if (one.contains(i)) continue;
            steps++;
            three.remove(i);
        }
        int minthree = Integer.MAX_VALUE;
        for (int i : three) minthree = Math.min(minthree, i);
        for (int i = minthree; i <= tot; i++) {
            if (three.contains(i)) continue;
            steps++;
        }
        System.out.println(Math.min(min, steps));
    }
}
