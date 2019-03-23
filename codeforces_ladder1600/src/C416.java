import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class C416 {
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

    static class pair implements Comparable<pair> {
        int c;
        int p;
        int idx;

        pair(int c, int p, int idx) {
            this.c = c;
            this.p = p;
            this.idx = idx;
        }

        @Override
        public int compareTo(pair o) {
            return o.p - this.p;
        }
    }

    static class pair2 {
        int a;
        int b;

        pair2(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        pair[] arr = new pair[n];
        for (int i = 0; i < n; i++) arr[i] = new pair(fr.nextInt(), fr.nextInt(), i);
        Arrays.sort(arr);
        int k = fr.nextInt();
        int[] seat = new int[k];
        for (int i = 0; i < k; i++) seat[i] = fr.nextInt();
        int ans = 0;
        int count = 0;
        pair2[] req = new pair2[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < seat.length; j++) {
                if (arr[i].c <= seat[j] && seat[j] < min && !set.contains(j)) {
                    idx = j;
                    min = seat[j];
                }
            }
            req[i] = new pair2(arr[i].idx, idx);
            if (idx != -1) {
                set.add(idx);
                ans += arr[i].p;
                count++;
            }
        }
        System.out.println(count + " " + ans);
        for (pair2 aReq : req) {
            if (aReq.b != -1) System.out.println((aReq.a + 1) + " " + (aReq.b + 1));
        }
    }

}
