import java.io.*;
import java.math.BigInteger;
import java.util.*;

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
        int t = fr.nextInt();
        o:
        while (t-- > 0) {
            int n = fr.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = fr.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                if (map.containsKey(arr[i])) list = map.get(arr[i]);
                list.add(i);
                map.put(arr[i], list);
            }
            int ans = Integer.MAX_VALUE;
            for (ArrayList<Integer> tl : map.values()) {
                for (int i = 0; i < tl.size() - 1; i++) {
                    ans = Math.min(ans, tl.get(i + 1) - tl.get(i) + 1);
                }
            }
            if (ans == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(ans);
        }
    }
}
