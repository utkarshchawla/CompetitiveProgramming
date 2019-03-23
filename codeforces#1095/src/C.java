import java.io.*;
import java.math.BigInteger;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
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
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int k = fr.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) queue.add((int) Math.pow(2, count));
            n /= 2;
            count++;
        }
        if (k < queue.size()) {
            System.out.println("NO");
            return;
        }
        while (queue.size() != k) {
            int val = queue.poll();
            if (val == 1) break;
            queue.add(val / 2);
            queue.add(val / 2);
        }

        if (queue.size() != k) System.out.println("NO");
        else {
            System.out.println("YES");
            while (!queue.isEmpty()) System.out.print(queue.poll() + " ");
            System.out.println();
        }

    }
}
