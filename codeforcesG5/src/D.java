import java.io.*;
import java.math.BigInteger;
import java.util.*;

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

    static class pair implements Comparable<pair> {
        double val;
        int idx;

        @Override
        public int compareTo(pair o) {
            return (int) (o.val - this.val);
        }

        pair(double val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        double[] arr = new double[n * 2];
        int[] half = new int[n];
        Arrays.fill(half, -1);
        int[] large = new int[n];
        Arrays.fill(large, -1);
        int[] ans = new int[n];
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        int idx = -1;
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            arr[i] = fr.nextDouble();
            arr[i + n] = arr[i];
            min = Math.min(arr[i], min);
            if (arr[i] > max) {
                max = arr[i];
                idx = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            while (pq.size() > 0 && arr[i] * 2 < pq.peek().val) {
                pair top = pq.poll();
                if (half[top.idx % n] == -1) half[top.idx % n] = i % n;
            }
            pq.add(new pair(arr[i], i));
        }
        LinkedList<pair> ll = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            while (ll.size() > 0 && arr[i] >= ll.getFirst().val) {
                pair top = ll.removeFirst();
                if (large[top.idx % n] == -1) large[top.idx % n] = i % n;
            }
            ll.addFirst(new pair(arr[i], i));
        }

        if (max <= min * 2) ans[idx] = -1;
        else {
            int count = 1;
            for (int i = (idx + 1) % n; ; i = (i + 1) % n) {
                if (arr[i] < max / 2) break;
                count++;
            }
            ans[idx] = count;
        }

        for (int i = idx - 1; i >= 0; i--) {
            int hidx = half[i];
            int lidx = large[i];
            if (hidx == -1 || (lidx - i > 0 && hidx - i < 0) || (lidx < hidx)) {
                if (ans[lidx] == -1) ans[i] = -1;
                else ans[i] = ans[lidx] + ((lidx - i > 0) ? lidx - i : lidx + n - i);
            } else {
                ans[i] = (hidx - i > 0) ? hidx - i : hidx + n - i;
            }
        }

        for (int i = n - 1; i > idx; i--) {
            int hidx = half[i];
            int lidx = large[i];
            if (hidx == -1 || (lidx - i > 0 && hidx - i < 0) || (lidx - i > 0 && hidx - i > 0 && lidx < hidx) || (lidx - i < 0 && hidx - i < 0 && lidx < hidx)) {
                if (ans[lidx] == -1) ans[i] = -1;
                else ans[i] = ans[lidx] + ((lidx - i > 0) ? lidx - i : lidx + n - i);
            } else {
                ans[i] = (hidx - i > 0) ? hidx - i : hidx + n - i;
            }
        }

        for (int i : ans) fw.print(i + " ");
        fw.close();


    }
}
