import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

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

    static class pair implements Comparable<pair> {
        int p;
        int c;

        pair(int p, int c) {
            this.p = p;
            this.c = c;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof pair)) {
                return false;
            }
            pair otherNode = (pair) other;
            return p == otherNode.p && c == otherNode.c;
        }

        @Override
        public int hashCode() {
            return p * 31 + c * 17;
        }

        @Override
        public int compareTo(pair o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();
        int n = fr.nextInt();
        int m = fr.nextInt();
        PriorityQueue<Integer>[] partyMain = new PriorityQueue[m + 1];
        for (int i = 0; i < partyMain.length; i++) partyMain[i] = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int p = fr.nextInt();
            int c = fr.nextInt();
            partyMain[p].add(c);
        }
        long ans = Long.MAX_VALUE;
        for (int x = 1; x <= (n / 2 + 1); x++) {
            PriorityQueue<Integer>[] party = new PriorityQueue[m + 1];
            for (int i = 0; i < party.length; i++) party[i] = new PriorityQueue<>(partyMain[i]);
            long curr = party[1].size();
            long cost = 0;
            for (int i = 2; i < party.length; i++) {
                while (party[i].size() >= x) {
                    curr++;
                    int temp = party[i].poll();
                    cost += temp;
                }
            }
            PriorityQueue<Integer> q = new PriorityQueue<>();
            for (int i = 2; i < party.length; i++) {
                PriorityQueue<Integer> qt = party[i];
                q.addAll(qt);
            }
            while (q.size() >= 0 && curr < x) {
                cost += q.poll();
                curr++;
            }
            ans = Math.min(ans, cost);
        }
        System.out.println(ans);
    }
}
