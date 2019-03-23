import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class B224 {
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
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) arr[i] = fr.nextInt();
        int l = 0;
        int r = 0;
        int ar = -1;
        int al = -1;
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < arr.length) {
            if (map.containsKey(arr[r])) map.put(arr[r], map.get(arr[r]) + 1);
            else map.put(arr[r], 1);
            if (map.size() == k) {
                while (map.size() != k - 1) {
                    map.put(arr[l], map.get(arr[l]) - 1);
                    if (map.get(arr[l]) == 0) map.remove(arr[l]);
                    l++;
                }
                if (r - l + 2 < min) {
                    ar = r;
                    al = l - 1;
                    min = r - l + 2;
                }
            }
            r++;
        }
        if (ar == -1) System.out.println(-1 + " " + -1);
        else System.out.println(al + 1 + " " + (ar + 1));
    }
}
