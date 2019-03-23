import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class B {
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

    public static class pair implements Comparable<pair> {
        int pow;
        long coin;
        long newcoin;
        int idx;

        @Override
        public int compareTo(pair o) {
            return this.pow - o.pow;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int k = fr.nextInt();
        pair[] arr = new pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new pair();
            arr[i].pow = fr.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i].coin = fr.nextInt();
            arr[i].idx = i;
        }

        Arrays.sort(arr);
        long sum = 0;
        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (int i = 1; i < arr.length; i++) {
            queue.add(arr[i - 1].coin);
            sum += arr[i - 1].coin;
            if (queue.size() > k) {
                sum -= queue.poll();
            }
            arr[i].newcoin = sum;
        }
        Comparator<pair> comp = new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.idx - o2.idx;
            }
        };
        Arrays.sort(arr, comp);
        for (pair anArr : arr) {
            long val = anArr.newcoin + anArr.coin;
            System.out.print(val + " ");
        }
        System.out.println();


    }
}
